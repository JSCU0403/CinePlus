package store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;
import store.model.StoreCardBean;
import store.model.StoreCartBean;
import store.model.StoreCartList;
import store.model.StoreCouponDao;
import store.model.StoreCoupon_UserBean;
import store.model.StorePaymentBean;
import store.model.StorePaymentDao;
import store.model.StoreProductBean;
import store.model.StoreProductDao;
 
@Controller
public class StorePayController {
	private final String command = "/pay.store";
	private final String getPayPage = "";

	@Autowired
	StorePaymentDao storePaymentDao;
	
	@Autowired
	StoreProductDao storeProductDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	StoreCouponDao storeCouponDao;
	
	@RequestMapping(command)
	public String order(
			@ModelAttribute("storeCardBean") StoreCardBean storeCardBean,
			@ModelAttribute("StorePaymentBean") StoreCardBean StorePaymentBean,
			@RequestParam("sale_pay") int sale_pay,
			@RequestParam("use_coupon_code") String use_coupon_code,
			@RequestParam("total_point") String total_point,
			HttpSession session,HttpServletResponse response
			) throws IOException {
		response.setCharacterEncoding("EUC-KR");
		PrintWriter writer;
		
		writer = response.getWriter();
		MemberBean id = (MemberBean) session.getAttribute("loginInfo");
		
		StoreCartList cart = (StoreCartList)session.getAttribute("cart");
		Map<Integer,Integer> product_order_qty = cart.getAllCartList(); //{8=3, 13=1, 15=2}
		//상품의 코드 기준으로 주문 갯수가 저장되있는 map <코드,갯수> 반환
		
		List<StoreCartBean> cartBeanList = new ArrayList<StoreCartBean>();
		//StoreCartBean에 저장된 변수기준으로 주문 list생성(주문한 상품의 정보가 담겨있음)
		
		Set<Integer> keylist = product_order_qty.keySet(); //[8, 13, 15]
		//상품의 주문 갯수가 저장되있는 map의 key값(상품코드)을 불러와서 set컬렉션에 keylist로 저장
		
		for(Integer product_code:keylist) { //map에 담긴 상품정보를 장바구니에 상품코드 기준으로 넘기기
			StoreCartBean shop = new StoreCartBean();//장바구니 bean 객체 생성
			StoreProductBean storeProductBean = storeProductDao.getProducDetailByNum(product_code);//상품코드 기준으로 정보 불러오기
			shop.setProduct_image(storeProductBean.getProduct_image());
			shop.setProduct_code(storeProductBean.getProduct_code());
			shop.setProduct_name(storeProductBean.getProduct_name());
			shop.setProduct_price(storeProductBean.getProduct_price());
			shop.setProduct_sprice(storeProductBean.getProduct_sprice());
			shop.setProduct_point(storeProductBean.getProduct_point());
			shop.setCart_qty(product_order_qty.get(product_code));
			cartBeanList.add(shop); //cartBeanList는 StoreCartBean을 주입받는다
		}
		
		StorePaymentBean storePaymentBean = new StorePaymentBean();
		
		String payment_code = storePaymentDao.createPayCode();//결제코드 생성
//		System.out.println("카드번호 : "+storeCardBean.getCard_number());
//		System.out.println("결제코드 : "+ payment_code);
//		System.out.println("카드사 : "+storeCardBean.getCard_company());
//		System.out.println("월월/년년 : "+storeCardBean.getCard_mmyy());
//		System.out.println("패스워드2자리 : "+storeCardBean.getCard_pw());
//		System.out.println("할부개월 : "+storeCardBean.getCard_installment());
		storeCardBean.setPayment_code(payment_code);
		storePaymentBean.setPayment_code(payment_code); //결제코드 수동으로 주입
		storePaymentBean.setCard_number(storeCardBean.getCard_number());//카드번호 주입
		storePaymentBean.setPayment_sale_pay(sale_pay);//카드번호 주입
		storePaymentBean.setMember_code(id.getMember_code());//멤버코드 주입
		int check1 = -1;
		int check2 = -1;
		int cnt = -1;
		check1 = storePaymentDao.paymentOrder_card(storeCardBean);//결제 
		System.out.println("장바구니 물품 수 : "+keylist.size());
		if(check1 == 1) {//카드 입력 성공시
			for(int i=0;i<keylist.size();i++) {//장바구니에 들어있는 상품의 수량만큼 결제 시도
				storePaymentBean.setProduct_code(cartBeanList.get(i).getProduct_code());
				storePaymentBean.setProduct_order_qty(cartBeanList.get(i).getCart_qty());
				storePaymentBean.setPayment_sale_pay(sale_pay);
				check2 = storePaymentDao.paymentOrder_payment(storePaymentBean);
			}
			if(check2 != 0 | check2 != -1) {//결제정보 insert 성공시
				System.out.println("주문 포인트 : "+total_point);
				
				MemberBean memberBean = new MemberBean();
				memberBean.setMember_code(id.getMember_code());
				memberBean.setMember_point(total_point);
				cnt = memberDao.updateUserPoint(memberBean); //포인트 적립
				if(cnt != -1) {
					writer.println("<script type='text/javascript'>");
					writer.println("alert('"+id.getMember_name()+"님 "+total_point+"point 적립');");
					writer.println("alert('결제 완료');");
					session.removeAttribute("cart"); //결제 완료시 장바구니 비우기
					session.removeAttribute("cartSize");//결제 완료시 장바구니갯수 카운트 비우기
					StoreCoupon_UserBean storeCoupon_UserBean = new StoreCoupon_UserBean();
					storeCoupon_UserBean.setCoupon_code(use_coupon_code);
					storeCoupon_UserBean.setMember_code(id.getMember_code());
					storeCouponDao.useCoupon(storeCoupon_UserBean);
					writer.println("location.href = 'myOrderDetail.mp?payment_code="+payment_code+"&payment_sale_pay="+sale_pay+"' ");
					writer.println("</script>");
					writer.flush();
					return null; 
				}else {
					writer.println("<script type='text/javascript'>");
					writer.println("alert('결제 실패');");
					writer.println("location.href = 'list.store' ");
					writer.println("</script>");
					writer.flush();
					return null; 
				}
			}
		}
//		System.out.println("결제코드 : "+payment_code);
//		System.out.println("카드번호 : "+storeCardBean.getCard_number());
//		System.out.println("회원코드 : "+ id.getMember_code());

		
		
		return getPayPage;
	}
	
	
	
	
	
	
	
}

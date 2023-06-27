package admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import store.model.StoreCouponBean;
import store.model.StoreCouponDao;
import store.model.StoreProductBean;
import store.model.StoreProductDao;


@Controller
public class adminStoreController {
	private final String command = "/productList.admin";
	
	private final String listPage = "adminProductList";
	
	@Autowired
	StoreProductDao storeProductDao;
	
	@RequestMapping(command)
	public String adminCouponList(Model model) {
		
		List<StoreProductBean> ProductList = storeProductDao.getAllProduct(); //전체 상품목록리스트
		
		model.addAttribute("ProductList", ProductList);//전체 상품을 담은 products
		
		return listPage;
	}
	
//	@RequestMapping(value=createCommand,method = RequestMethod.GET)
//	public String adminCouponCreate() {
//		
//		return createPage; //관리자의 쿠폰생성 페이지로 넘어가기
//	}
//	
//	@RequestMapping(value=createCommand,method = RequestMethod.POST)
//	public String adminCouponCreate(
//			@ModelAttribute("storeCouponBean") @Valid StoreCouponBean storeCouponBean) {
//		
//		int confirm = storeCouponDao.createCoupon(storeCouponBean); //삽입하고 삽입됬는지 확인하는 confirm변수
//		
//		if(confirm == 1) {
//			System.out.println("쿠폰 생성 성공");
//			return re_command;
//		}else {
//			System.out.println("쿠폰 생성 실패");
//		}
//		return re_createCommand; //쿠폰 생성 실패 생성페이지로 돌아가기
//	}
	
}
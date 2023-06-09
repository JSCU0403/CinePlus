package com.spring.ex;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.github.scribejava.core.model.OAuth2AccessToken;

import member.model.MemberBean;
import member.model.MemberDao;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class NaverController {

	HttpServletResponse response;
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "member.model.MemberBean";
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
 
	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/memberlogin", method = RequestMethod.GET)
	public String memberNaverLogin(Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버 
		model.addAttribute("url", naverAuthUrl);
		
		
		/* 구글code 발행 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String google_url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

		System.out.println("구글:" + google_url);

		model.addAttribute("google_url", google_url);
		
		
		
		return "redirect:/memberlogin.mb";
	}
	
	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버 
		model.addAttribute("url", naverAuthUrl);
 
		return "login";
	}
 
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {

		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        System.out.println("session:"+session+"/"+code+"/"+state);
        //1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);  //String형식의 json데이터
		
		/** apiResult json 구조
		{"resultcode":"00",
		 "message":"success",
		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. 데이터 파싱 
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		System.out.println("response:"+response_obj);
		//response의 nickname값 파싱
		String name = (String) response_obj.get("name");
		String email = (String) response_obj.get("email");
		String birth = (String) response_obj.get("birth");
		String birthyear = (String) response_obj.get("birthyear");
		String id = (String) response_obj.get("id");
		String mobile = (String) response_obj.get("mobile");
 
		System.out.println("signIn:"+apiResult);
		System.out.println("name:"+name);
		System.out.println("email:"+email);
		System.out.println("birth:"+birth);
		System.out.println("birthyear:"+birthyear);
		System.out.println("id:"+id);
		System.out.println("mobile:"+mobile);
		
		//4.파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId",name); //세션 생성
		
		 model.addAttribute("result", apiResult);
	     model.addAttribute("name",name);
	     model.addAttribute("email",email);
	     model.addAttribute("birth",birth);
	     model.addAttribute("birthyear",birthyear);  
	     model.addAttribute("id",id);
	     model.addAttribute("mobile",mobile);

	     member.model.MemberBean mb = sqlSessionTemplate.selectOne(namespace+".GetMemberByEmail",email);
		 session.setAttribute("loginInfo", mb);//세션설정
		 
			
		if (mb == null)
		{
			sqlSessionTemplate.insert(namespace+".NaverInsertMember",model);
			
		    mb = sqlSessionTemplate.selectOne(namespace+".GetMemberById",id);
			session.setAttribute("loginInfo", mb);//세션설정
		}
		else if(mb.getMember_email() == email) {
			session.setAttribute("loginInfo", mb);//세션설정
		}
		return "redirect:/main.mn";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session)throws IOException {
			System.out.println("여기는 logout");
			session.invalidate();
			session.setAttribute("loginInfo", null);
	        
			return "redirect:/main.mn";
		}
	
}
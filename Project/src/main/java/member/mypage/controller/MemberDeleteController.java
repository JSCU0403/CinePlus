package member.mypage.controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	private final String command = "/mypage_delete.mb";
	private String gotoPage = "redirect:/memberlogin.mb";
	private final String getPage = "mypage_memberDelete";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam("member_id") String member_id) {

		System.out.println("member_id: "+member_id);
		
		return getPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(
			@RequestParam("member_id") String member_id,
			@RequestParam("member_pw") String member_pw,
			@RequestParam("member_phone") String member_phone,
			HttpServletResponse response, Model model) {

		PrintWriter out = null;
		response.setContentType("text/html; charset=UTF-8");

		MemberBean member = mdao.getMemberById(member_id);

		System.out.println(" mpw1 : " + member.getMember_pw());
		System.out.println("입력pw : " + member_pw);

		System.out.println("member_phone: " + member_phone);

		if (member.getMember_pw().equals(member_pw)) {
			int cnt = mdao.deleteMember(member_id);
			System.out.println("delete cnt : " + cnt);
		} else { /* 입력한 비밀번호가 다른 경우 */
			try {
				out = response.getWriter();
				out.print("<script>alert('비밀번호를 잘못 입력했습니다.');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (member.getMember_phone().equals(member_phone)) {
			int cnt = mdao.deleteMember(member_id);
			System.out.println("delete cnt : " + cnt);
		} else { /* 입력한 전화번호가 다른 경우 */
			try {
				out = response.getWriter();
				out.print("<script>alert('연락처를 잘못 입력했습니다.');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//삭제 실패로 memberlogin.mb요청으로 로그인 페이지로 이동
		return gotoPage; 

	}
}

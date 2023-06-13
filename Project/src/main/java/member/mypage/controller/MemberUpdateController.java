package member.mypage.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {

	private final String command = "/mypage_update.mb";
	private final String getPage = "mypage_memberUpdateForm";
	private final String gotoPage = "redirect:/main.mp";

	@Autowired
	MemberDao mdao;

	///mypage_update.mb -> member/mypage_memberUpdateForm
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView goAction(@RequestParam("member_id") String member_id) {

		System.out.println("member_id: "+member_id);
		
		ModelAndView mav = new ModelAndView();
		MemberBean member = mdao.GetMemberById(member_id);
		mav.addObject("mb", member);
		mav.setViewName(getPage);
		return mav;
	}

	// member/mypage_memberUpdateForm -> controller
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("mb") @Valid MemberBean mb,
			HttpServletResponse response,
			BindingResult result) {
		
		PrintWriter out = null;
		response.setContentType("text/html; charset=UTF-8");

		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = mdao.updateMember(mb);
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			}else {
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
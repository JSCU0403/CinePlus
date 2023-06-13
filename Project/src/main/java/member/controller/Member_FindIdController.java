package member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Member_FindIdController {
	
	private final String command = "findid.mb";
	private final String getPage = "member_FindIdForm";
	private final String gotoPage = "redirect:/mainLogined.mn";
	
	/* 아이디찾기 폼으로 이동 */
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String findid() {
		return getPage;
	}
	
	
	/* 아이디 찾기 */
	@RequestMapping(value = "member_FindIdForm", method = RequestMethod.POST)
	public String find_id(HttpServletResponse response,
						@RequestParam("member_name") String member_name,
						@RequestParam("member_birth") String member_birth,
						@RequestParam("member_phone") String member_phone, Model md) throws Exception{
		
		return gotoPage;
	}


	
	
}

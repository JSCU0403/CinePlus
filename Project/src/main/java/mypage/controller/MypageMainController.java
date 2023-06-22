package mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageMainController {

	private final String command = "main.my";
	private final String getPage = "mypageMain";
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionByGet() {
		
		return getPage;
	}
}
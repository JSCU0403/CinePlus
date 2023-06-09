package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import board.model.BoardBean;
import board.model.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardInsertController {

	private final String command = "/insert.bd";
	private final String getPage = "boardInsertForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
   BoardDao boardDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("board") @Valid BoardBean board, BindingResult result,
                                HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}
		else {
			System.out.println("content : " + board.getContent());
			int cnt = boardDao.InsertBoard(board);
			System.out.println("cnt : " + cnt);
			mav.setViewName(gotoPage);
		}
		return mav;
	}
}
package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import movie.model.ReservationBean;
import movie.model.ScreenBean;
import movie.model.ScreenDao;

@Controller
public class ScreenSelectSeatsController {
	private final String command = "/selectSeats.mv";
	private final String getPage = "selectSeats";

	@Autowired
	ScreenDao screenDao;

	@RequestMapping(value = command)
	public String doAction(
			@ModelAttribute("screenBean") ScreenBean screenBean,
			Model model, HttpSession session, HttpServletResponse response) throws IOException {
		
		 response.setCharacterEncoding("EUC-KR");
	     PrintWriter writer;
	     
			writer = response.getWriter();
			if(session.getAttribute("loginInfo") == null) {
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('로그인 후 이용가능한 서비스입니다. 로그인 페이지로 이동합니다.');");
			     writer.println("location.href = 'memberlogin' ");
			     writer.println("</script>");
			     writer.flush();
			     return null;
			}
		
		
		List<ReservationBean> reservationList = screenDao.getReservationByTime(screenBean.getScreen_time());
		for(int i=0; i<reservationList.size(); i++) {
			ReservationBean reservation = reservationList.get(i);
			System.out.println(reservation.getSeat_number());
			System.out.println(reservation.getMovie_title());
			System.out.println(reservation.getScreen_name());
			String seatnum = reservation.getSeat_number();
			String seatRow = seatnum.substring(0,1);
			String seatCol = seatnum.substring(1);
			reservation.setSeat_number(seatRow);
			reservation.setSeat_number2(seatCol);
		}
		model.addAttribute("reservationList", reservationList);
		
		return getPage;
	}

}

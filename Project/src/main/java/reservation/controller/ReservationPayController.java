package reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationPayController {
	
	private final String command = "pay.rv";
	private final String getPage = "reservationComplete";
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionByPost() {
		
		return getPage;
	}
}

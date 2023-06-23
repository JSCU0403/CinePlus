package reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationSeatController {

	private final String command = "selectSeat.rv";
	private final String getPage = "reservationSeat";
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionByGet() {
		
		return getPage;
	}
	
}

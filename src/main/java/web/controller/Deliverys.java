package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class Deliverys {

	@GetMapping("/deliverys")
	public String showDeliverys() {
		
		return"service/deliverys";
	}
	@GetMapping("/payandret")
	public String showPaymentAndReturn() {
		
		return"service/payandret";
	}
}

package com.mcs.pmay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chandrakumar
 *
 */
@Controller
public class PmayMapController {
	
	@RequestMapping("/showLocation")
	public String showLocation(Model model,@RequestParam("lat")String lat,@RequestParam("lng")String lng) {
	
		System.out.println(" lat = " + lat);
		System.out.println(" lng = " + lng);
		model.addAttribute("lat",lat);
		model.addAttribute("lng",lng);
		
		return "showLocation";
	}
	
}

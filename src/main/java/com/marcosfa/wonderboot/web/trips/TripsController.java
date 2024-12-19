package com.marcosfa.wonderboot.web.trips;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trips")
public class TripsController {

@GetMapping
    public String trips() {
    return "trips";
}

}

package com.marcosfa.wonderboot.web.trips;

import com.marcosfa.wonderboot.web.trips.dto.TripCityDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripsController {

@GetMapping
    public String trips(Model model) {
    List<TripCityDTO> cities = new ArrayList<>();

    return "trips";
}

}



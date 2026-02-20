package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.repositories.FlightRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/findFlights")
    public String displayFindFlights() {
        return "findFlights";
    }

    @PostMapping("/findFlights")
    public String displayFindFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
            ModelMap modelMap) {
        
        try {
            // Use the departure date provided by Spring
            Date departure = departureDate;
            
            // Fetch flights from the repository
            var flights = flightRepository.findByDepartureCityAndArrivalCityAndDateOfDeparture(from, to, departure);
            
            // Add flights to the model
            modelMap.addAttribute("flights", flights);
            
        } catch (Exception e) {
            modelMap.addAttribute("error", "Error processing your request: " + e.getMessage());
        }
        
        return "displayFlights";
    }
}
package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.dtos.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repositories.FlightRepository;
import com.bharath.flightreservation.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(
            @RequestParam("flightId") Long flightId,
            ModelMap modelMap) {
        
        // Fetch flight details using flight repository
        Flight flight = flightRepository.findById(flightId).orElse(null);
        
        if (flight == null) {
            modelMap.addAttribute("error", "Flight not found");
            return "error"; // or return to a different view
        }
        
        // Send flight details to the complete reservation template
        modelMap.addAttribute("flight", flight);
        
        return "completeReservation";
    }

    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest request, Model model) {
        
           Reservation reservation = reservationService.bookFlight(request);
            model.addAttribute("msg", "Reservation created successfully with ID: " + reservation.getId());
            return "reservationConfirmation";
    }

    
}

package com.bharath.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightreservation.dtos.ReservationUpdateRequest;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repositories.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @PostMapping("/reservation/update")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
        
        if (reservation != null) {
            reservation.setCheckedIn(request.isCheckedIn());
            reservation.setNumberOfBags(request.getNumberOfBags());
            reservationRepository.save(reservation);
        }
        
        return reservation;
    }
}

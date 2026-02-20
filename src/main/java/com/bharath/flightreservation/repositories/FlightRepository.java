package com.bharath.flightreservation.repositories;

import com.bharath.flightreservation.entities.Flight;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Find flights by departure and arrival cities and date
    List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(
            String departureCity, String arrivalCity, Date dateOfDeparture);

    // // Find flights by departure and arrival cities
    // List<Flight> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

    // // Find flights by departure city
    // List<Flight> findByDepartureCity(String departureCity);

    // // Find flights by arrival city
    // List<Flight> findByArrivalCity(String arrivalCity);

    // // Find flights by flight number
    // Flight findByFlightNumber(String flightNumber);

    // // Find flights by departure date
    // List<Flight> findByDateOfDeparture(Date dateOfDeparture);

}

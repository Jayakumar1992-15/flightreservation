package com.bharath.flightreservation.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @Column(name = "operating_airlines", nullable = false)
    private String operatingAirlines;

    @Column(name = "departure_city", nullable = false)
    private String departureCity;

    @Column(name = "arrival_city", nullable = false)
    private String arrivalCity;

    @Column(name = "date_of_departure", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfDeparture;

    @Column(name = "estimated_departure_time", nullable = false)
    private Timestamp estimatedDepartureTime;

}
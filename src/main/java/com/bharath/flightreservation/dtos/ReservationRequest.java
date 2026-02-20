package com.bharath.flightreservation.dtos;

import lombok.Data;

@Data
public class ReservationRequest {
    private Long flightId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;

}
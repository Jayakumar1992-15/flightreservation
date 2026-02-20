package com.bharath.flightreservation.repositories;

import com.bharath.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    // // Find passenger by email
    // Optional<Passenger> findByEmail(String email);

    // // Find passenger by phone
    // Optional<Passenger> findByPhone(String phone);

    // // Find passengers by first name
    // List<Passenger> findByFirstName(String firstName);

    // // Find passengers by last name
    // List<Passenger> findByLastName(String lastName);

    // // Find passengers by first and last name
    // List<Passenger> findByFirstNameAndLastName(String firstName, String lastName);
}

package com.bharath.flightreservation.repositories;

// import com.bharath.flightreservation.entities.Passenger;
// import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // // Find reservation by passenger
    // Optional<Reservation> findByPassenger(Passenger passenger);

    // // Find reservations by flight
    // List<Reservation> findByFlight(Flight flight);

    // // Find reservations by checked-in status
    // List<Reservation> findByCheckedIn(boolean checkedIn);

    // // Find reservation by passenger and flight
    // Optional<Reservation> findByPassengerAndFlight(Passenger passenger, Flight flight);

    // // Find checked-in reservations
    // List<Reservation> findByCheckedInTrue();

    // // Find not checked-in reservations
    // List<Reservation> findByCheckedInFalse();

    // // Find reservations by number of bags
    // List<Reservation> findByNumberOfBags(int numberOfBags);
}

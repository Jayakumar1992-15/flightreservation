package com.bharath.flightreservation;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Optional;
import com.bharath.flightreservation.controllers.ReservationRestController;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repositories.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ReservationRestController.class)
public class ReservationRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationRepository reservationRepository;

    @Test
    void findReservation_found() throws Exception {
        Reservation r = new Reservation();
        r.setId(1L);
        r.setCheckedIn(true);
        r.setNumberOfBags(2);

        when(reservationRepository.findById(1L)).thenReturn(Optional.of(r));

        mockMvc.perform(get("/reservation/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.checkedIn").value(true))
                .andExpect(jsonPath("$.numberOfBags").value(2));

        verify(reservationRepository).findById(1L);
    }

    @Test
    void findReservation_notFound_returnsNullBody() throws Exception {
        when(reservationRepository.findById(9L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/reservation/9"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(reservationRepository).findById(9L);
    }

    @Test
    void updateReservation_updatesAndReturnsReservation() throws Exception {
        Reservation r = new Reservation();
        r.setId(5L);
        r.setCheckedIn(false);
        r.setNumberOfBags(0);

        when(reservationRepository.findById(5L)).thenReturn(Optional.of(r));
        when(reservationRepository.save(any(Reservation.class))).thenAnswer(inv -> inv.getArgument(0));

        String body = "{\"id\":5,\"checkedIn\":true,\"numberOfBags\":3}";

        mockMvc.perform(post("/reservation/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.checkedIn").value(true))
                .andExpect(jsonPath("$.numberOfBags").value(3));

        verify(reservationRepository).findById(5L);
        verify(reservationRepository).save(any(Reservation.class));
    }

    @Test
    void updateReservation_notFound_returnsNullBody() throws Exception {
        when(reservationRepository.findById(6L)).thenReturn(Optional.empty());

        String body = "{\"id\":6,\"checkedIn\":true,\"numberOfBags\":1}";

        mockMvc.perform(post("/reservation/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(reservationRepository).findById(6L);
        verify(reservationRepository, never()).save(any(Reservation.class));
    }
}
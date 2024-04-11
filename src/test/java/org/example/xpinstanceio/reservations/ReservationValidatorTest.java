package org.example.xpinstanceio.reservations;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

class ReservationValidatorTest {

    private ReservationValidator reservationValidator;

    @BeforeEach
    void setUp() {
        reservationValidator = new ReservationValidator();
    }

    @Test
    @DisplayName("should reject reservation with number of guests is not specified")
    void should_reject_reservation_with_number_of_guests_is_not_specified() {
        Reservation reservation = Instancio.of(Reservation.class).ignore(field(Reservation::getNumberOfGuests)).create();
        boolean verdict = reservationValidator.validate(reservation);
        assertFalse(verdict);
    }

}
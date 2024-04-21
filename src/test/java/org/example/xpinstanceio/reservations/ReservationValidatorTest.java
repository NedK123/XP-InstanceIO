package org.example.xpinstanceio.reservations;

import org.instancio.Instancio;
import org.instancio.Model;
import org.instancio.Selector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.instancio.Assign.valueOf;
import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ReservationValidatorTest {

    private ReservationValidatorImpl reservationValidator;
    private Model<Reservation> reservationModel;

    @BeforeEach
    void setUp() {
        reservationValidator = new ReservationValidatorImpl();
        Selector startDateField = field(Reservation::getStartDate);
        Selector endDateField = field(Reservation::getEndDate);
        reservationModel = Instancio.of(Reservation.class).withSeed(1)
                .assign(
                        valueOf(field(CustomDate::getDate).within(startDateField.toScope()))
                        .to(field(CustomDate::getDate).within(endDateField.toScope()))
                        .as(startDate -> ((LocalDate) startDate).plusDays(1))
                )
                .toModel();
    }

    @Test
    @DisplayName("should reject reservation with number of guests is not specified")
    void should_reject_reservation_with_number_of_guests_is_not_specified() {
        Reservation reservation = Instancio.of(reservationModel).ignore(field(Reservation::getNumberOfGuests)).create();
        assertFalse(reservationValidator.validate(reservation));
    }

    @Test
    @DisplayName("using lists -> should reject reservation with number of guests is not specified")
    void using_lists_should_reject_reservation_with_number_of_guests_is_not_specified() {
        assertFalse(reservationValidator.validate(Instancio.createList(Reservation.class)));
    }

    @Test
    @DisplayName("using lists builder -> should reject reservations with number of guests is not specified")
    void using_lists_builder_should_reject_reservations_with_number_of_guests_is_not_specified() {
        List<Reservation> reservations = Instancio.ofList(reservationModel).size(10)
                .ignore(field(Reservation::getNumberOfGuests))
                .create();
        assertFalse(reservationValidator.validate(reservations));
    }


}
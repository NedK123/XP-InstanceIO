package org.example.xp.testDateGen.reservations;

import java.util.List;

public class ReservationValidatorImpl implements ReservationValidator {

    @Override
    public boolean validate(Reservation reservation) {
        if (reservation.getCustomer() == null) {
            return false;
        }

        if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
            return false;
        }

        if (reservation.getStartDate().getDate().isAfter(reservation.getEndDate().getDate())) {
            return false;
        }

        if (reservation.getNumberOfGuests() <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean validate(List<Reservation> reservations) {
        return reservations.stream().allMatch(this::validate);
    }
}
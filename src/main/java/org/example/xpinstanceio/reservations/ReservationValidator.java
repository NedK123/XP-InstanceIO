package org.example.xpinstanceio.reservations;

public class ReservationValidator {

    public boolean validate(Reservation reservation) {
        if (reservation.getCustomerName() == null || reservation.getCustomerName().isEmpty()) {
            return false;
        }

        if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
            return false;
        }

        if (reservation.getStartDate().isAfter(reservation.getEndDate())) {
            return false;
        }

        if (reservation.getNumberOfGuests() <= 0) {
            return false;
        }

        return true;
    }
}
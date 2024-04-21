package org.example.xp.testDateGen.reservations;

import java.util.List;

public interface ReservationValidator {
    boolean validate(Reservation reservation);
    boolean validate(List<Reservation> reservations);
}

package org.example.xpinstanceio.reservations;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Reservation {
    private String id;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfGuests;
    private User owner;
}
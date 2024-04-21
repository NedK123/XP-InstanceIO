package org.example.xpinstanceio.reservations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reservation {
    private String id;
    private CustomDate startDate;
    private CustomDate endDate;
    private int numberOfGuests;
    private Customer customer;
}
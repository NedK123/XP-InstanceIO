package org.example.xpinstanceio.reservations;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomDate {
    private LocalDate date;
}

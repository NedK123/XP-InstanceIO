package org.example.xp.testDateGen.reservations;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomDate {
    private LocalDate date;
}

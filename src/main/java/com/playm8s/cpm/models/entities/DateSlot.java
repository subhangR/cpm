package com.playm8s.cpm.models.entities;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateSlot {
    LocalDate date;
    int timeSlot; // every 30 mins counts as one slot, 00:00am -> slot0, 00:30am->slot1, 1:00am -> slot2
}


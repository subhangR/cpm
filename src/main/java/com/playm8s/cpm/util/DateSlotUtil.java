package com.playm8s.cpm.util;

import com.playm8s.cpm.models.entities.DateSlot;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class DateSlotUtil {

    public static List<LocalDateTime> getStartAndEndTime(List<DateSlot> dateSlots) {
        DateSlot startDateSlot = dateSlots.get(0);
        DateSlot endDateSlot = dateSlots.get(dateSlots.size() - 1);
        return List.of(
                LocalDateTime.of(startDateSlot.getDate(),getSlotStartTime(startDateSlot.getTimeSlot())),
                LocalDateTime.of(endDateSlot.getDate(),getSlotEndTime(endDateSlot.getTimeSlot()))
        );
    }

    public static LocalTime getSlotStartTime(int slotId) {
        return LocalTime.of(slotId/2,30 * slotId%2);
    }

    public static LocalTime getSlotEndTime(int slotId) {
        return LocalTime.of( (((slotId & 1) == 0 ) ? slotId/2 + 1 : slotId / 2),
                30 * ((((slotId & 1) == 0) ? 1 : 0)));
    }


}

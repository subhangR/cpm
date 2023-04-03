package com.playm8s.cpm.models.entities.court;

import com.playm8s.cpm.models.entities.common.Location;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class CourtInventory {

    String _id;
    String courtId;
    String arenaId;
    Date date;
    Integer slotId;
    Double price;
    LocalDate createdAt;
    LocalDate updatedAt;

}

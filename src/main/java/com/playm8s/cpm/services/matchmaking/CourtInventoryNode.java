package com.playm8s.cpm.services.matchmaking;

import com.playm8s.cpm.models.entities.court.Court;
import com.playm8s.cpm.models.entities.court.CourtInventory;
import com.playm8s.cpm.models.entities.game.Lobby;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourtInventoryNode {
    CourtInventory courtInventory;
    int possibleLobbies;

    public CourtInventoryNode(CourtInventory courtInventory) {
        this.courtInventory = courtInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourtInventoryNode that = (CourtInventoryNode) o;
        return Objects.equals(courtInventory.getCourtId(), that.courtInventory.getCourtId())
                && Objects.equals(courtInventory.getDate(), that.courtInventory.getDate())
                && Objects.equals(courtInventory.getSlotId(), that.courtInventory.getSlotId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(courtInventory, possibleLobbies);
    }
}

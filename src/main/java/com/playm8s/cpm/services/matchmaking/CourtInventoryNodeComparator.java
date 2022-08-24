package com.playm8s.cpm.services.matchmaking;

import java.util.Comparator;

class CourtInventoryNodeComparator implements Comparator<CourtInventoryNode> {

    // Method
    // To compare two strings
    public int compare(CourtInventoryNode courtInventoryNode1, CourtInventoryNode courtInventoryNode2) {
      if(courtInventoryNode1.getPossibleLobbies() < courtInventoryNode2.getPossibleLobbies()) {
          return -1;
      }
      else if(courtInventoryNode1.getPossibleLobbies() > courtInventoryNode2.getPossibleLobbies()) {
          return 1;
      }
      return 0;
    }
}

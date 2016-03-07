package net.sriramiyer.train;

import java.util.ArrayList;

public class FareList {
    ArrayList<Fare> fareList;

    public FareList() {
        this.fareList = new ArrayList<Fare>();
    }

    public boolean addFareEntry(int departureGroup, int destinationGroup, int fare) {
        if (isEntryUnique(departureGroup, destinationGroup)) {
            this.fareList.add(new Fare(departureGroup, destinationGroup, fare));
            return true;
        } else {
            return false;
        }
    }

    private boolean isEntryUnique(int departureGroup, int destinationGroup) {
        for (Fare fare : fareList) {
            if ((fare.getDepartureGroup() == departureGroup) && (fare.getDestinationGroup() == destinationGroup)) {
                return false;
            }
        }
        return true;
    }

    public int getFareByGroup(int departureGroup, int destinationGroup) {
        for (Fare fare : fareList) {
            if ((fare.getDepartureGroup() == departureGroup) && (fare.getDestinationGroup() == destinationGroup)) {
                return fare.getFare();
            }
        }
        return -1;
    }
}

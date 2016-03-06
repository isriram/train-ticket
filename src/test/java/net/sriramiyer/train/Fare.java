package net.sriramiyer.train;

public class Fare {
    private final int departureGroup;
    private final int destinationGroup;
    private final int fare;

    public Fare(int departureGroup, int destinationGroup, int fare) {
        this.departureGroup = departureGroup;
        this.destinationGroup = destinationGroup;
        this.fare = fare;
    }

    public int getDestinationGroup() {
        return destinationGroup;
    }

    public int getDepartureGroup() {
        return departureGroup;
    }

    public int getFare() {
        return fare;
    }
}

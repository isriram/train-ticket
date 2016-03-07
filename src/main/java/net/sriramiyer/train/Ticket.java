package net.sriramiyer.train;

public class Ticket {

    private final int departureGroup;
    private final int destinationGroup;
    private static final int ticketCost[] = { 8, 14, 17, 20, 22};

    public Ticket(int departureGroup, int destinationGroup) {
        this.departureGroup = departureGroup;
        this.destinationGroup = destinationGroup;
    }

    public int getCost() {
        return ticketCost[Math.abs(destinationGroup - departureGroup)];
    }
}

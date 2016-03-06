package net.sriramiyer.train;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TicketTest {
    @Test
    public void shouldGetTicketCostForTravelInsideGroup() {
        int departureGroup = 1;
        int destinationGroup = 1;
        final Ticket ticket = new Ticket(departureGroup, destinationGroup);
        int actualFare = ticket.getCost();
        assertEquals(actualFare, 8);
    }

    @Test
    public void shouldGetTicketCostForTravelToNextGroup() {
        int departureGroup = 1;
        int destinationGroup = 2;
        final Ticket ticket = new Ticket(departureGroup, destinationGroup);

        int actualFare = ticket.getCost();

        assertEquals(actualFare, 14);
    }

    @Test
    public void shouldGetTicketCostForTravelToArbitraryGroup() {
        int departureGroup = 2;
        int destinationGroup = 1;
        final Ticket ticket = new Ticket(departureGroup, destinationGroup);

        int actualFare = ticket.getCost();

        assertEquals(actualFare, 14);
    }

}
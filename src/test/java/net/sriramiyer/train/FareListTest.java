package net.sriramiyer.train;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FareListTest {
    @Test
    public void shouldAddOneFareEntry() {
        FareList fareList = new FareList();

        int departureGroup = 1;
        int destinationGroup = 1;
        int fare = 8;
        boolean fareEntryAdded = fareList.addFareEntry(departureGroup, destinationGroup, fare);

        assertEquals(fareEntryAdded, true);
    }

    @Test
    public void shouldFailToAddSecondEntryBecauseItIsADuplicate() {
        FareList fareList = new FareList();

        boolean fareEntryAdded;
        fareList.addFareEntry(1, 1, 1);
        fareEntryAdded = fareList.addFareEntry(1, 1, 1);

        assertEquals(fareEntryAdded, false);
    }

    @Test
    public void shouldGetFareWhenGivenDepartureAndDestinationGroup() {
        FareList fareList = new FareList();

        fareList.addFareEntry(1, 1, 5);
        fareList.addFareEntry(2, 2, 5);
        fareList.addFareEntry(1, 2, 8);
        fareList.addFareEntry(2, 1, 8);

        int getFare = fareList.getFareByGroup(1, 1);
        assertEquals(getFare, 5);
        getFare = fareList.getFareByGroup(2, 2);
        assertEquals(getFare, 5);
        getFare = fareList.getFareByGroup(1, 2);
        assertEquals(getFare, 8);
        getFare = fareList.getFareByGroup(2, 1);
        assertEquals(getFare, 8);
    }

    @Test
    public void shouldFailBecauseFareGroupIsNotInTheList() {
        FareList fareList = new FareList();

        fareList.addFareEntry(1, 1, 5);
        fareList.addFareEntry(2, 2, 5);
        fareList.addFareEntry(1, 2, 8);
        fareList.addFareEntry(2, 1, 8);

        int getFare;
        getFare = fareList.getFareByGroup(1, 3);

        assertEquals(getFare, -1);
    }
}
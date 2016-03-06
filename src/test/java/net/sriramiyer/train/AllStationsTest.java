package net.sriramiyer.train;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AllStationsTest {
    @Test
    public void shouldAddStationToArrayList() {
        AllStations allStations = new AllStations();
        boolean stationAdded;
        stationAdded = allStations.addStation("A", 1, 1);

        assertEquals(stationAdded, true);
    }

    @Test
    public void shouldAddStationTwoStationsInSameGroupWithDifferentID() {
        AllStations allStations = new AllStations();
        boolean stationAdded;
        allStations.addStation("A", 1, 1);
        stationAdded = allStations.addStation("B", 2, 1);

        assertEquals(stationAdded, true);
    }

    @Test
    public void shouldFailToAddAnotherStationWithSameStationID() {
        AllStations allStations = new AllStations();
        boolean stationAdded;
        allStations.addStation("A", 1, 1);
        stationAdded = allStations.addStation("A", 1, 1);

        assertEquals(stationAdded, false);
    }

    @Test
    public void shouldGetStationGroupFromStationIDForStationThatExists() {
        AllStations allStations = new AllStations();

        allStations.addStation("A", 1, 1);
        allStations.addStation("B", 2, 1);
        allStations.addStation("C", 3, 2);
        allStations.addStation("D", 4, 2);
        allStations.addStation("E", 5, 3);
        allStations.addStation("F", 6, 3);

        int stationGroupFromId;
        stationGroupFromId = allStations.getGroupByStationId(2);
        assertEquals(stationGroupFromId, 1);
    }

    @Test
    public void shouldFailToGetStationGroupBecauseStationDoesNotExist() {
        AllStations allStations = new AllStations();

        allStations.addStation("A", 1, 1);
        allStations.addStation("B", 2, 1);
        allStations.addStation("C", 3, 2);
        allStations.addStation("D", 4, 2);
        allStations.addStation("E", 5, 3);
        allStations.addStation("F", 6, 3);

        // if the function returns -1 that means the station does not exist
        int stationGroupFromId;
        stationGroupFromId = allStations.getGroupByStationId(8);
        assertEquals(stationGroupFromId, -1);
    }
}
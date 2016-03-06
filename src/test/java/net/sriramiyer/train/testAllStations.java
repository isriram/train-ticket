package net.sriramiyer.train;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testAllStations {
    @Test
    public void shouldAddStationToArrayList() {
        AllStations allStations = new AllStations();
        boolean stationAddStatus;
        stationAddStatus = allStations.addStation("A", 1, 1);

        assertEquals(stationAddStatus, true);
    }

    @Test
    public void shouldAddStationTwoStationsInSameGroupWithDifferentID() {
        AllStations allStations = new AllStations();
        boolean stationAddStatus;
        stationAddStatus = allStations.addStation("A", 1, 1);
        stationAddStatus = allStations.addStation("B", 2, 1);

        assertEquals(stationAddStatus, true);
    }


    @Test
    public void shouldFailToAddAnotherStationWithSameStationID() {
        AllStations allStations = new AllStations();
        boolean stationAddStatus;
        stationAddStatus = allStations.addStation("A", 1, 1);
        stationAddStatus = allStations.addStation("A", 1, 1);

        assertEquals(stationAddStatus, false);
    }

    @Test
    public void shouldGetStationGroupFromStationIDForStationThatExists() {
        AllStations allStations = new AllStations();
        boolean stationAddStatus;
        stationAddStatus = allStations.addStation("A", 1, 1);
        stationAddStatus = allStations.addStation("B", 2, 1);
        stationAddStatus = allStations.addStation("C", 3, 2);
        stationAddStatus = allStations.addStation("D", 4, 2);
        stationAddStatus = allStations.addStation("E", 5, 3);
        stationAddStatus = allStations.addStation("F", 6, 3);

        int stationGroupFromId;
        stationGroupFromId = allStations.getGroupByStationId(2);
        assertEquals(stationGroupFromId, 1, "This works, doesn't it");
    }

    @Test
    public void shouldFailToGetStationGroupBecauseStationDoesNotExist() {
        AllStations allStations = new AllStations();
        boolean stationAddStatus;
        stationAddStatus = allStations.addStation("A", 1, 1);
        stationAddStatus = allStations.addStation("B", 2, 1);
        stationAddStatus = allStations.addStation("C", 3, 2);
        stationAddStatus = allStations.addStation("D", 4, 2);
        stationAddStatus = allStations.addStation("E", 5, 3);
        stationAddStatus = allStations.addStation("F", 6, 3);

        int stationgroupfromid;
        stationgroupfromid = allStations.getGroupByStationId(8);
        assertEquals(stationgroupfromid, -1);
    }
}
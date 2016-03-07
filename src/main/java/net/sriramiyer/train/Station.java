package net.sriramiyer.train;

public class Station {
    private final String stationName;
    private final int stationId;
    private final int stationGroup;

    public Station(String name, int id, int group) {
        this.stationName = name;
        this.stationId = id;
        this.stationGroup = group;
    }

    public int getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public int getStationGroup() {
        return stationGroup;
    }
}
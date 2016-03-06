package net.sriramiyer.train;

import java.util.ArrayList;

public class AllStations {
    ArrayList<Station> stationList;

    public AllStations(){
        this.stationList = new ArrayList<Station>();
    }

    public boolean addStation(String name, int stationID, int group) {
        if(isStationIdUnique(stationID)){
            stationList.add(new Station(name, stationID, group));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isStationIdUnique(int stationID){
        for(Station s: stationList){
            if(s.getStationId() == stationID){
                return false;
            }
        }
        return true;
    }

    public int getGroupByStationId(int stationId) {
        for(Station s: stationList){
            if(s.getStationId() == stationId){
                return s.getStationGroup();
            }
        }
        return -1;
        // returns -1 if station does not exist
    }
}
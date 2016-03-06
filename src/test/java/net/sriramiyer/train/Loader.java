package net.sriramiyer.train;

import java.io.*;
import java.util.ArrayList;

public class Loader {
    AllStations stationList;
    FareList fareList;
    ArrayList<String> ticketFareList;

    public Loader() {
        stationList = new AllStations();
        fareList = new FareList();
        ticketFareList = new ArrayList<>();
    }

    public void readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("stationlist.txt"))) {
            String line = bufferedReader.readLine();
            String[] parts;

            while (line != null) {
                parts = line.split(",");
                if(3 == parts.length) {
                    stationList.addStation(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("farelist.txt"))) {
            String line = bufferedReader.readLine();
            String[] parts;

            while (line != null) {
                parts = line.split(",");
                if(3 == parts.length) {
                    fareList.addFareEntry(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readInputsForTesting() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("tickets.txt"))) {
            String line = bufferedReader.readLine();
            String prettyFare, departureName, destinationName;
            int departure, destination;
            int departureGroup, destinationGroup;
            int ticketCost;
            String[] parts;
            while (line != null) {
                parts = line.split(",");
                departure = Integer.parseInt(parts[0]);
                destination = Integer.parseInt(parts[1]);
                departureGroup = stationList.getGroupByStationId(departure);
                destinationGroup = stationList.getGroupByStationId(destination);
                departureName = stationList.getStationNameByStationId(departure);
                destinationName = stationList.getStationNameByStationId(destination);
                ticketCost = fareList.getFareByGroup(departureGroup, destinationGroup);

                prettyFare = departureName + " - " + departure + ": " + departureGroup + " to " +
                        destinationName + " - " + destination + ": " + destinationGroup + " = " + ticketCost + "\n";
                this.ticketFareList.add(prettyFare);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCostsToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String fare : ticketFareList) {
                bufferedWriter.write(fare);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import data.*;
import fetcher.*;
import java.io.*;
import java.util.*;

public class Race{

    public static Map<Integer, List<String>> maxSpeed(List<Fetcher1> data, int budget, int topSpeed, int baseSpeed){
        return null;
    }

    public static void main(String[] args){
        String c = args[0];
        String p = args[1];
        String t = args[2];

        List<Cars> cars = Fetcher.readCarsFromCSV(args[0]);
        List<Parts> parts = Fetcher.readPartsFromCSV(args[1]);
        List<Teams> teams = Fetcher.readTeamFromCSV(args[2]);

        Map<String, List<Fetcher1>> mp = new HashMap<>();
        Map<String, Cars> mp1 = new HashMap<>();

        for(Parts parts1 : parts){
            if (!mp.containsKey(parts1.getPartlist())) {
                mp.put(parts1.getPartlist(), new ArrayList<>());
            }
            mp.get(parts1.getPartlist()).add(new Fetcher1(parts1.getPartid(), parts1.getprice(), parts1.getSpeedboost()));
        }

        for(Cars cars1 : cars){
            mp1.put(cars1.getId(), cars1);
        }

        for(Teams teams1 : teams){
            int budget = teams1.getFunds();
            Map<Integer, List<String>> mp3 = maxSpeed(mp.get(mp1.get(teams1.getCars()).getPartlist()), budget,
                    mp1.get(teams1.getCars()).getBasespeed(), mp1.get(teams1.getCars()).getTopspeed());
        }

    }
}




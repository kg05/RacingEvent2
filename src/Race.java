import data.*;
import fetcher.*;
import java.io.*;
import java.util.*;

public class Race{

    public static Map<Integer, List<String>> maxSpeed(List<Fetcher1> data, int budget, int topSpeed, int baseSpeed) {
        int i, w;
        int dp[][] = new int[data.size() + 1][budget + 1];
        List<String> partlist = new ArrayList<>();
        Map<Integer, List<String>> mp = new HashMap<>();

        for (i = 0; i <= data.size(); i++) {
            for (w = 0; w <= budget; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (data.get(i - 1).getprice() <= w) {
                    dp[i][w] = Math.max(data.get(i - 1).getSpeedboost() +
                            dp[i - 1][w - data.get(i - 1).getprice()], dp[i - 1][w]);
                    baseSpeed += data.get(i - 1).getSpeedboost();
                    //System.out.println(data.get(i-1).getSpeedboost());
                }
                else
                    dp[i][w] = dp[i - 1][w];


            }
        }

        int res = dp[data.size()][budget];

        w = budget;
        for (i = data.size(); i > 0 && res > 0; i--) {
            if (res == dp[i - 1][w])
                continue;
            else {
                partlist.add(data.get(i - 1).getPartid());
                res = res - data.get(i - 1).getSpeedboost();
                w = w - data.get(i - 1).getprice();
            }
        }

        partlist.add(w+"");
        mp.put(res, partlist);
        return mp;
    }

    public static void main(String[] args){
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

        TreeMap<Integer, Map<Teams, List<String>>> mp4= new TreeMap<>();
        for(Teams teams1 : teams){
            int budget = teams1.getFunds();
            Map<Integer, List<String>> mp3 = maxSpeed(mp.get(mp1.get(teams1.getCars()).getPartlist()), budget,
                    mp1.get(teams1.getCars()).getTopspeed(), mp1.get(teams1.getCars()).getBasespeed());

            Set<Map.Entry<Integer, List<String>> > st = mp3.entrySet();

            for(Map.Entry<Integer, List<String>> me : st) {
                Map<Teams, List<String>> temp = new  HashMap<>();
                temp.put(teams1, me.getValue());
                mp4.put(me.getKey(), temp);
            }
            break;
        }

        System.out.println("Winner\n=====");
        System.out.println("Team:");

        int size = mp4.size();

        Map.Entry<Integer, Map<Teams, List<String>>> e = mp4.lastEntry();

        Set<Map.Entry<Teams, List<String>> > st = e.getValue().entrySet();

        for(Map.Entry<Teams, List<String>> me : st) {
           String car_id = me.getKey().getCars();
           System.out.println(me.getKey().getTeamName()+"\n");
           for(Cars c : cars){
               if(c.getId().equals(car_id)) {
                   System.out.println("Car:\n" + c.getName()+"\n");
                   break;
               }
           }

           System.out.println("Speed achieved:\n" + e.getKey()+"\n\nFunds spent:");
           int fund = Integer.parseInt(me.getValue().get(me.getValue().size()-1));
           System.out.println(fund+"\n\nParts:");

           for(int i = 0; i < me.getValue().size()-1; i++){
               System.out.println(me.getValue().get(i));
           }
        }

    }
}




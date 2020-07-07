package fetcher;

import data.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Fetcher{

    //function for car--->
    public static List<Cars> readCarsFromCSV(String fileName) {
        List<Cars> cars = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Cars car = createCar(attributes);
                cars.add(car);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cars;
    }

    private static Cars createCar(String[] metadata) {
        String a1 = metadata[0];
        String a2 = metadata[1];
        int a3 = Integer.parseInt(metadata[2]);
        int a4 = Integer.parseInt(metadata[3]);
        String a5 = metadata[4];

        return new Cars(a1, a2, a3, a4, a5);
    }

    //function for parts-->
    public static List<Parts> readPartsFromCSV(String fileName) {
        List<Parts> parts = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Parts part = createPart(attributes);
                parts.add(part);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return parts;
    }

    private static Parts createPart(String[] metadata) {
        String a1 = metadata[0];
        String a2 = metadata[1];
        int a3 = Integer.parseInt(metadata[2]);
        int a4 = Integer.parseInt(metadata[3]);

        return new Parts(a1, a2, a3, a4);
    }

    //functio for teams-->
    public static List<Teams> readTeamFromCSV(String fileName) {
        List<Teams> teams = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Teams team = createTeams(attributes);
                teams.add(team);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return teams;
    }

    private static Teams createTeams(String[] metadata) {
        String a1 = metadata[0];
        String a2 = metadata[1];
        String a3 = metadata[2];
        int a4 = Integer.parseInt(metadata[3]);

        return new Teams(a1, a2, a3, a4);
    }
}
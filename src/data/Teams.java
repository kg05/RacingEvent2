package data;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Teams {
    private String teamId;
    private String teamName;
    private String cars;
    private int funds;


    public Teams(String teamId, String teamName, String cars, int funds){
        setTeamId(teamId);
        setTeamName(teamName);
        setCars(cars);
        setFunds(funds);
    }


    public String getTeamId(){
        return teamId;
    }
    public void setTeamId(String teamId){
        this.teamId = teamId;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public String getCars(){
        return cars;
    }
    public void setCars(String cars){
        this.cars = cars;
    }
    public int getFunds(){
        return funds;
    }
    public void setFunds(int funds){
        this.funds = funds;
    }
}

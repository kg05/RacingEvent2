package data;
import java.io.*;
import java.util.*;

public class Parts {
    private String part_list_id;
    private String part_id;
    private int price;
    private int speed_boost;

    public Parts(String part_list_id, String part_id, int price, int speed_boost){
        this.part_list_id = part_list_id;
        this.part_id = part_id;
        this.price = price;
        this.speed_boost = speed_boost;
    }

    public String getPartlist(){
        return part_list_id;
    }

    public String getPartid(){
        return part_id;
    }

    public int getprice(){
        return price;
    }

    public int getSpeedboost(){
        return speed_boost;
    }
}

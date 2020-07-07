package fetcher;

public class Fetcher1 {
    private String part_id;
    private int price;
    private int speed_boost;

    public Fetcher1(String part_id, int price, int speed_boost){
        this.part_id = part_id;
        this.price = price;
        this.speed_boost = speed_boost;
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

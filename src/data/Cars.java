package data;

public class Cars {
    private String cars_id;
    private String car_name;
    private int base_speed;
    private int top_speed;
    private String part_list_id;

    public Cars(String cars_id, String car_name, int base_speed, int top_speed, String part_list_id){
        this.cars_id = cars_id;
        this.car_name = car_name;
        this.base_speed = base_speed;
        this.top_speed = top_speed;
        this.part_list_id = part_list_id;
    }

    public String getId(){
        return cars_id;
    }

    public String getName(){
        return car_name;
    }

    public int getBasespeed(){
        return base_speed;
    }

    public int getTopspeed(){
        return top_speed;
    }

    public String getPartlist(){
        return part_list_id;
    }
}

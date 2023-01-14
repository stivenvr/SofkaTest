package model;

public class Launcher implements Spacecraft{
    private String name;
    private String type;
    private String fuel;
    private int thrust;
    private int weight;
    private int height;
    public Launcher(){
        System.out.println("You have created a Rocket Launcher");
    }
    @Override
    public void startEngine() {
        System.out.println("The engine of the "+ this.name + " has started");
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String getFuel() {
        return fuel;
    }
    @Override
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    @Override
    public int getThrust() {
        return thrust;
    }
    @Override
    public void setThrust(String thrust) {
        this.thrust = Integer.parseInt(thrust);
    }
    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public void setWeight(String weight) {
        this.weight = Integer.parseInt(weight);
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setHeight(String height) {
        this.height = Integer.parseInt(height);
    }
}

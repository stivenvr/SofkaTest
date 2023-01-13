package model;

public class Spacecraft{

    //here are the variables the child classes will inherit
    private String name;
    private String type;    
    private String fuel;
    private int thrust;
    private int weight;
    private int height;
    private int numOfEngines;

    public void Spacecraft(String name, String type, String fuel, int thrust, int weight, int height, int numOfEngines){ /* */
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.thrust = thrust;
        this.weight = weight;
        this.height = height;
        this.numOfEngines = numOfEngines;
    }
}
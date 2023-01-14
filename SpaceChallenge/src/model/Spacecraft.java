package model;
public interface Spacecraft {
    public default void startEngine() {
        System.out.println("The engines have started");
    }

    public static void stopEngine() {
        System.out.println("The engines have stopped");
    }
    public String getName();
    public void setName(String name);
    public String getType();
    public void setType(String type);
    public String getFuel();
    public void setFuel(String fuel);
    public int getThrust();
    public void setThrust(String thrust);
    public int getWeight();
    public void setWeight(String weight);
    public int getHeight();
    public void setHeight(String height);
}

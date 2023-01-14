package model;

public class Factory {
    public static Spacecraft create(String type){ //This is the factory tha creates any of the crafts
        switch (type){
            case "Rocket Launcher":
                return new Launcher();
            case "Unmanned Spacecraft":
                return new UnmannedCraft();
            case "Manned Spacecraft":
                return new MannedCraft();
            default:
                return null;
        }
    }
}

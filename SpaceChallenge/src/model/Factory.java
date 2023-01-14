package model;

public class Factory {
    public static Spacecraft create(String type){
        switch (type){
            case "Rocket Launcher":
                System.out.println("Created a rocket launcher");
                return new Launcher();
            case "Unmanned Spacecraft":
                System.out.println("Created a unmanned craft");
                return new UnmannedCraft();
            case "Manned Spacecraft":
                System.out.println("Created a manned craft");
                return new MannedCraft();
            default:
                return null;
        }
    }
}

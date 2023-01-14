import controller.Controller;
import model.Connect;
import model.Spacecraft;
import view.View;

public class Main {
    public static void main(String[] args) {
        //The main only creates a view and the controller to start the program
        View view = new View();
        Controller con = new Controller(view);
    }
}
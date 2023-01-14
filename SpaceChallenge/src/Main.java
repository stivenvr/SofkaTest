import controller.Controller;
import model.Connect;
import model.Spacecraft;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller con = new Controller(view);
    }
}
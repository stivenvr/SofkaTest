import model.Spacecraft;
import view.View;
import controller.Controller;

public class App {
    public static void main(String[] args) throws Exception {
        Spacecraft mod = new Spacecraft();
        View vie = new View();
        Controller con = new Controller(vie, mod);

        con.start();
        vie.setVisible(true);
    }
}
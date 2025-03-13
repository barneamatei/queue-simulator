import model.SimulationManager;
import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args){
        View view=new View();
        SimulationManager sim= new SimulationManager(view);
        Controller controller = new Controller(sim,view);
        view.setVisible(true);
    }
}

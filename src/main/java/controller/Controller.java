package controller;

import model.SimulationManager;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View v;
    private SimulationManager s;
    private Thread t;
    public Controller(SimulationManager s,View v){
        this.s=s;
        this.v=v;
        t= new Thread(s);
        v.summitListener(new summitActionListener());
        v.startListener(new startActionListener());
    }
    public class summitActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int N,Q,timeLim,tMaxA,tMinA,tMaxS,tMinS;
            N = Integer.parseInt(v.getUserInputN());
            Q = Integer.parseInt(v.getUserInputQ());
            timeLim = Integer.parseInt(v.getUserInputTimeLimit());
            tMaxA = Integer.parseInt(v.getUserInputTMaxA());
            tMinA = Integer.parseInt(v.getUserInputTMinA());
            tMaxS = Integer.parseInt(v.getUserInputTMaxS());
            tMinS = Integer.parseInt(v.getUserInputTMinS());
            s.setNumberOfServers(Q);
            s.setNumberOfClients(N);
            s.setTimeLimit(timeLim);
            s.setMaxArrivalTime(tMaxA);
            s.setMinArrivalTime(tMinA);
            s.setMaxProcessingTime(tMaxS);
            s.setMinProcessingTime(tMinS);
        }
    }
    public class startActionListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            s.generate();
            v.reset();
            t.start();
        }
    }
}

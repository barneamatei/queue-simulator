package strategy;

import model.Server;
import model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task t) {
        int id,min=Integer.MAX_VALUE;
        Server aux=null;
        for(Server i: servers){
            if(min>i.getWaitingPeriod()){
                min=i.getSizeQueue();
                aux=i;
            }
        }
        aux.addTask(t);
        t.setWaitingTime(aux.getWaitingPeriod());
    }
}

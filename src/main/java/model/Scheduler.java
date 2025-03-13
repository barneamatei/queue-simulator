package model;

import model.Server;
import model.Task;
import strategy.ConcreteStrategyQueue;
import strategy.ConcreteStrategyTime;
import strategy.SelectionPolicy;
import strategy.Strategy;

import java.util.ArrayList;
import java.util.List;


public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private List<Thread> threads;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        this.servers = new ArrayList<>();
        this.threads=new ArrayList<Thread>(maxNoServers);

        for(int i=0;i<maxNoServers;i++){
            Server server = new Server(i,maxTasksPerServer);
            servers.add(server);
            Thread t =new Thread(server,"Q"+(i+1));
            threads.add(t);
            t.start();
        }
    }

    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE)
            strategy = new ConcreteStrategyQueue();
        if(policy == SelectionPolicy.SHORTEST_TIME)
            strategy = new ConcreteStrategyTime();
    }

    public void dispatchTask(Task t){
        strategy.addTask(servers,t);
    }

    public List<Server> getServers(){
        return servers;
    }

    public void stopThreads() {
        for(Thread t:threads){
            t.interrupt();
        }
    }

    public int getServersSize() {
        return this.servers.size();
    }

    public Server getServer(int i) {
        return this.servers.get(i);
    }
}

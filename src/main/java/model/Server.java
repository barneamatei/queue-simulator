package model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class Server implements Runnable{
    private ArrayBlockingQueue<Task> tasks;
    private int waitingPeriod;
    private int id;
    private int serverWaitingPeriod;



    public Server(int id, int m) {
        this.id=id;
        this.waitingPeriod=0;
        this.serverWaitingPeriod=0;
        this.tasks = new ArrayBlockingQueue<Task>(m);
    }
    public void addTask(Task newTask){
        tasks.add(newTask);
        waitingPeriod=newTask.getProcessingPeriod();
    }

    public ArrayBlockingQueue<Task> getTasks(){
        return tasks;
    }

    @Override
    public void run() {
        while (true) { // Rulare continuă a firului de execuție
           while(tasks.peek()!=null){
               Task t = tasks.peek();
               try{
                   Thread.sleep(1000);
                   this.waitingPeriod--;
                   int time=t.getProcessingPeriod();
                   time--;
                   t.setProcessingPeriod(time);
                   if(t.getProcessingPeriod()==0){
                       tasks.take();
                   }
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
           }
        }
    }

    public int getWaitingPeriod() {
        return this.waitingPeriod;
    }

    public int getSizeQueue() {
        return this.tasks.size();
    }

    public String toString(){
        String r="";
        if(this.waitingPeriod == 0 || tasks.peek() == null || tasks.peek().getProcessingPeriod() == 0 || tasks.size()==0){
            r="CLOSED";
        }
        else{
            r=tasks.toString();
        }
        return r;
    }
}

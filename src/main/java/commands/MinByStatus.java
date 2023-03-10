package commands;

import managers.CollectionManager;
import worker_related.Worker;

import java.util.Map;

public class MinByStatus implements Command {
    CollectionManager colMan;
    public MinByStatus(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        Map<Long, Worker> workerMap =colMan.getWorkerMap();
        Worker minStatusWorker = null;
        for (Worker worker : workerMap.values()){
            if(minStatusWorker == null || worker.getStatus().compareTo(minStatusWorker.getStatus()) < 0){
                minStatusWorker = worker;
            }
        }
        if (minStatusWorker != null) {
            System.out.println(minStatusWorker);
        } else {
            System.out.println("No workers found in the collection");
        }
    }
    @Override
    public String name() { return "min_by_status"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out all elements with the lowest status value"; }
    @Override
    public String argType() { return ""; }
}

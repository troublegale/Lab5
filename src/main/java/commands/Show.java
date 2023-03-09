package commands;

import managers.CollectionManager;

import worker_related.Worker;



public class Show implements Command {
    CollectionManager colMan;
    public Show(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        if (colMan.getWorkerMap().isEmpty()){
            System.out.println("There is nothing to show.");
        } else {
            for (Worker worker : colMan.getWorkerMap().values()){
                System.out.println(worker);
            }
        }
    }
    @Override
    public String name() { return "show"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out all elements of the collection"; }
    @Override
    public String argType() { return ""; }
}

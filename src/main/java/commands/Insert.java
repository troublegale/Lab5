package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import worker_related.Worker;

public class Insert implements Command {
    CollectionManager colMan;
    public Insert(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        if (colMan.getWorkerMap().isEmpty()){
            System.out.println("This collection is empty.");
            return;
        }
        Long key = (Long) argument;
        if (!colMan.getWorkerMap().containsKey(key)) {
            System.out.println("Inserting a new element under the key = " + key + ".");
            System.out.println("To exit the inserting sequence without saving, use '/exit'.");
            try {
                colMan.getWorkerMap().put(key, colMan.freshWorker(key));
                System.out.println("The following element has been added to the collection:");
                System.out.println(colMan.getWorkerMap().get(key));
            } catch (ExitException e) {
                System.out.println("Insert canceled.");
            }
        } else {
            System.out.println("The collection already contains an element with such key.");
        }
    }
    @Override
    public String name() { return "insert"; }
    @Override
    public String arg() { return "{key(long value)}"; }
    @Override
    public String description() { return "add a new element to the collection using the given key"; }
    @Override
    public String argType() { return "long"; }
}

package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import managers.UserInteractionManager;
import worker_related.*;

public class Update implements Command {

    CollectionManager colMan;

    public Update(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        long updatingID = (long) argument;
        if (!colMan.getWorkerMap().containsKey(updatingID)) {
            System.out.println("The collection doesn't contain an element with such id.");
        } else {
            System.out.println("To skip input and keep the old value of the field, use '/skip'.");
            System.out.println("To exit the updating sequence without saving, use '/exit'.");
            try {
                colMan.getWorkerMap().replace(updatingID, colMan.createNewWorker(updatingID));
                System.out.println("Worker with id = " + updatingID + " has been updated. Now it looks like this:");
                System.out.println(colMan.getWorkerMap().get(updatingID));
            } catch (ExitException e) {
                System.out.println("Update canceled.");
            }
        }
    }

    @Override
    public String name() {
        return "update";
    }

    @Override
    public String arg() {
        return "{id(long value)}";
    }

    @Override
    public String description() {
        return "update an element with the given id field value";
    }

    @Override
    public String argType() {
        return "long";
    }
}

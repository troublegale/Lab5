package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import worker_related.Worker;

public class ReplaceIfLower implements Command {
    CollectionManager colMan;
    public ReplaceIfLower(CollectionManager colMan) {
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
            System.out.println("The collection doesn't contain an element with such key.");
        } else {
            System.out.println("To skip input and keep the old value of the field, use '/skip'.");
            System.out.println("To exit the inserting sequence without saving, use '/exit'.");
            try {
                Worker newWorker = colMan.workerForReplacement(key);
                if (newWorker.compareTo(colMan.getWorkerMap().get(key)) < 0) {
                    colMan.getWorkerMap().replace(key, newWorker);
                    System.out.println("The element under the key = " + key + " has been replaced.");
                } else {
                    System.out.println("The new element is greater than the old one or equal to it. The element hasn't been replaced.");
                }
            } catch (ExitException e) {
                System.out.println("Replacing canceled.");
            }
        }
    }
    @Override
    public String name() { return "replace_if_lower"; }
    @Override
    public String arg() { return "{key(long value)}"; }
    @Override
    public String description() { return "replace an element with the given key if the newly described element is lower than the current"; }
    @Override
    public String argType() { return "long"; }
}

package commands;

import managers.CollectionManager;
import worker_related.Worker;

public class RemoveKey implements Command {
    private CollectionManager colMan;

    public RemoveKey(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        Long key = (Long) argument;
        for (Worker worker : colMan.getWorkerMap().values()) {
            if (worker.getId() == key) {
                colMan.getWorkerMap().values().remove(worker);
                System.out.println("Collection element with key " + key + " has been successfully deleted.");
                return;
            }
        }
        System.out.println("There is no collection element with such key");
    }

    @Override
    public String name() {
        return "remove_key";
    }

    @Override
    public String arg() {
        return "{key(long value)}";
    }

    @Override
    public String description() {
        return "delete an element with the given key from the collection";
    }

    @Override
    public String argType() {
        return "long";
    }
}

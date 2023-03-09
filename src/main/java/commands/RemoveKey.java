package commands;

import managers.CollectionManager;

public class RemoveKey implements Command {
    private CollectionManager colMan;
    public RemoveKey(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        Integer key = (Integer) argument;
        colMan.getWorkerMap();
    }
    @Override
    public String name() { return "remove_key"; }
    @Override
    public String arg() { return "{key(integer value)}"; }
    @Override
    public String description() { return "delete an element with the given key from the collection"; }
    @Override
    public String argType() { return "int"; }
}

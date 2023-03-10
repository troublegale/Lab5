package commands;

import managers.CollectionManager;
import worker_related.Worker;

public class Insert implements Command {
    CollectionManager colMan;
    public Insert(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {

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

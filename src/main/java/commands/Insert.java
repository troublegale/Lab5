package commands;

import managers.CollectionManager;

public class Insert implements Command {
    public Insert(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "insert"; }
    @Override
    public String arg() { return "{key(integer value)}"; }
    @Override
    public String description() { return "add a new element to the collection using the given key"; }
    @Override
    public String argType() { return "int"; }
}

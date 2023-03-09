package commands;

import managers.CollectionManager;

public class RemoveLowerKey implements Command {
    CollectionManager colMan;
    public RemoveLowerKey(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "remove_lower_key"; }
    @Override
    public String arg() { return "{key(integer value)}"; }
    @Override
    public String description() { return "remove all elements with the key lower than given from the collection"; }
    @Override
    public String argType() { return "int"; }
}

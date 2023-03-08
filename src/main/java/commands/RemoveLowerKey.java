package commands;

import managers.CollectionManager;

public class RemoveLowerKey implements Command {
    public RemoveLowerKey(CollectionManager colMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "remove_lower_key {key(integer value)}"; }
    @Override
    public String description() { return "remove all elements with the key lower than given from the collection"; }
}

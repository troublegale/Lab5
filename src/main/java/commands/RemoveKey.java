package commands;

import managers.CollectionManager;

public class RemoveKey implements Command {
    public RemoveKey(CollectionManager colMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "remove_key {key(integer value)}"; }
    @Override
    public String description() { return "delete an element with the given key from the collection"; }
}

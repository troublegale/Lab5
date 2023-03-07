package commands;

import managers.CollectionManager;

public class Info implements Command {
    public Info(CollectionManager colMan) {

    }

    @Override
    public void execute() {

    }
    @Override
    public String name() { return "info"; }
    @Override
    public String description() { return "print out the information about the collection"; }
}

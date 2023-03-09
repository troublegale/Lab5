package commands;

import managers.CollectionManager;

public class Show implements Command {
    public Show(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "Show"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out all elements of the collection"; }
    @Override
    public String argType() { return ""; }
}

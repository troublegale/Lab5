package commands;

import managers.CollectionManager;

public class MinByStatus implements Command {
    public MinByStatus(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "min_by_status"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out all elements with the lowest status value"; }
    @Override
    public String argType() { return ""; }
}

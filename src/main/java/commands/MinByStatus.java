package commands;

import managers.CollectionManager;

public class MinByStatus implements Command {
    public MinByStatus(CollectionManager colMan) {

    }

    @Override
    public void execute() {

    }
    @Override
    public String name() { return "min_by_status"; }
    @Override
    public String description() { return "print out all elements with the lowest Status field value"; }
}

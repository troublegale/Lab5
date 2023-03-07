package commands;

import managers.CollectionManager;

public class Update implements Command {
    public Update(CollectionManager colMan) {

    }

    @Override
    public void execute() {

    }
    @Override
    public String name() { return "update {id(long value)}"; }
    @Override
    public String description() { return "update an element with the given id field value"; }
}

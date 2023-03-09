package commands;

import managers.CollectionManager;

public class Update implements Command {
    public Update(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "update"; }
    @Override
    public String arg() { return "{id(long value)}"; }
    @Override
    public String description() { return "update an element with the given id field value"; }
    @Override
    public String argType() { return "long"; }
}

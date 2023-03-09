package commands;

import managers.CollectionManager;

public class Clear implements Command {
    public Clear(CollectionManager comMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "clear"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "clear the collection"; }
    @Override
    public String argType() { return ""; }
}

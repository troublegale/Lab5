package commands;

import managers.CollectionManager;

public class Clear implements Command {
    public Clear(CollectionManager comMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "clear"; }
    @Override
    public String description() { return "clear the collection"; }
}

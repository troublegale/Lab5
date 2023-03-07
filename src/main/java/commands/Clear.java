package commands;

import managers.CollectionManager;
import managers.CommandManager;

public class Clear implements Command {
    public Clear(CollectionManager comMan) {

    }

    @Override
    public void execute() {

    }
    @Override
    public String name() { return "clear"; }
    @Override
    public String description() { return "clear the collection"; }
}

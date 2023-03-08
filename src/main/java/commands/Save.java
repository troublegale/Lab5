package commands;

import managers.CollectionManager;

public class Save implements Command {
    public Save(CollectionManager colMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "save"; }
    @Override
    public String description() { return "save the collection to file"; }
}

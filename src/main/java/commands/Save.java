package commands;

import managers.CollectionManager;

public class Save implements Command {
    public Save(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {
        System.out.println("Saving...");
        System.out.println("Successfully saved.");
    }
    @Override
    public String name() { return "save"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "save the collection to file"; }
    @Override
    public String argType() { return ""; }
}

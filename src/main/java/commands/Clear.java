package commands;

import managers.CollectionManager;

public class Clear implements Command {
    CollectionManager colMan;

    public Clear(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        colMan.getWorkerMap().clear();
        System.out.println("Collection has been cleared.");
    }

    @Override
    public String name() {
        return "clear";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "clear the collection";
    }

    @Override
    public String argType() {
        return "";
    }
}

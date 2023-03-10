package commands;

import managers.CollectionManager;

public class Info implements Command {
    CollectionManager colMan;
    public Info(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        System.out.println("Collection stores Workers.");
        System.out.println("Collection's initialization date is " + colMan.getCreationDate() + ".");
        System.out.println("The number of elements is " + colMan.getWorkerMap().size());
        System.out.println("The collection keys are the same as the Workers' id's.");
    }
    @Override
    public String name() { return "info"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out the information about the collection"; }
    @Override
    public String argType() { return ""; }
}

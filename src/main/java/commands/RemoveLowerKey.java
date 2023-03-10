package commands;

import managers.CollectionManager;

public class RemoveLowerKey implements Command {
    CollectionManager colMan;
    public RemoveLowerKey(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        if (colMan.getWorkerMap().isEmpty()){
            System.out.println("This collection is empty.");
            return;
        }
        if (argument == null) {
            System.out.println("Key is not specified.");
            return;
        }
        Long key = Long.parseLong(argument.toString());
        int count = colMan.getWorkerMap().size();
        colMan.getWorkerMap().entrySet().removeIf(entry -> entry.getKey() < key);
        count -=colMan.getWorkerMap().size();
        System.out.println(count + " elements were removed from the collection");
    }
    @Override
    public String name() { return "remove_lower_key"; }
    @Override
    public String arg() { return "{key(long value)}"; }
    @Override
    public String description() { return "remove all elements with the key lower than given from the collection"; }
    @Override
    public String argType() { return "long"; }
}

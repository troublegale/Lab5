package commands;

import managers.CollectionManager;
import worker_related.Worker;

public class ReplaceIfLower implements Command {
    CollectionManager colMan;
    public ReplaceIfLower(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "replace_if_lower"; }
    @Override
    public String arg() { return "{key(integer value)}"; }
    @Override
    public String description() { return "replace an element with the given key if the newly described element is lower than the current"; }
    @Override
    public String argType() { return "int"; }
}

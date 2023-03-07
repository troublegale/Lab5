package commands;

import managers.CollectionManager;

public class ReplaceIfLower implements Command {
    public ReplaceIfLower(CollectionManager colMan) {

    }

    @Override
    public void execute() {

    }
    @Override
    public String name() { return "replace_if_lower {key(integer value)}"; }
    @Override
    public String description() { return "replace an element with the given key if the newly described element is lower than the current"; }
}

package commands;

import managers.CollectionManager;

public class FilterGreaterThanOrganization implements Command {
    public FilterGreaterThanOrganization(CollectionManager colMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "filter_greater_than_organization"; }
    @Override
    public String description() { return "print out elements with Organization value greater than given"; }
}

package commands;

import managers.CollectionManager;

public class FilterGreaterThanOrganization implements Command {
    public FilterGreaterThanOrganization(CollectionManager colMan) {

    }

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "filter_greater_than_organization"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out elements with Organization value greater than given"; }
    @Override
    public String argType() { return ""; }
}

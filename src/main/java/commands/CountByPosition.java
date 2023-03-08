package commands;

import managers.CollectionManager;

public class CountByPosition implements Command {
    public CountByPosition(CollectionManager colMan) {

    }

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "count_by_position {position(head_of_department, developer, manager_of_cleaning)}"; }
    @Override
    public String description() { return "print out the number of elements with Position field value equal to given"; }
}

package commands;

import managers.CollectionManager;
import worker_related.Position;
import worker_related.Worker;

import java.util.Map;

public class CountByPosition implements Command {
    CollectionManager colMan;

    public CountByPosition(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        Position position;
        try {
            position = Position.valueOf(argument.toString().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position value. Allowed values: HEAD_OF_DEPARTMENT, DEVELOPER, MANAGER_OF_CLEANING");
            return;
        }

        Map<Long, Worker> workerMap = colMan.getWorkerMap();
        long count = workerMap.values().stream().filter(worker -> worker.getPosition() == position).count();
        System.out.println("Number of elements with Position field equal to " + position + ": " + count);
    }

    @Override
    public String name() {
        return "count_by_position";
    }

    @Override
    public String arg() {
        return "{position(head_of_department, developer, manager_of_cleaning)}";
    }

    @Override
    public String description() {
        return "print out the number of elements with Position field value equal to given";
    }

    @Override
    public String argType() {
        return "position";
    }
}

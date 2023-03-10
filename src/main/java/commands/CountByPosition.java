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
        Position position = (Position) argument;
        int count = 0;
        for (Worker w : colMan.getWorkerMap().values()) {
            if (w.getPosition() == argument) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The collection doesn't contain elements with such position value.");
        } else {
            System.out.println("The collection contains " + count + " element(s) with position = " + argument + ".");
        }
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

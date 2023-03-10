package commands;

import managers.CollectionManager;
import worker_related.Status;
import worker_related.Worker;

import java.util.*;

public class MinByStatus implements Command {
    CollectionManager colMan;

    public MinByStatus(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        System.out.println("Minimal status is " + Status.minStatus() + ".");
        int count = 0;
        for (Worker w : colMan.getWorkerMap().values()) {
            if (w.getStatus() == Status.FIRED) {
                System.out.println(w);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The collection doesn't contain elements with the minimal status value.");
        }

    }

    @Override
    public String name() {
        return "min_by_status";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "print out all elements with the lowest status value";
    }

    @Override
    public String argType() {
        return "";
    }
}

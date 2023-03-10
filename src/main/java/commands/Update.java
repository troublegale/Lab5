package commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import exceptions.WrongInputFormatException;
import managers.CollectionManager;
import managers.UserInteractionManager;
import worker_related.*;

public class Update implements Command {

    CollectionManager colMan;

    public Update(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        long updatingID = (long) argument;
        if (!colMan.getWorkerMap().keySet().contains(updatingID)) {
            System.out.println("The collection doesn't contain an element with such id.");
        } else {
            colMan.getWorkerMap().replace(updatingID, CollectionManager.createNewWorker(updatingID));
            System.out.println("Worker with id = " + updatingID + " has been updated.");
        }
    }

    @Override
    public String name() {
        return "update";
    }

    @Override
    public String arg() {
        return "{id(long value)}";
    }

    @Override
    public String description() {
        return "update an element with the given id field value";
    }

    @Override
    public String argType() {
        return "long";
    }
}

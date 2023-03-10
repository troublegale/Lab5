package commands;

import exceptions.ExitException;
import managers.CollectionManager;
import worker_related.Organization;
import worker_related.Worker;

import java.util.Map;
import java.util.Objects;

public class FilterGreaterThanOrganization implements Command {
    CollectionManager colMan;

    public FilterGreaterThanOrganization(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        System.out.println("To exit the organization describing sequence without finishing, use '/exit'.");
        System.out.println("Target organization:");
        try {
            int count = 0;
            Organization targetOrg = colMan.buildOrganization();
            for (Worker w : colMan.getWorkerMap().values()) {
                if (!Objects.isNull(w.getOrganization())) {
                    if (targetOrg.compareTo(w.getOrganization()) < 0) {
                        count++;
                        System.out.println(w);
                    }
                }
            }
            if (count == 0) {
                System.out.println("The collection doesn't contain elements with organization value greater than given.");
            }
        } catch (ExitException e) {
            System.out.println("Description canceled.");
        }
    }

    @Override
    public String name() {
        return "filter_greater_than_organization";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "print out elements with Organization value greater than given";
    }

    @Override
    public String argType() {
        return "";
    }
}

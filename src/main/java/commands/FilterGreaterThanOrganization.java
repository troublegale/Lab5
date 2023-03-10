package commands;

import managers.CollectionManager;
import worker_related.Organization;
import worker_related.Worker;

import java.util.Map;

public class FilterGreaterThanOrganization implements Command {
    CollectionManager colMan;
    public FilterGreaterThanOrganization(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        Map<Long, Worker> workerMap = colMan.getWorkerMap();
        if (workerMap.isEmpty()){
            System.out.println("This collection is empty.");
            return;
        }
        Organization org;
        try {
            org = (Organization) argument;
        } catch (ClassCastException e) {
            System.err.println("This argument must be an Organization");
            return;
        }
        if (org == null) {
            System.out.println("Organization is null.");
        }
        System.out.println("Elements of the collection with organization greater than " + org.getFullName() + ":");
        workerMap.values().stream()
                .filter(worker -> worker.getOrganization() != null)
                .filter(worker -> worker.getOrganization().compareTo(org) > 0)
                .forEach(worker -> System.out.println("\t" + worker));
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

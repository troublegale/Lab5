package commands;

import worker_related.Worker;

import java.util.Map;

public class Insert implements Command {
    @Override
    public Map<Integer, Worker> execute(Map<Integer, Worker> workerMap) {

    }

    @Override
    public boolean requiresArgs() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

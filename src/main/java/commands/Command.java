package commands;

import worker_related.Worker;

import java.util.Map;

public interface Command {
    Map<Integer, Worker> execute(Map<Integer, Worker> workerMap);
    boolean requiresArgs();
    String getName();
    String getDescription();
}

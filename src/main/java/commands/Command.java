package commands;

import worker_related.Worker;

import java.util.Map;

public interface Command {
    public void execute();
    public String name();
    public String description();
}

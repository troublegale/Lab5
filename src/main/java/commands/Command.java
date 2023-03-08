package commands;

public interface Command {
    public void execute(String argument);
    public String name();
    public String description();
}

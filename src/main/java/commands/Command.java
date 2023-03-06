package commands;

public interface Command {
    void execute();
    void type();
    String getName();
    String getDescription();
}

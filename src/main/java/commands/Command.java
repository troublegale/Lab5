package commands;

public interface Command {
    void execute(Object argument);

    String name();

    String arg();

    String description();

    String argType();
}

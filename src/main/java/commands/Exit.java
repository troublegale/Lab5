package commands;

public class Exit implements Command {

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "exit"; }
    @Override
    public String description() { return "stop the application without saving"; }
}

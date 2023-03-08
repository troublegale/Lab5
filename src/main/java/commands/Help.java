package commands;

public class Help implements Command {

    @Override
    public void execute(String argument) {
    }
    @Override
    public String name() { return "help"; }
    @Override
    public String description() { return "print out the list of available commands"; }
}

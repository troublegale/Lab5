package commands;

public class History implements Command {

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "history"; }
    @Override
    public String description() { return "print out 6 last executed commands"; }
}

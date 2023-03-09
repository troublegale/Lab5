package commands;

public class History implements Command {

    @Override
    public void execute(Object argument) {

    }
    @Override
    public String name() { return "history"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "print out 6 last executed commands"; }
    @Override
    public String argType() { return ""; }
}

package commands;

import java.util.ArrayList;

public class Help implements Command {

    public Help(ArrayList<Command> commands) {

    }

    @Override
    public void execute(String argument) {
    }
    @Override
    public String name() { return "help"; }
    @Override
    public String description() { return "print out the list of available commands"; }
}

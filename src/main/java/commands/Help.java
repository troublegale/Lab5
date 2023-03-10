package commands;

import java.util.ArrayList;

public class Help implements Command {
    ArrayList<Command> commands;

    public Help(ArrayList<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Object argument) {
        for (Command c : commands) {
            if (c.arg().equals("")) {
                System.out.println("'" + c.name() + "' - " + c.description());
            } else {
                System.out.println("'" + c.name() + "' " + c.arg() + " - " + c.description());
            }
        }
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "print out the list of available commands";
    }

    @Override
    public String argType() {
        return "";
    }
}

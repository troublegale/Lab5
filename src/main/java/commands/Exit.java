package commands;

import exceptions.ExitException;

public class Exit implements Command {

    @Override
    public void execute(Object argument) {
        throw new ExitException();
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "stop the application without saving";
    }

    @Override
    public String argType() {
        return "";
    }
}

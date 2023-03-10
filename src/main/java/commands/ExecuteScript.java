package commands;

public class ExecuteScript implements Command {

    @Override
    public void execute(Object argument) {

    }

    @Override
    public String name() {
        return "execute_script";
    }

    @Override
    public String arg() {
        return "{file_path}";
    }

    @Override
    public String description() {
        return "execute the sequence of commands from a file";
    }

    @Override
    public String argType() {
        return "filepath";
    }
}

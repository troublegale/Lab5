package commands;

public class Test implements Command {
    @Override
    public void execute(Object argument) {
        if (!argument.toString().isEmpty()) {
            System.out.println("Test command with argument " + argument);
        } else {
            System.out.println("Test command with no argument");
        }
    }

    @Override
    public String name() {
        return "test";
    }

    @Override
    public String arg() {
        return "[something]";
    }

    @Override
    public String description() {
        return "just a test command";
    }

    @Override
    public String argType() {
        return "";
    }
}

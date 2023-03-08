package commands;

public class Test implements Command {
    @Override
    public void execute(String argument) {
        System.out.println("Test command with argument " + argument);
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}

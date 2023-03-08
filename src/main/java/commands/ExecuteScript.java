package commands;

public class ExecuteScript implements Command {

    @Override
    public void execute(String argument) {

    }
    @Override
    public String name() { return "execute_script {file_path}"; }
    @Override
    public String description() { return "execute the sequence of commands from a file"; }
}

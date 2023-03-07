import managers.CommandManager;

public class App {
    public static void main(String[] args) {

        CommandManager comMan = new CommandManager();
        System.out.println(comMan.hasCommand("info"));

    }
}

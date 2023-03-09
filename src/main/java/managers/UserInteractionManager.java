package managers;

import exceptions.ExitException;

import java.util.Scanner;

public class UserInteractionManager {
    private final Scanner scanner = new Scanner(System.in);
    private CommandManager comMan;

    public UserInteractionManager (CommandManager comMan) {
        this.comMan = comMan;
    }

    public void start() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Welcome to WorkerManager. Please, start typing in commands.");
        System.out.println("To see information about available commands, use 'help'.");
        System.out.println("-----------------------------------------------------------");
    }

    public void handleInput() {
        String[] currentInput = scanner.nextLine().strip().split("\\s+");
        String command = currentInput[0].toLowerCase();
        if (!command.equals("")) {
            if (!comMan.hasCommand(command)) {
                System.out.println("Non-existent command. To see information about available commands, use 'help'.");
            } else {
                if (currentInput.length > 1) {
                    comMan.setArgument(currentInput[1]);
                } else {
                    comMan.setArgument("");
                }
                comMan.handleCommand(command);

            }
        }
    }

    public void interact() {
        start();
        while (true) {
            System.out.print("> ");
            try {
                handleInput();
            } catch (ExitException e) {
                System.out.println("Any changes past the last 'save' command were not saved.");
                System.out.println("Shutting down...");
                break;
            }
        }
    }

}

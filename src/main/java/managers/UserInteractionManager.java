package managers;

import exceptions.ExitException;
import exceptions.WrongInputFormatException;
import worker_related.Position;
import worker_related.Status;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

    public static Integer readInteger() throws WrongInputFormatException {
        try { return Integer.parseInt(new Scanner(System.in).nextLine()); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper integer value.");
            throw new WrongInputFormatException();
        }
    }

    public static Long readLong() throws WrongInputFormatException {
        try { return Long.parseLong(new Scanner(System.in).nextLine()); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper long value.");
            throw new WrongInputFormatException();
        }
    }

    public static Double readDouble() throws WrongInputFormatException {
        try { return Double.parseDouble(new Scanner(System.in).nextLine()); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper double precision value.");
            throw new WrongInputFormatException();
        }
    }

    public static Position readPosition() throws WrongInputFormatException {
        try { return Position.valueOf(new Scanner(System.in).nextLine().toUpperCase()); }
        catch (IllegalArgumentException e) {
            System.out.println("Please, enter a proper Position value.");
            throw new WrongInputFormatException();
        }
    }

    public static Status readStatus() throws WrongInputFormatException {
        try { return Status.valueOf(new Scanner(System.in).nextLine().toUpperCase()); }
        catch (IllegalArgumentException e) {
            System.out.println("Please, enter a proper Status value.");
            throw new WrongInputFormatException();
        }
    }

    public static LocalDate readLocalDate() throws WrongInputFormatException {
        try { return LocalDate.parse(new Scanner(System.in).nextLine()); }
        catch (DateTimeParseException e) {
            System.out.println("Please, enter the date in a proper format.");
            throw new WrongInputFormatException();
        }
    }

}

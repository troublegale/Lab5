package managers;

import commands.Exit;
import exceptions.ExitException;
import exceptions.SkipInputException;
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

    public static Integer readInteger(boolean nullable, boolean emptying) throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equals("")) {
            if (emptying) {
                System.out.println("Zero was used.");
                return 0;
            } else {
                System.out.println("This field can't be empty.");
                throw new WrongInputFormatException();
            }
        }
        if (input.equalsIgnoreCase("null")) {
            if (nullable) {
                System.out.println("Zero was used.");
                return 0;
            } else {
                System.out.println("This field can't be null.");
                throw new WrongInputFormatException();
            }
        }
        try { return Integer.parseInt(input); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper integer value.");
            throw new WrongInputFormatException();
        }
    }

    public static Long readLong(boolean nullable, boolean emptying) throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equals("")) {
            if (emptying) {
                System.out.println("Zero was used.");
                return 0L;
            } else {
                System.out.println("This field can't be empty.");
                throw new WrongInputFormatException();
            }
        }
        if (input.equalsIgnoreCase("null")) {
            if (nullable) {
                System.out.println("Zero was used.");
                return 0L;
            } else {
                System.out.println("This field can't be null.");
                throw new WrongInputFormatException();
            }
        }
        try { return Long.parseLong(input); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper long value.");
            throw new WrongInputFormatException();
        }
    }

    public static Double readDouble(boolean nullable, boolean emptying) throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equals("")) {
            if (emptying) {
                System.out.println("Zero was used.");
                return 0D;
            } else {
                System.out.println("This field can't be empty.");
                throw new WrongInputFormatException();
            }
        }
        if (input.equalsIgnoreCase("null")) {
            if (nullable) {
                System.out.println("Zero was used");
                return 0D;
            } else {
                System.out.println("This field can't be null.");
                throw new WrongInputFormatException();
            }
        }
        try { return Double.parseDouble(input); }
        catch (NumberFormatException e) {
            System.out.println("Please, enter a proper double precision value.");
            throw new WrongInputFormatException();
        }
    }

    public static Position readPosition() throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equalsIgnoreCase("null")) { return null; }
        if (input.equals("")) {
            System.out.println("Default status (" + Position.defaultPosition() + ") was used.");
            return Position.defaultPosition();
        }
        try { return Position.valueOf(input.toUpperCase()); }
        catch (IllegalArgumentException e) {
            System.out.println("Please, enter a proper Position value.");
            throw new WrongInputFormatException();
        }
    }

    public static Status readStatus() throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equalsIgnoreCase("null")) { return null; }
        if (input.equals("")) {
            System.out.println("Default status (" + Status.defaultStatus() + ") was used.");
            return Status.defaultStatus();
        }
        try { return Status.valueOf(input.toUpperCase()); }
        catch (IllegalArgumentException e) {
            System.out.println("Please, enter a proper Status value.");
            throw new WrongInputFormatException();
        }
    }

    public static LocalDate readLocalDate() throws WrongInputFormatException, SkipInputException {
        String input = new Scanner(System.in).nextLine();
        if (input.trim().equalsIgnoreCase("/exit")) {
            throw new ExitException();
        }
        if (input.trim().equalsIgnoreCase("/skip")) {
            throw new SkipInputException();
        }
        if (input.equalsIgnoreCase("null")) {
            System.out.println("This field can't be null.");
            throw new WrongInputFormatException();
        }
        if (input.equals("")) {
            System.out.println("Current date was used.");
            return LocalDate.now();
        }
        try { return LocalDate.parse(input); }
        catch (DateTimeParseException e) {
            System.out.println("Please, enter the date in a proper format.");
            throw new WrongInputFormatException();
        }
    }

}

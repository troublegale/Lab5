package commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import managers.CollectionManager;
import worker_related.*;

public class Update implements Command {

    CollectionManager colMan;

    public Update(CollectionManager colMan) {
        this.colMan = colMan;
    }

    @Override
    public void execute(Object argument) {
        long id;
        try {
            id = Long.parseLong((String) argument);
        } catch (NumberFormatException e) {
            System.out.println("ID should be of 'long' type. Command format: '" + name() + " " + arg() + "'.");
            return;
        }
        Worker worker = colMan.getWorkerMap().get(id);
        if (worker == null) {
            System.out.println("There is no worker with ID = " + id + " in the collection.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String name = readString(scanner, "Enter the worker's name: ");
        double x = readInt(scanner, "Enter the X coordinate of the worker's location: ");
        double y = readFloat(scanner, "Enter the Y coordinate of the worker's location: ");
        String fullName = readString(scanner, "Enter full name of the worker's organization: ");
        Integer annualTurnover = readInt(scanner, "Enter annual turnover of the worker's organization: ");
        Long employeesCount = readLong(scanner, "Enter employees count of the worker's organization: ");
        String street = readString(scanner, "Enter street of the worker's organization: ");
        String zipCode = readString(scanner, "Enter zip code of the worker's organization: ");
        LocalDate startDate = LocalDate.now();
        float salary = readFloat(scanner, "Enter the worker's salary: ");
        Position position = readPosition(scanner);
        Status status = readStatus(scanner);
        Worker newWorker = new Worker(worker.getId(), name, new Coordinates((double) x, (double) y), worker.getCreationDate(), (int) salary, (LocalDate) startDate, position, status, new Organization((String) fullName, (Integer) annualTurnover, (Long) employeesCount, new Address((String) street, (String) zipCode)));
        newWorker.setId(worker.getId());
        newWorker.setCreationDate(worker.getCreationDate());
        colMan.getWorkerMap().replace((int) id, newWorker);
        System.out.println("Worker with ID = " + id + " was successfully updated in the collection.");
    }

    private Long readLong(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Long.");
            }
        }
    }

    private String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private float readFloat(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid float.");
            }
        }
    }

    private Position readPosition(Scanner scanner) {
        while (true) {
            System.out.print("Enter the worker's position (head_of_department, developer, manager_of_cleaning): ");
            String positionStr = scanner.nextLine();
            try {
                return Position.valueOf(positionStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid position.");
            }
        }
    }

    private Status readStatus(Scanner scanner) {
        while (true) {
            System.out.print("Enter the worker's status (FIRED, HIRED, RECOMMENDED_FOR_PROMOTION): ");
            String statusStr = scanner.nextLine();
            try {
                return Status.valueOf(statusStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid status.");
            }
        }
    }

    @Override
    public String name() {
        return "update";
    }

    @Override
    public String arg() {
        return "{id(long value)}";
    }

    @Override
    public String description() {
        return "update an element with the given id field value";
    }

    @Override
    public String argType() {
        return "long";
    }
}

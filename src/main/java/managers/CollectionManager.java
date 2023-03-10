package managers;
import exceptions.WrongInputFormatException;
import worker_related.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class CollectionManager {
    private HashMap<Long, Worker> workerMap;
    private String creationDate;

    public CollectionManager(HashMap<Long, Worker> workerMap, String creationDate) {
        this.workerMap = workerMap;
        this.creationDate = creationDate;
    }

    public static Worker createNewWorker(long id) {
        Scanner scanner = new Scanner(System.in);
        String newName;
        double newX;
        Double newY;
        Coordinates newCoordinates;
        int newSalary;
        LocalDate newStartDate;
        Position newPosition = null;
        Status newStatus = null;
        Organization newOrganization = null;
        System.out.println("Enter name:");
        while (true) {
            System.out.print(">> ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Worker's name can't be empty.");
            } else {
                newName = name;
                break;
            }
        }
        System.out.println("Enter coordinates:");
        System.out.println("X coordinate (double precision value):");
        while (true) {
            System.out.print(">> ");
            try {
                newX = UserInteractionManager.readDouble();
                break;
            } catch (WrongInputFormatException e) {
                continue;
            }
        }
        System.out.println("Y coordinate (double precision value):");
        while (true) {
            System.out.print(">> ");
            try {
                newY = UserInteractionManager.readDouble();
                break;
            } catch (WrongInputFormatException e) {
                continue;
            }
        }
        newCoordinates = new Coordinates(newX, newY);
        System.out.println("Enter salary (integer value, > 0):");
        while (true) {
            System.out.print(">> ");
            try {
                newSalary = UserInteractionManager.readInteger();
                if (newSalary > 0) {
                    break;
                } else {
                    System.out.println("Salary has to be greater than 0.");
                }
            } catch (WrongInputFormatException e) {
                continue;
            }
        }
        System.out.println("Enter starting date (YYYY-MM-DD):");
        while (true) {
            System.out.print(">> ");
            try {
                newStartDate = UserInteractionManager.readLocalDate();
                break;
            } catch (WrongInputFormatException e) {
                continue;
            }
        }
        System.out.println("Set position or keep it null? (1/2)");
        while (true) {
            System.out.print(">> ");
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 2) {
                break;
            } else if (answer == 1) {
                System.out.print("New position (");
                StringBuilder sb = new StringBuilder();
                for (Position p : Position.values()) {
                    sb.append(p.toString()).append(", ");
                }
                String positions = sb.toString();
                for (int i = 0; i < positions.length() - 2; i++) {
                    System.out.print(positions.toCharArray()[i]);
                }
                System.out.println("):");
                while (true) {
                    System.out.print(">> ");
                    try {
                        newPosition = UserInteractionManager.readPosition();
                        break;
                    } catch (WrongInputFormatException e) {
                        continue;
                    }
                }
                break;
            } else {
                System.out.println("Please, enter 1 or 2.");
            }
        }
        System.out.println("Set status or keep it null? (1/2)");
        while (true) {
            System.out.print(">> ");
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 2) {
                break;
            } else if (answer == 1) {
                System.out.print("New status (");
                StringBuilder sb = new StringBuilder();
                for (Status s : Status.values()) {
                    sb.append(s.toString()).append(", ");
                }
                String statuses = sb.toString();
                for (int i = 0; i < statuses.length() - 2; i++) {
                    System.out.print(statuses.toCharArray()[i]);
                }
                System.out.println("):");
                while (true) {
                    System.out.print(">> ");
                    try {
                        newStatus = UserInteractionManager.readStatus();
                        break;
                    } catch (WrongInputFormatException e) {
                        continue;
                    }
                }
                break;
            } else {
                System.out.println("Please, enter 1 or 2.");
            }
        }
        System.out.println("Set organization or keep it null? (1/2)");
        while (true) {
            System.out.print(">> ");
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 2) {
                break;
            } else if (answer == 1) {
                Address newAddress = new Address(null, "");
                newOrganization = new Organization("", 1, 1L, newAddress);
                System.out.println("New organization:");
                System.out.println("Organization's name:");
                System.out.print(">> ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    newOrganization.setFullName("empty");
                } else {
                    newOrganization.setFullName(name);
                }
                System.out.println("Organization's annual turnover (integer value, > 0");
                while (true) {
                    System.out.print(">> ");
                    try {
                        int turnover = UserInteractionManager.readInteger();
                        if (turnover > 0) {
                            newOrganization.setAnnualTurnover(turnover);
                            break;
                        } else {
                            System.out.println("Annual turnover has to be greater than 0.");
                        }
                    } catch (WrongInputFormatException e) {
                        continue;
                    }
                }
                System.out.println("Organization's employee number (long value, > 0");
                while (true) {
                    System.out.print(">> ");
                    try {
                        long employeeCount = UserInteractionManager.readLong();
                        if (employeeCount > 0) {
                            newOrganization.setEmployeesCount(employeeCount);
                            break;
                        } else {
                            System.out.println("Employee number has to be greater than 0.");
                        }
                    } catch (WrongInputFormatException e) {
                        continue;
                    }
                }
                System.out.println("Organization's address:");
                System.out.println("Street");
                System.out.print(">> ");
                String street = scanner.nextLine();
                if (street.equals("")) {
                    newAddress.setStreet("empty");
                } else {
                    newAddress.setStreet(street);
                }
                System.out.println("Zip code:");
                System.out.print(">> ");
                String zip = scanner.nextLine();
                if (zip.equals("")) {
                    newAddress.setStreet("empty");
                } else {
                    newAddress.setStreet(zip);
                }
                newOrganization.setPostalAddress(newAddress);
                break;
            } else {
                System.out.println("Please, enter 1 or 2.");
            }
        }
        return new Worker(id, newName, newCoordinates, LocalDate.now(), newSalary, newStartDate, newPosition,
                newStatus, newOrganization);
    }


    public HashMap<Long, Worker> getWorkerMap() { return workerMap; }
    public void setWorkerMap(HashMap<Long, Worker> workerMap) { this.workerMap = workerMap; }
    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }
}

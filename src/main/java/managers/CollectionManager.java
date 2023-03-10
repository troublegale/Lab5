package managers;
import exceptions.ExitException;
import exceptions.SkipInputException;
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
    public int determineRoute(String answer) {
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public Worker createNewWorker(long id) throws ExitException {
        Scanner scanner = new Scanner(System.in);
        String newName;
        double newX;
        double newY;
        Coordinates newCoordinates;
        int newSalary;
        LocalDate newStartDate;
        Position newPosition = null;
        Status newStatus = null;
        Organization newOrganization = null;
        System.out.println("Enter name:");
        while (true) {
            System.out.print(">> ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (name.equalsIgnoreCase("/skip")) {
                newName = workerMap.get(id).getName();
                System.out.println("Skipped.");
                break;
            } else {
                if (name.equalsIgnoreCase("null")) {
                    System.out.println("This field can't be null.");
                } else {
                    if (name.isEmpty()) {
                        System.out.println("This field can't be empty.");
                    } else {
                        newName = name;
                        break;
                    }
                }
            }
        }
        System.out.println("Enter coordinates:");
        System.out.println("--X coordinate (double precision value):");
        while (true) {
            System.out.print("-->> ");
            try {
                newX = UserInteractionManager.readDouble(true, true);
                break;
            } catch (WrongInputFormatException e) {
                continue;
            } catch (SkipInputException e) {
                newX = workerMap.get(id).getCoordinates().getX();
                System.out.println("Skipped.");
                break;
            }
        }
        System.out.println("--Y coordinate (double precision value):");
        while (true) {
            System.out.print("-->> ");
            try {
                newY = UserInteractionManager.readDouble(false, true);
                break;
            } catch (WrongInputFormatException e) {
                continue;
            } catch (SkipInputException e) {
                newY = workerMap.get(id).getCoordinates().getY();
                System.out.println("Skipped.");
                break;
            }
        }
        newCoordinates = new Coordinates(newX, newY);
        System.out.println("Enter salary (integer value, > 0):");
        while (true) {
            System.out.print(">> ");
            try {
                newSalary = UserInteractionManager.readInteger(false, false);
                if (newSalary > 0) {
                    break;
                } else {
                    System.out.println("Salary has to be greater than 0.");
                }
            } catch (WrongInputFormatException e) {
                continue;
            } catch (SkipInputException e) {
                newSalary = workerMap.get(id).getSalary();
                System.out.println("Skipped.");
                break;
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
            } catch (SkipInputException e) {
                newStartDate = workerMap.get(id).getStartDate();
                System.out.println("Skipped.");
                break;
            }
        }
        System.out.println("Set position or keep it null? (1/2)");
        boolean set = false;
        while (true) {
            System.out.print(">> ");
            String answer = scanner.nextLine();
            if (answer.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (answer.trim().equalsIgnoreCase("/skip")) {
                newPosition = workerMap.get(id).getPosition();
                System.out.println("Skipped.");
                break;
            } else {
                int route = determineRoute(answer);
                if (route == 2) {
                    break;
                } else if (route == 1) {
                    set = true;
                    break;
                } else {
                    System.out.println("Please, enter 1 or 2.");
                }
            }
        }
        if (set) {
            System.out.print("New position (");
            StringBuilder sb = new StringBuilder();
            for (Position p : Position.values()) {
                sb.append(p.toString()).append(", ");
            }
            for (int i = 0; i < sb.toString().toCharArray().length - 2; i ++) {
                System.out.print(sb.toString().toCharArray()[i]);
            }
            System.out.println("):");
            while (true) {
                System.out.print(">> ");
                try {
                    newPosition = UserInteractionManager.readPosition();
                    break;
                } catch (WrongInputFormatException e) {
                    continue;
                } catch (SkipInputException e) {
                    newPosition = workerMap.get(id).getPosition();
                    System.out.println("Skipped.");
                    break;
                }
            }
        }
        System.out.println("Set status or keep it null? (1/2)");
        set = false;
        while (true) {
            System.out.print(">> ");
            String answer = scanner.nextLine();
            if (answer.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (answer.trim().equalsIgnoreCase("/skip")) {
                newStatus = workerMap.get(id).getStatus();
                System.out.println("Skipped.");
                break;
            } else {
                int route = determineRoute(answer);
                if (route == 2) {
                    break;
                } else if (route == 1) {
                    set = true;
                    break;
                } else {
                    System.out.println("Please, enter 1 or 2.");
                }
            }
        }
        if (set) {
            System.out.print("New status(");
            StringBuilder sb = new StringBuilder();
            for (Status s : Status.values()) {
                sb.append(s.toString()).append(", ");
            }
            for (int i = 0; i < sb.toString().toCharArray().length - 2; i ++) {
                System.out.print(sb.toString().toCharArray()[i]);
            }
            System.out.println("):");
            while (true) {
                System.out.print(">> ");
                try {
                    newStatus = UserInteractionManager.readStatus();
                    break;
                } catch (WrongInputFormatException e) {
                    continue;
                } catch (SkipInputException e) {
                    newStatus = workerMap.get(id).getStatus();
                    System.out.println("Skipped.");
                    break;
                }
            }
        }
        System.out.println("Set organization or keep it null? (1/2)");
        set = false;
        while (true) {
            System.out.print(">> ");
            String answer = scanner.nextLine();
            if (answer.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (answer.trim().equalsIgnoreCase("/skip")) {
                newOrganization = workerMap.get(id).getOrganization();
                System.out.println("Skipped.");
                break;
            } else {
                int route = determineRoute(answer);
                if (route == 2) {
                    break;
                } else if (route == 1) {
                    set = true;
                    break;
                } else {
                    System.out.println("Please, enter 1 or 2.");
                }
            }
        }
        if (set) {
            Address newAddress = new Address(null, "");
            newOrganization = new Organization("", 1, 1L, newAddress);
            System.out.println("New organization:");
            System.out.println("--Organization's name:");
            System.out.print("-->> ");
            String name = scanner.nextLine();
            if (name.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (name.trim().equalsIgnoreCase("/skip")) {
                newOrganization.setFullName(workerMap.get(id).getOrganization().getFullName());
                System.out.println("Skipped.");
            } else {
                if (!name.equals("")) {
                    newOrganization.setFullName("empty");
                } else {
                    newOrganization.setFullName(name);
                }
                System.out.println("--Organization's annual turnover (integer value, > 0):");
                while (true) {
                    System.out.print("-->> ");
                    try {
                        int turnover = UserInteractionManager.readInteger(false, false);
                        if (turnover > 0) {
                            newOrganization.setAnnualTurnover(turnover);
                            break;
                        } else {
                            System.out.println("Annual turnover has to be greater than 0.");
                        }
                    } catch (WrongInputFormatException e) {
                        continue;
                    } catch (SkipInputException e) {
                        newOrganization.setAnnualTurnover(workerMap.get(id).getOrganization().getAnnualTurnover());
                        System.out.println("Skipped.");
                        break;
                    }
                }
            }
            System.out.println("--Organization's employee number (long value, > 0):");
            while (true) {
                System.out.print("-->> ");
                try {
                    long employeeCount = UserInteractionManager.readLong(false, false);
                    if (employeeCount > 0) {
                        newOrganization.setEmployeesCount(employeeCount);
                        break;
                    } else {
                        System.out.println("Employee number has to be greater than 0.");
                    }
                } catch (WrongInputFormatException e) {
                    continue;
                } catch (SkipInputException e) {
                    newOrganization.setEmployeesCount(workerMap.get(id).getOrganization().getEmployeesCount());
                    System.out.println("Skipped.");
                    break;
                }
            }
            System.out.println("--Organization's address:");
            System.out.println("----Street:");
            System.out.print("---->> ");
            String street = scanner.nextLine();
            if (street.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (street.trim().equalsIgnoreCase("/skip")) {
                newAddress.setStreet(workerMap.get(id).getOrganization().getPostalAddress().getStreet());
                System.out.println("Skipped.");
            } else {
                if (street.equals("")) {
                    newAddress.setStreet("empty");
                } else {
                    newAddress.setStreet(street);
                }
            }
            System.out.println("----Zip code:");
            System.out.print("---->> ");
            String zip = scanner.nextLine();
            if (zip.trim().equalsIgnoreCase("/exit")) {
                throw new ExitException();
            }
            if (zip.trim().equalsIgnoreCase("/skip")) {
                newAddress.setZipCode(workerMap.get(id).getOrganization().getPostalAddress().getZipCode());
                System.out.println("Skipped.");
            } else {
                if (zip.equals("")) {
                    newAddress.setZipCode("empty");
                } else {
                    newAddress.setZipCode(zip);
                }
            }
            newOrganization.setPostalAddress(newAddress);
        }
        return new Worker(id, newName, newCoordinates, LocalDate.now(), newSalary, newStartDate, newPosition,
                newStatus, newOrganization);
    }


    public HashMap<Long, Worker> getWorkerMap() { return workerMap; }
    public void setWorkerMap(HashMap<Long, Worker> workerMap) { this.workerMap = workerMap; }
    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }
}

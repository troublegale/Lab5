package worker_related;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Worker implements Comparable<Worker> {
    private long id; // >0, auto-generated, unique
    private String name; // not null, not empty
    private Coordinates coordinates; // not null
    private java.time.LocalDate creationDate; // not null, auto-generated
    private int salary; // > 0
    private java.time.LocalDate startDate; // not null
    private Position position; // can be null
    private Status status; // can be null
    private Organization organization; // can be null

    public Worker(long id, String name, Coordinates coordinates, java.time.LocalDate creationDate, int salary,
                  java.time.LocalDate startDate, Position position, Status status, Organization organization) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Worker(id=" + id + "; name=" + name + "; coordinates=" + coordinates +
                "; creationdate=" + creationDate + "; salary=" + salary + "; startdate=" +
                startDate + "; position=" + position + "; status=" + status + ";\norganization=" +
                organization + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id && salary == worker.salary && name.equals(worker.name) &&
                coordinates.equals(worker.coordinates) && creationDate.equals(worker.creationDate) &&
                startDate.equals(worker.startDate) && position == worker.position &&
                status == worker.status && Objects.equals(organization, worker.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary, startDate, position, status, organization);
    }

    @Override
    public int compareTo(Worker worker) {
        if (this.status == Status.FIRED && worker.status != Status.FIRED) {
            return -1;
        }
        if (this.status != Status.FIRED && worker.status == Status.FIRED) {
            return 1;
        }
        if (this.position == Position.HEAD_OF_DEPARTMENT && worker.position != Position.HEAD_OF_DEPARTMENT) {
            return 1;
        }
        if (this.position != Position.HEAD_OF_DEPARTMENT && worker.position == Position.HEAD_OF_DEPARTMENT) {
            return -1;
        }
        if (this.status == Status.RECOMMENDED_FOR_PROMOTION && worker.status != Status.RECOMMENDED_FOR_PROMOTION) {
            return 1;
        }
        if (this.status != Status.RECOMMENDED_FOR_PROMOTION && worker.status == Status.RECOMMENDED_FOR_PROMOTION) {
            return -1;
        }
        if (this.salary > worker.salary) {
            return 1;
        } else if (this.salary < worker.salary) {
            return -1;
        }
        try {
            if (this.organization.compareTo(worker.organization) > 0) {
                return 1;
            } else if (this.organization.compareTo(worker.organization) < 0) {
                return -1;
            }
        } catch (NullPointerException e) {
            System.out.println("One (both) of the Workers' organizations is (are) null, thus organization field will not participate in the comparison.");
        }
        return Character.compare(this.name.charAt(0), worker.name.charAt(0));
    }
}

package worker_related;

import java.time.LocalDate;

public class Worker {
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

    public long getId() {return this.id;}
    public void setId(long id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public Coordinates getCoordinates() {return coordinates;}
    public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}
    public LocalDate getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}
    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    public Organization getOrganization() {return organization;}
    public void setOrganization(Organization organization) {this.organization = organization;}

    public String toString() {
        return "Worker(id=" + this.id + "; name=" + this.name + "; coordinates=" + this.coordinates +
                "; creationdate=" + this.creationDate + "; salary=" + this.salary + "; startdate=" +
                this.startDate + "; position=" + this.position + "; status=" + this.status + ";\norganization=" +
                this.organization + ")";
    }
}

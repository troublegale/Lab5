package worker_related;

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
}

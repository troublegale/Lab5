package worker_related;

public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION,
    REGULAR;

    public static Status defaultStatus() { return REGULAR; }
    public static Status minStatus() { return FIRED; }
}

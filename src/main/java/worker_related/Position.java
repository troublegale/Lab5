package worker_related;

public enum Position {
    HEAD_OF_DEPARTMENT,
    DEVELOPER,
    MANAGER_OF_CLEANING;

    public static Position defaultPosition() { return DEVELOPER; }
}

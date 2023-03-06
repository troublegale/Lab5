package worker_related;

public class Coordinates {
    private double x;
    private Double y; // not null

    public Coordinates(double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

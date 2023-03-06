package worker_related;

import java.util.Objects;

public class Coordinates {
    private double x;
    private Double y; // not null

    public Coordinates(double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public Double getY() { return y; }
    public void setY(Double y) { this.y = y; }

    @Override
    public String toString() { return "(" + this.x + ", " + this.y + ")"; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return Double.compare(x, coordinates.x) == 0 && y.equals(coordinates.y);
    }
    @Override
    public int hashCode() { return Objects.hash(x, y); }
}

package worker_related;

public class Address {
    private String street; // can be null
    private String zipCode; // not null

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    public String toString() {
        return this.zipCode + ", " + this.street;
    }
}

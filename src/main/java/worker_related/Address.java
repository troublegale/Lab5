package worker_related;

import java.util.Objects;

public class Address {
    private String street; // can be null
    private String zipCode; // not null

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() { return this.zipCode + ", " + this.street; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) && zipCode.equals(address.zipCode);
    }
    @Override
    public int hashCode() { return Objects.hash(street, zipCode); }
}

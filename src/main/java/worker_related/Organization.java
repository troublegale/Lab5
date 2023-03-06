package worker_related;

import java.util.Objects;

public class Organization {
    private String fullName; // not null
    private Integer annualTurnover; // > 0, not null
    private Long employeesCount; // > 0, not null
    private Address postalAddress; // not null

    public Organization(String fullName, Integer annualTurnover, Long employeesCount, Address postalAddress) {
        this. fullName = fullName;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return this.fullName + "(annualturnover=" + this.annualTurnover + "; employeecount=" + this.employeesCount +
                "; postaladdress=" + this.postalAddress + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization organization = (Organization) o;
        return fullName.equals(organization.fullName) && annualTurnover.equals(organization.annualTurnover) &&
                employeesCount.equals(organization.employeesCount) && postalAddress.equals(organization.postalAddress);
    }
    @Override
    public int hashCode() { return Objects.hash(fullName, annualTurnover, employeesCount, postalAddress); }
}

package worker_related;

import java.util.Objects;

public class Organization implements Comparable<Organization> {
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

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public Integer getAnnualTurnover() { return annualTurnover; }
    public void setAnnualTurnover(Integer annualTurnover) { this.annualTurnover = annualTurnover; }
    public Long getEmployeesCount() { return employeesCount; }
    public void setEmployeesCount(Long employeesCount) { this.employeesCount = employeesCount; }
    public Address getPostalAddress() { return postalAddress; }
    public void setPostalAddress(Address postalAddress) { this.postalAddress = postalAddress; }

    @Override
    public String toString() {
        return this.fullName + "(annual_turnover=" + this.annualTurnover + "; employee_count=" + this.employeesCount +
                "; postal_address=" + this.postalAddress + ")";
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
    @Override
    public int compareTo(Organization org) {
        if (this.annualTurnover > org.annualTurnover) {
            return 1;
        }
        if (this.annualTurnover < org.annualTurnover) {
            return -1;
        }
        if (this.employeesCount > org.employeesCount) {
            return 1;
        }
        if (this.employeesCount < org.employeesCount) {
            return -1;
        }
        return Character.compare(this.fullName.charAt(0), org.fullName.charAt(0));
    }
}

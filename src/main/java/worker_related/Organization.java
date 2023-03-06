package worker_related;

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

    public String toString() {
        return this.fullName + "(annualturnover=" + this.annualTurnover + "; employeecount=" + this.employeesCount +
                "; postaladdress=" + this.postalAddress + ")";
    }
}

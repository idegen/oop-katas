package initial;

public class Address {
    private Employee employee;

    public Address(Employee employee) {
        this.employee = employee;
    }

    public String printAddress() {
        return employee.getHouseNumber() + "; "
                + employee.getHouseName() + "; "
                + employee.getStreetName() + "; "
                + employee.getCityName()  + "; "
                + employee.getPostCode();
    }
}

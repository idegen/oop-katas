package initial;

public class Address {
    private Employee employee;

    public void printAddress(){
        System.out.println(employee.getHouseNumber());
        System.out.println(employee.getHouseName());
        System.out.println(employee.getStreetName());
        System.out.println(employee.getCityName());
        System.out.println(employee.getPostCode());
    }
}

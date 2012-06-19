package extended;

public class PaymentTeam {

    public void printPayslipForAEmployee(Employee employee){
        System.out.println(String.format("Employee Details: \n First name: %s\tSure name: %s \n Payment Type: %s\tSalary in %s: %.2f", employee.getFirstName(),
                employee.getSureName(), employee.getPaymentType(), employee.getPaymentCurrency(), employee.calculateSalary()));
    }
}

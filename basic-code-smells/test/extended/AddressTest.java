package extended;

import initial.Address;
import initial.Employee;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddressTest {
    @Test
    public void testPrintsAddress() throws Exception {
        initial.Employee employee = new Employee("Felicity", "Brooks", 5, "", "Lemon Road", "Cantebury", "W5 C56");
        Address address = new Address(employee);

        assertThat(address.printAddress(), is("5; ; Lemon Road; Cantebury; W5 C56"));
    }
}

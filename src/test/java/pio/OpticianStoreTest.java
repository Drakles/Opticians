package pio;

import org.junit.Assert;
import org.junit.Test;
import pio.person.Client;
import pio.person.CustomerServiceEmployee;
import pio.person.Doctor;
import pio.person.Owner;

import java.math.BigInteger;
import java.time.LocalDate;

public class OpticianStoreTest {

    @Test
    public void singletonTestName() {
        OpticiansStore optyk = new OpticiansStore();
        optyk.setName("Idea-optyk");

        Assert.assertEquals(optyk.getName(), "Idea-optyk");
    }

    @Test
    public void addOwner() {
        OpticiansStore.getOwners().add(new Owner("Agata", "Dymkiewicz"));
        Assert.assertTrue(OpticiansStore.getOwners().size() == 1);
        Assert.assertEquals(OpticiansStore.getOwners().get(0).getName(), "Agata");
        Assert.assertEquals(OpticiansStore.getOwners().get(0).getSurname(), "Dymkiewicz");
    }

    @Test
    public void addClients() {
        int actualNumberClients = OpticiansStore.getClients().size();
        Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1
                , 10),"95011023522");
        OpticiansStore.getClients().add(client);
        Assert.assertTrue(OpticiansStore.getClients().size() - 1 == actualNumberClients);
        Assert.assertEquals(OpticiansStore.getClients().get(OpticiansStore.getClients().size() - 1), client);
    }

    @Test
    public void addEmployee() {
        int actualNumberEmployee = OpticiansStore.getCustomerServiceEmployees().size();
        CustomerServiceEmployee employee = new CustomerServiceEmployee("Izabela", "Nowaczyk");
        OpticiansStore.getCustomerServiceEmployees().add(employee);
        Assert.assertTrue(OpticiansStore.getCustomerServiceEmployees().size() - 1 == actualNumberEmployee);
        Assert.assertEquals(OpticiansStore.getCustomerServiceEmployees().get(OpticiansStore
                .getCustomerServiceEmployees().size() - 1), employee);
    }

    @Test
    public void addDoctor() {
        int actualNumberDoctors = OpticiansStore.getDoctors().size();
        Doctor doctor = new Doctor("Izabela", "Nowaczyk");
        OpticiansStore.getDoctors().add(doctor);
        Assert.assertTrue(OpticiansStore.getDoctors().size() - 1 == actualNumberDoctors);
        Assert.assertEquals(OpticiansStore.getDoctors().get(OpticiansStore.getDoctors().size() - 1), doctor);
    }


}

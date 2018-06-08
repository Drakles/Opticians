package PIOl;

import PIOl.person.Client;
import PIOl.person.CustomerServiceEmployee;
import PIOl.schedule.WorkDay;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerServiceEmployeeTest {

    @Test
    public void simpleCustomerServiceEmpoyeeTest() {
        CustomerServiceEmployee izabela = new CustomerServiceEmployee("Izabela", "Nowaczyk");
        System.out.println(OpticiansStore.getClients().size());

        int currentNumberOfClients = OpticiansStore.getClients().size();
        izabela.addClient(new Client("Jan", "Kowalski", LocalDate.of(1996, 10
                , 21), BigInteger.valueOf(95011023522L)));

        System.out.println(OpticiansStore.getClients().size());
        Assert.assertTrue(currentNumberOfClients == OpticiansStore.getClients().size() - 1);
    }

    @Test
    public void scheduleTest() {
        CustomerServiceEmployee izabela = new CustomerServiceEmployee("Izabela", "Nowaczyk");
        izabela.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 2, 10, 0)
                , LocalDateTime.of(2018, 6, 2, 18, 0)));
        int sumHours = izabela.getSchedule().getWorkDays().stream().mapToInt(workday -> workday.getEndDate()
                .minusHours(workday.getStartDate().getHour()).getHour()).sum();
        Assert.assertTrue(sumHours == 8);
    }

    @Test
    public void addVisit() {
        OpticiansStore.getCustomerServiceEmployees().add(new CustomerServiceEmployee("Izabela"
                , "Nowaczyk"));
        CustomerServiceEmployee izabela = OpticiansStore.getCustomerServiceEmployees().get(OpticiansStore
                .getCustomerServiceEmployees().size() - 1);
        Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10)
                , BigInteger.valueOf(95011023522L));
        izabela.addClient(client);

//        System.out.println(dupa);

//        int resultCode = izabela.addVisit(client, LocalDateTime.of(2018, 6, 5, 10
//                , 30),);
//        Assert.assertTrue(resultCode == VisitErrorCodes.VISIT_CONFIRMED);
    }

}

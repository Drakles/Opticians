package pio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import junit.framework.Assert;
import org.junit.Test;
import pio.person.Client;
import pio.person.CustomerServiceEmployee;
import pio.person.Doctor;
import pio.schedule.WorkDay;
import pio.visit.VisitErrorCodes;

public class CustomerServiceEmployeeTest {

  @Test
  public void simpleCustomerServiceEmpoyeeTest() {
    CustomerServiceEmployee izabela = new CustomerServiceEmployee("Izabela", "Nowaczyk");
    int currentNumberOfClients = OpticiansStore.getClients().size();
    izabela.addClient(new Client("Jan", "Kowalski", LocalDate.of(1996, 10
        , 21), "95011023522"));

    Assert.assertTrue(currentNumberOfClients == OpticiansStore.getClients().size() - 1);
  }

  @Test
  public void scheduleTest() {
    CustomerServiceEmployee izabela = new CustomerServiceEmployee("Izabela", "Nowaczyk");
    izabela.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 2, 10, 0)
        , LocalDateTime.of(2018, 6, 2, 18, 0)));
    int sumHours = izabela.getSchedule().getWorkDays().stream()
        .mapToInt(workday -> workday.getEndDate()
            .minusHours(workday.getStartDate().getHour()).getHour()).sum();
    Assert.assertTrue(sumHours == 8);
  }

  @Test
  public void addVisit() {
    OpticiansStore.getCustomerServiceEmployees().add(new CustomerServiceEmployee("Izabela"
        , "Nowaczyk"));
    CustomerServiceEmployee izabela = OpticiansStore.getCustomerServiceEmployees()
        .get(OpticiansStore
            .getCustomerServiceEmployees().size() - 1);
    Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10)
        , "95011023522");
    izabela.addClient(client);

    Doctor doctor = new Doctor("Jan", "Kowalski");
    OpticiansStore.getDoctors().add(doctor);

    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 18, 0)));

    int resultCode = izabela.addVisit(client, LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 11, 0), doctor);

    Assert.assertTrue(resultCode == VisitErrorCodes.VISIT_OK);
  }

}

package pio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import pio.person.Client;
import pio.person.CustomerServiceEmployee;
import pio.person.Doctor;
import pio.schedule.WorkDay;
import pio.visit.LeansValue;
import pio.visit.Visit;
import pio.visit.VisitErrorCodes;

public class AppTest {

  @Test
  public void systemTest() {
    CustomerServiceEmployee customerServiceEmployee = new CustomerServiceEmployee("Izabela",
        "Nowak");
    OpticiansStore.getCustomerServiceEmployees().add(customerServiceEmployee);

    Client client = new Client("Jan", "Kowalski", LocalDate.of(1996, 12, 12),
        "95122165499");

    customerServiceEmployee.addClient(client);

    Doctor doctor = new Doctor("Agata", "Dabrowska");

    OpticiansStore.getDoctors().add(doctor);

    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 17, 10, 0), LocalDateTime
        .of(2018, 6, 17, 18, 0)));

    Assert.assertEquals(
        customerServiceEmployee.addVisit(client, LocalDateTime.of(2018, 6, 17, 9, 0),
            LocalDateTime
                .of(2018, 6, 17, 10, 0), doctor),
        VisitErrorCodes.VISIT_NOT_IN_RANGE_OF_WORKING_DAY_FOR_GIVEN_DOCTOR);

    Assert.assertEquals(
        customerServiceEmployee.addVisit(client, LocalDateTime.of(2018, 6, 17, 10, 0),
            LocalDateTime
                .of(2018, 6, 17, 11, 0), doctor),
        VisitErrorCodes.VISIT_OK);

    Visit lastDoctorVisit = doctor.getVisits().get(doctor.getVisits().size() - 1);

    lastDoctorVisit.setLeansValue(new LeansValue(-1f, 0.75f));
    lastDoctorVisit.setAdditionalInfo("Patient should buy expensive glasses");

    Visit lastClientVisit = client.getVisits().get(client.getVisits().size() - 1);

    Assert.assertEquals(lastDoctorVisit, lastClientVisit);

    lastClientVisit.setLens("Hoya super extra expensive glasses");

    Assert.assertEquals(lastClientVisit.getDoctor(), doctor);
    Assert.assertEquals(lastClientVisit.getPatient(), client);
    Assert
        .assertEquals(lastDoctorVisit.getAdditionalInfo(), "Patient should buy expensive glasses");
    Assert.assertEquals(lastDoctorVisit.getLens(), "Hoya super extra expensive glasses");

  }
}

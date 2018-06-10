package pio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import junit.framework.Assert;
import org.junit.Test;
import pio.person.Client;
import pio.person.Doctor;
import pio.schedule.WorkDay;
import pio.visit.Visit;
import pio.visit.VisitErrorCodes;

public class DoctorTest {

  @Test
  public void testDoctor() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    Assert.assertEquals(doctor.getName(), "Krystyna");
    Assert.assertEquals(doctor.getSurname(), "Pawłowicz");
  }

  @Test
  public void testAssignPatient() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    Assert.assertTrue(OpticiansStore.getClients().size() > 0);
    doctor.assignPatient(OpticiansStore.getClients().get(OpticiansStore.getClients().size() - 1));

    Assert.assertTrue(doctor.getPatients().size() == 1);
    Assert.assertTrue(doctor.getPatients().get(0) != null);

    Assert.assertTrue(doctor.getPatients().get(0).getName().equals("Jan"));
    Assert.assertTrue(doctor.getPatients().get(0).getSurname().equals("Kowalski"));
  }

  @Test
  public void testAllDoctorPatientsInSystem() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    Assert.assertTrue(OpticiansStore.getClients().size() > 0);
    doctor.assignPatient(OpticiansStore.getClients().get(OpticiansStore.getClients().size() - 1));

    Assert
        .assertTrue(doctor.getPatients().stream().allMatch(OpticiansStore.getClients()::contains));
  }

  @Test
  public void addVisitTest() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getDoctors().add(doctor);
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 18, 0)));
    Visit visit = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 30), LocalDateTime.of(2018, 6, 5, 13, 0));
    Assert.assertEquals(VisitErrorCodes.VISIT_OK, doctor.addVisit(visit));
  }

  @Test
  public void addVisitTestNotInWorkingDay() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getDoctors().add(doctor);
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 18, 0)));
    Visit visit = new Visit(LocalDateTime.of(2018, 7, 5, 12
        , 30), LocalDateTime.of(2018, 7, 5, 13, 0));
    Assert.assertEquals(VisitErrorCodes.WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND,
        doctor.addVisit(visit));
  }

  @Test
  public void addVisitTestOtherVisit() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getDoctors().add(doctor);
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 18, 0)));
    Visit visit = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 30), LocalDateTime.of(2018, 6, 5, 13, 0));
    int resultCode = doctor.addVisit(visit);
    Assert.assertEquals(VisitErrorCodes.VISIT_OK, resultCode);
    Assert.assertTrue(doctor.getVisits().size() == 1);

    Visit anotherVisit = new Visit(LocalDateTime.of(2018, 6, 5, 11
        , 30), LocalDateTime.of(2018, 6, 5, 12, 29));
    int resultCode2 = doctor.addVisit(anotherVisit);
    Assert.assertEquals(VisitErrorCodes.VISIT_OK, resultCode2);
  }


  @Test
  public void addVisitTestOtherVisitConflict() {
    Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
    OpticiansStore.getDoctors().add(doctor);
    OpticiansStore.getClients().add(new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522"));
    doctor.addWorkDay(new WorkDay(LocalDateTime.of(2018, 6, 5, 10
        , 30), LocalDateTime.of(2018, 6, 5, 18, 0)));
    Visit visit = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 0), LocalDateTime.of(2018, 6, 5, 13, 0));

    Assert.assertEquals(VisitErrorCodes.VISIT_OK, doctor.addVisit(visit));
    Assert.assertTrue(doctor.getVisits().size() == 1);

    Visit anotherVisit = new Visit(LocalDateTime.of(2018, 6, 5, 11
        , 30), LocalDateTime.of(2018, 6, 5, 12, 30));

    Assert.assertEquals(VisitErrorCodes.OTHER_VISIT_IN_THIS_TIME_FOUND,
        doctor.addVisit(anotherVisit));

    Visit anotherVisit2 = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 30), LocalDateTime.of(2018, 6, 5, 13, 30));

    Assert.assertEquals(VisitErrorCodes.OTHER_VISIT_IN_THIS_TIME_FOUND,
        doctor.addVisit(anotherVisit2));

  }


}

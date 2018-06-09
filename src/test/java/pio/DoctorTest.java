package pio;

import pio.person.Client;
import pio.person.Doctor;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.time.LocalDate;

public class DoctorTest extends TestCase {

    public void testDoctor() {
        Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
        Assert.assertEquals(doctor.getName(), "Krystyna");
        Assert.assertEquals(doctor.getSurname(), "Pawłowicz");
    }

    public void testAssignPatient() {
        Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
        OpticiansStore.getClients().add(new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger
                .valueOf(95011023522L)));
        Assert.assertTrue(OpticiansStore.getClients().size() > 0);
        doctor.assignPatient(OpticiansStore.getClients().get(OpticiansStore.getClients().size() - 1));

        Assert.assertTrue(doctor.getPatients().size() == 1);
        Assert.assertTrue(doctor.getPatients().get(0) != null);

        Assert.assertTrue(doctor.getPatients().get(0).getName().equals("Jan"));
        Assert.assertTrue(doctor.getPatients().get(0).getSurname().equals("Kowalski"));
    }

    public void testAllDoctorPatientsInSystem() {
        Doctor doctor = new Doctor("Krystyna", "Pawłowicz");
        OpticiansStore.getClients().add(new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger
                .valueOf(95011023522L)));
        Assert.assertTrue(OpticiansStore.getClients().size() > 0);
        doctor.assignPatient(OpticiansStore.getClients().get(OpticiansStore.getClients().size() - 1));

        Assert.assertTrue(doctor.getPatients().stream().allMatch(OpticiansStore.getClients()::contains));
    }


}

package pio.person;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Employee {

    private final List<Client> patients;

    public Doctor(String name, String surname) {
        super(name, surname);
        patients = new ArrayList<>();
    }

    public List<Client> getPatients() {
        return patients;
    }

    public void assignPatient(Client patient){
        patients.add(patient);
    }
}

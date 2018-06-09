package pio.person;

import pio.visit.Visit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Doctor extends Employee {

    private final List<Client> patients;
    private final List<Visit> visits;

    public Doctor(String name, String surname) {
        super(name, surname);
        patients = new ArrayList<>();
        visits = new LinkedList<>();
    }

    public List<Client> getPatients() {
        return patients;
    }

    public void assignPatient(Client patient){
        patients.add(patient);
    }

    public List<Visit> getVisits() {
        return visits;
    }

    int addVisit(Visit visit){
//        if(schedule.)



        return 0;
    }
}

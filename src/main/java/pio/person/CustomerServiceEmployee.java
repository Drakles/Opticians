package pio.person;

import pio.OpticiansStore;
import pio.visit.Visit;

import java.time.LocalDateTime;

public class CustomerServiceEmployee extends Employee {

    public CustomerServiceEmployee(String name, String surname) {
        super(name, surname);
    }

    public void addClient(Client client) {
        OpticiansStore.getClients().add(client);
    }

    public int addVisit(Client client, LocalDateTime startDate,LocalDateTime endDate, Doctor doctor) {
        return doctor.addVisit(new Visit(startDate,endDate,client));
    }
}

package pio.person;

import pio.OpticiansStore;

import java.time.LocalDateTime;

public class CustomerServiceEmployee extends Employee {

    public CustomerServiceEmployee(String name, String surname) {
        super(name, surname);
    }

    public void addClient(Client client) {
        OpticiansStore.getClients().add(client);
    }

    public int addVisit(Client client, LocalDateTime of, Doctor doctor) {
        return 0;
    }
}

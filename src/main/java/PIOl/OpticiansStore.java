package PIOl;

import PIOl.person.Client;
import PIOl.person.CustomerServiceEmployee;
import PIOl.person.Doctor;
import PIOl.person.Owner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class OpticiansStore {

    private String name;
    private static final List<Client> clients = new LinkedList<>();
    private static List<Owner> owners = new ArrayList<>(3);
    private static List<CustomerServiceEmployee> customerServiceEmployees = new ArrayList<>(5);;
    private static List<Doctor> doctors = new ArrayList<>(5);

    static List<Owner> getOwners() {
        return owners;
    }

    public static List<CustomerServiceEmployee> getCustomerServiceEmployees() {
        return customerServiceEmployees;
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    private OpticiansStore() {
    }

    static OpticiansStore getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static List<Client> getClients() {
        return clients;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    private static class SingletonHolder {
        private static final OpticiansStore INSTANCE = new OpticiansStore();
    }
}
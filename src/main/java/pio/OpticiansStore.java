package pio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pio.person.Client;
import pio.person.CustomerServiceEmployee;
import pio.person.Doctor;
import pio.person.Owner;

public final class OpticiansStore {

  private static String name;
  private static final List<Client> clients = new LinkedList<>();
  private static final List<Owner> owners = new ArrayList<>(3);
  private static final List<CustomerServiceEmployee> customerServiceEmployees = new ArrayList<>(5);
  private static final List<Doctor> doctors = new ArrayList<>(5);

  static List<Owner> getOwners() {
    return owners;
  }

  static List<CustomerServiceEmployee> getCustomerServiceEmployees() {
    return customerServiceEmployees;
  }

  static List<Doctor> getDoctors() {
    return doctors;
  }

  public static List<Client> getClients() {
    return clients;
  }

  static void setName(String name) {
    OpticiansStore.name = name;
  }

  static String getName() {
    return name;
  }

}
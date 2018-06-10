package pio.person;

import static pio.visit.VisitErrorCodes.VISIT_OK;

import java.time.LocalDateTime;
import pio.OpticiansStore;
import pio.visit.Visit;

public class CustomerServiceEmployee extends Employee {

  public CustomerServiceEmployee(String name, String surname) {
    super(name, surname);
  }

  public void addClient(Client client) {
    OpticiansStore.getClients().add(client);
  }

  public int addVisit(Client client, LocalDateTime startDate, LocalDateTime endDate,
      Doctor doctor) {
    Visit visit = new Visit(startDate, endDate);
    int clientResult = client.addVisit(visit);
    int doctorResult = doctor.addVisit(visit);
    if (clientResult != VISIT_OK) {
      return clientResult;
    } else if (doctorResult != VISIT_OK) {
      return doctorResult;
    } else {
      return VISIT_OK;
    }
  }
}

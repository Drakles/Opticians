package pio.person;

import static pio.visit.VisitErrorCodes.CLIENT_HAVE_VISIT_AT_GIVEN_DATE;
import static pio.visit.VisitErrorCodes.VISIT_OK;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pio.visit.Visit;

public class Client extends Person {

  private final LocalDate bornDate;
  private final String pesel;
  private final List<Visit> visits;

  public Client(String name, String surname, LocalDate bornDate, String pesel) {
    super(name, surname);
    this.bornDate = bornDate;
    this.pesel = pesel;
    visits = new ArrayList<>();
  }

  public LocalDate getBornDate() {
    return bornDate;
  }

  public String getPesel() {
    return pesel;
  }

  public int addVisit(Visit visit) {
    if (!Visit.conflictingVisits(visits, visit)) {
      visits.add(visit);
      visit.setPatient(this);
      return VISIT_OK;
    } else {
      return CLIENT_HAVE_VISIT_AT_GIVEN_DATE;
    }
  }

  public List<Visit> getVisits() {
    return visits;
  }
}

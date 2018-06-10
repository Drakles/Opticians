package pio.person;

import static pio.visit.VisitErrorCodes.OTHER_VISIT_IN_THIS_TIME_FOUND;
import static pio.visit.VisitErrorCodes.VISIT_NOT_IN_RANGE_OF_WORKING_DAY_FOR_GIVEN_DOCTOR;
import static pio.visit.VisitErrorCodes.VISIT_OK;
import static pio.visit.VisitErrorCodes.WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pio.schedule.WorkDay;
import pio.visit.Visit;

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

  public void assignPatient(Client patient) {
    patients.add(patient);
  }

  public List<Visit> getVisits() {
    return visits;
  }

  public int addVisit(Visit visit) {
    WorkDay workDay = schedule.getWorkDay(visit.getStartDate().toLocalDate());
    if (workDay != null) {
      if (inRangeOfWorkingHours(workDay, visit)) {
        if (!Visit.conflictingVisits(visits, visit)) {
          visit.setDoctor(this);
          visits.add(visit);
          return VISIT_OK;
        } else {
          return OTHER_VISIT_IN_THIS_TIME_FOUND;
        }
      } else {
        return VISIT_NOT_IN_RANGE_OF_WORKING_DAY_FOR_GIVEN_DOCTOR;
      }
    } else {
      return WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND;
    }
  }

  private boolean inRangeOfWorkingHours(WorkDay workDay, Visit visit) {
    return ((workDay.getStartDate().compareTo(visit.getStartDate()) <= 0)
        && (workDay.getEndDate().compareTo(visit.getEndDate()) >= 0));
  }
}

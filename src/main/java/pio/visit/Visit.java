package pio.visit;

import java.time.LocalDateTime;
import pio.person.Client;
import pio.person.Doctor;

public class Visit {

  private final LocalDateTime startDate;
  private final LocalDateTime endDate;
  private LeansValue leansValue;
  private String lens;
  private String additionalInfo;
  private static int idIterator = 0;
  private int id;
  private Doctor doctor;
  private Client patient;

  //TODO: implement VistBuilder
  public Visit(LocalDateTime startDate, LocalDateTime endDate) throws IllegalArgumentException {
    if (!startDate.getDayOfWeek().equals(endDate.getDayOfWeek()) && !endDate.isAfter(startDate)) {
      throw new IllegalArgumentException("Visit can be no longer than one day");
    }
    this.startDate = startDate;
    this.endDate = endDate;
    id = idIterator++;
  }

  public Visit(LocalDateTime startDate, LocalDateTime endDate, LeansValue leansValue)
      throws IllegalArgumentException {
    if (!startDate.getDayOfWeek().equals(endDate.getDayOfWeek()) && !endDate.isAfter(startDate)) {
      throw new IllegalArgumentException("Visit can be no longer than one day");
    }
    this.startDate = startDate;
    this.endDate = endDate;
    id = idIterator++;
    this.leansValue = leansValue;
  }

  public Visit(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor)
      throws IllegalArgumentException {
    if (!startDate.getDayOfWeek().equals(endDate.getDayOfWeek()) && !endDate.isAfter(startDate)) {
      throw new IllegalArgumentException("Visit can be no longer than one day");
    }
    this.startDate = startDate;
    this.endDate = endDate;
    id = idIterator++;
    this.doctor = doctor;
  }

  public Visit(LocalDateTime startDate, LocalDateTime endDate, Client patient)
      throws IllegalArgumentException {
    if (!startDate.getDayOfWeek().equals(endDate.getDayOfWeek()) && !endDate.isAfter(startDate)) {
      throw new IllegalArgumentException("Visit can be no longer than one day");
    }
    this.startDate = startDate;
    this.endDate = endDate;
    id = idIterator++;
    this.patient = patient;
  }

  public Visit(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor, Client patient)
      throws IllegalArgumentException {
    if (!startDate.getDayOfWeek().equals(endDate.getDayOfWeek()) && !endDate.isAfter(startDate)) {
      throw new IllegalArgumentException("Visit can be no longer than one day");
    }
    this.startDate = startDate;
    this.endDate = endDate;
    id = idIterator++;
    this.doctor = doctor;
    this.patient = patient;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Client getPatient() {
    return patient;
  }

  public void setPatient(Client patient) {
    this.patient = patient;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public int getId() {
    return id;
  }

  public LeansValue getLeansValue() {
    return leansValue;
  }

  public String getLens() {
    return lens;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setLens(String lens) {
    this.lens = lens;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Visit visit = (Visit) o;
    return id == visit.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}

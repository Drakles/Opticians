package pio.visit;

import pio.person.Client;
import pio.person.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Visit {
    private final LocalDateTime date;
    private LeansValue leansValue;
    private String lens;
    private String additionalInfo;
    private static int idIterator = 0;
    private int id;
    private Doctor doctor;
    private Client patient;

    public Visit(LocalDateTime date) {
        this.date = date;
        id = idIterator++;
    }

    public Visit(LocalDateTime date,LeansValue leansValue){
        this.date = date;
        id = idIterator++;
        this.leansValue = leansValue;
    }

    public Visit(LocalDateTime date,Doctor doctor) {
        this.date = date;
        id = idIterator++;
        this.doctor = doctor;
    }

    public Visit(LocalDateTime date,Client patient){
        this.date = date;
        id = idIterator++;
        this.patient = patient;
    }

    public Visit(LocalDateTime date,Doctor doctor,Client patient) {
        this.date = date;
        id = idIterator++;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDateTime getDate() {
        return date;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id == visit.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

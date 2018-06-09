package pio.person;

import pio.visit.Visit;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private final LocalDate bornDate;
    private final BigInteger pesel;
    private final List<Visit> visits;

    public Client(String name, String surname, LocalDate bornDate, BigInteger pesel) {
        super(name, surname);
        this.bornDate = bornDate;
        this.pesel = pesel;
        visits = new ArrayList<>();
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public BigInteger getPesel() {
        return pesel;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        return visits;
    }
}

package pio.visit;

import java.time.LocalDate;

public class Visit {
    private final LocalDate date;
    private final LeansValue leansValue;
    private String lens;
    private String additionalInfo;
    private static int idIterator = 0;
    private int id;

    public Visit(LocalDate date, LeansValue leansValue) {
        this.date = date;
        this.leansValue = leansValue;
        id = idIterator++;
    }

    public LocalDate getDate() {
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

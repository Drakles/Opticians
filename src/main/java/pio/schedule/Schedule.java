package pio.schedule;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.LinkedList;
import java.util.List;

public class Schedule {
    private final List<WorkDay> workDays = new LinkedList<>();

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public WorkDay getWorkDay(LocalDate date) {
        return workDays.stream().filter(workDay -> workDay.getStartDate().toLocalDate()
            .isEqual(ChronoLocalDate.from(date))).findFirst().orElse(null);
    }
}

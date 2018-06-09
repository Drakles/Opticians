package pio.schedule;

import java.time.LocalDateTime;

public class WorkDay {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public WorkDay(LocalDateTime startDate, LocalDateTime endDate) throws IllegalArgumentException {
        if(!startDate.getDayOfWeek().equals(endDate.getDayOfWeek())) throw new IllegalArgumentException
                ("Parameters for WorkDay should be applied only for one and the same day");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}

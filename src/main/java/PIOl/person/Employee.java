package PIOl.person;

import PIOl.schedule.Schedule;
import PIOl.schedule.WorkDay;

public abstract class Employee extends Person {

    private Schedule schedule;

    Employee(String name, String surname) {
        super(name, surname);
        schedule = new Schedule();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void addWorkDay(WorkDay workDay) {
        schedule.getWorkDays().add(workDay);
    }
}

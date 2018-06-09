package pio;

import org.junit.Assert;
import org.junit.Test;
import pio.schedule.Schedule;
import pio.schedule.WorkDay;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduleTest {
    @Test
    public void getWorkDay() {
        Schedule schedule = new Schedule();
        schedule.getWorkDays().add(new WorkDay(LocalDateTime.of(2018, 6, 18, 10, 0), LocalDateTime.of(2018, 6, 18,
                18, 0)));
        WorkDay workDayFound = schedule.getWorkDay(LocalDate.of(2018, 6, 18));
        Assert.assertEquals(workDayFound, schedule.getWorkDays().get(schedule.getWorkDays().size() - 1));
        Assert.assertNull(schedule.getWorkDay(LocalDate.of(2018,6,19)));
        Assert.assertNull(schedule.getWorkDay(LocalDate.of(2018,6,16)));
    }
}

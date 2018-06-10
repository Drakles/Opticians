package pio;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import pio.schedule.WorkDay;

public class WorkDayTest {

  @Test
  public void simpleWorkDayTest() {
    WorkDay workDay = new WorkDay(LocalDateTime.of(2018, 10, 20, 9, 0),
        LocalDateTime.of(2018, 10, 20, 17, 0));
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 9, 0), workDay.getStartDate());
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 17, 0), workDay.getEndDate());
  }

  @Test
  public void wrongDateTest() {
    try {
      new WorkDay(LocalDateTime.of(2018, 10, 20, 9, 0),
          LocalDateTime.of(2018, 10, 21, 17, 0));
    } catch (IllegalArgumentException e) {
      Assert.assertEquals("Parameters for WorkDay should be applied only for one and the same "
          + "day", e.getMessage());
    }
  }

  @Test
  public void wrongSetDate() {
    WorkDay workDay = new WorkDay(LocalDateTime.of(2018, 10, 20, 9, 0),
        LocalDateTime.of(2018, 10, 20, 17, 0));
    try {
      workDay.setStartDate(LocalDateTime.of(2018, 10, 19, 9, 0));
    } catch (IllegalArgumentException e) {
      Assert.assertEquals("Parameters for WorkDay should be applied only for one and the same "
          + "day", e.getMessage());
    }
    workDay.setStartDate(LocalDateTime.of(2018, 10, 20, 10, 0));
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 10, 0), workDay.getStartDate());

    try {
      workDay.setEndDate(LocalDateTime.of(2018, 10, 19, 9, 0));
    } catch (IllegalArgumentException e) {
      Assert.assertEquals("Parameters for WorkDay should be applied only for one and the same "
          + "day", e.getMessage());
    }

    try {
      workDay.setEndDate(LocalDateTime.of(2018, 10, 21, 9, 0));
    } catch (IllegalArgumentException e) {
      Assert.assertEquals("Parameters for WorkDay should be applied only for one and the same "
          + "day", e.getMessage());
    }

    workDay.setEndDate(LocalDateTime.of(2018, 10, 20, 18, 0));
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 18, 0), workDay.getEndDate());

  }

}

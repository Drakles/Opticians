package pio;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import pio.visit.Visit;

public class VisitTest {

  @Test
  public void simpleVisitTest() {
    Visit visit = new Visit(LocalDateTime.of(2018, 10, 20, 10, 0),
        LocalDateTime.of(2018, 10, 20, 11, 0));
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 10, 0), visit.getStartDate());
    Assert.assertEquals(LocalDateTime.of(2018, 10, 20, 11, 0), visit.getEndDate());
  }

  @Test
  public void idTest(){
    Visit visit = new Visit(LocalDateTime.of(2018, 10, 20, 10, 0),
        LocalDateTime.of(2018, 10, 20, 11, 0));
    Visit secondVisit = new Visit(LocalDateTime.of(2018, 10, 20, 10, 0),
        LocalDateTime.of(2018, 10, 20, 11, 0));
    Assert.assertNotSame(visit,secondVisit);
  }

  @Test
  public void wrongDateTest() {
    try {
      new Visit(LocalDateTime.of(2018, 10, 20, 10, 0),
          LocalDateTime.of(2018, 10, 21, 11, 0));
    }catch (IllegalArgumentException e){
      Assert.assertEquals("Visit can be no longer than one day",e.getMessage());
    }
  }

  @Test
  public void wrongDateTest2() {
    try {
      new Visit(LocalDateTime.of(2018, 10, 20, 10, 0),
          LocalDateTime.of(2018, 10, 19, 11, 0));
    }catch (IllegalArgumentException e){
      Assert.assertEquals("Visit can be no longer than one day",e.getMessage());
    }
  }

}

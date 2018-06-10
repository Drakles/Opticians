package pio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import junit.framework.Assert;
import org.junit.Test;
import pio.person.Client;
import pio.visit.LeansValue;
import pio.visit.Visit;
import pio.visit.VisitErrorCodes;

public class ClientTest {

  @Test
  public void testClient() {
    Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10)
        , "95011023522");
    Assert.assertEquals(client.getName(), "Jan");
    Assert.assertEquals(client.getSurname(), "Kowalski");
    Assert.assertEquals(client.getBornDate().toString(), "1995-01-10");
    Assert.assertEquals(client.getPesel(), "95011023522");
  }

  @Test
  public void testAddVisitation() {
    Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10)
        , "95011023522");

    client.addVisit(
        new Visit(LocalDateTime.of(2018, 10, 20, 10, 0), LocalDateTime.of(2018, 10, 20, 11, 0)
            , new LeansValue(0.5f, 1.25f)));

    Assert.assertTrue(client.getVisits().size() == 1);
    Assert.assertTrue(client.getVisits().get(0).getLeansValue().getLeft() == 0.5f);
    Assert.assertTrue(client.getVisits().get(0).getLeansValue().getRight() == 1.25f);
    Assert.assertTrue(client.getVisits().get(0).getStartDate().equals(
        LocalDateTime.of(2018, 10, 20, 10, 0)));
  }

  @Test
  public void testClientId() {
    Client client1 = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");
    Client client2 = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");
    Assert.assertTrue(!client1.equals(client2));

  }

  @Test
  public void addVisit() {
    Client client = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");

    Visit visit = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 0), LocalDateTime.of(2018, 6, 5, 13, 0));
    Assert.assertEquals(VisitErrorCodes.VISIT_OK, client.addVisit(visit));

  }

  @Test
  public void visitsConflicts() {
    Client client = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");

    Visit visit = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 0), LocalDateTime.of(2018, 6, 5, 13, 0));
    Assert.assertEquals(VisitErrorCodes.VISIT_OK, client.addVisit(visit));

    Visit anotherVists = new Visit(LocalDateTime.of(2018, 6, 5, 12
        , 30), LocalDateTime.of(2018, 6, 5, 13, 30));

    Assert.assertEquals(VisitErrorCodes.CLIENT_HAVE_VISIT_AT_GIVEN_DATE,
        client.addVisit(anotherVists));

    Visit anotherVists2 = new Visit(LocalDateTime.of(2018, 6, 5, 11
        , 30), LocalDateTime.of(2018, 6, 5, 12, 30));

    Assert.assertEquals(VisitErrorCodes.CLIENT_HAVE_VISIT_AT_GIVEN_DATE,
        client.addVisit(anotherVists2));

    Visit anotherVistsOk = new Visit(LocalDateTime.of(2018, 6, 5, 13
        , 30), LocalDateTime.of(2018, 6, 5, 14, 30));

    Assert.assertEquals(VisitErrorCodes.VISIT_OK, client.addVisit(anotherVistsOk));

  }

}

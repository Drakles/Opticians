package pio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import junit.framework.Assert;
import junit.framework.TestCase;
import pio.person.Client;
import pio.visit.LeansValue;
import pio.visit.Visit;

public class ClientTest extends TestCase {

  public void testClient() {
    Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10)
        , "95011023522");
    Assert.assertEquals(client.getName(), "Jan");
    Assert.assertEquals(client.getSurname(), "Kowalski");
    Assert.assertEquals(client.getBornDate().toString(), "1995-01-10");
    Assert.assertEquals(client.getPesel(), "95011023522");
  }

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

  public void testClientId() {
    Client client1 = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");
    Client client2 = new Client("Jan", "Kowalski"
        , LocalDate.of(1995, 1, 10), "95011023522");
    Assert.assertTrue(!client1.equals(client2));

  }

}

package pio;

import pio.person.Client;
import pio.visit.LeansValue;
import pio.visit.Visit;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.time.LocalDate;

public class ClientTest extends TestCase {

    public void testClient() {
        Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger.valueOf(95011023522L));
        Assert.assertEquals(client.getName(), "Jan");
        Assert.assertEquals(client.getSurname(), "Kowalski");
        Assert.assertEquals(client.getBornDate().toString(), "1995-01-10");
        Assert.assertEquals(client.getPesel().longValue(), 95011023522L);
    }

    public void testAddVisitation() {
        Client client = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger.valueOf(95011023522L));

        client.addVisit(new Visit(LocalDate.of(2018, 10, 20), new LeansValue(0.5f, 1.25f)));

        Assert.assertTrue(client.getVisits().size() == 1);
        Assert.assertTrue(client.getVisits().get(0).getLeansValue().getLeft() == 0.5f);
        Assert.assertTrue(client.getVisits().get(0).getLeansValue().getRight() == 1.25f);
        Assert.assertTrue(client.getVisits().get(0).getDate().equals(LocalDate.of(2018, 10, 20)));
    }

    public void testClientId() {
        Client client1 = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger.valueOf(95011023522L));
        Client client2 = new Client("Jan", "Kowalski", LocalDate.of(1995, 1, 10), BigInteger.valueOf(95011023522L));
        Assert.assertTrue(!client1.equals(client2));

    }

}

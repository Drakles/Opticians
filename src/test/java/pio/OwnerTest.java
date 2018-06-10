package pio;

import org.junit.Assert;
import org.junit.Test;
import pio.person.Owner;

public class OwnerTest {

  @Test
  public void simpleOwnerTest() {
    Owner owner = new Owner("Agata", "Dymkiewicz");
    Assert.assertEquals(owner.getName(), "Agata");
    Assert.assertEquals(owner.getSurname(), "Dymkiewicz");
  }
}

package pio;

import pio.person.Owner;
import org.junit.Assert;
import org.junit.Test;

public class OwnerTest {
    @Test
    public void simpleOwnerTest(){
        Owner owner = new Owner("Agata","Dymkiewicz");
        Assert.assertEquals(owner.getName(),"Agata");
        Assert.assertEquals(owner.getSurname(),"Dymkiewicz");
    }
}

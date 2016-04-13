package hu.elte.progtech1.cwjkl1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import hu.elte.progtech1.cwjkl1.Homokjaro;

public class HomokjaroTest {
    final int water = 3;
    final String name = "Jani";
    Homokjaro homokjaro, jani;
    @Before
    public void setUp() throws Exception {
        homokjaro = new Homokjaro();
        jani = new Homokjaro(name, water);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getMaxWater() throws Exception {
        assertEquals(homokjaro.getMaxWater(), homokjaro.getWater());
        assertNotEquals(0, homokjaro.getMaxWater());
    }

    @Test
    public void napos() throws Exception {

    }

    @Test
    public void felhos() throws Exception {

    }

    @Test
    public void esos() throws Exception {

    }

}
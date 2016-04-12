package hu.elte.progtech1.cwjkl1;

import org.junit.Test;
import static org.junit.Assert.*;
import hu.elte.progtech1.cwjkl1.Homokjaro;

public class HomokjaroTest {
    final String name = "Jani";
    final int water = 3;
    @Test
    public void getMaxWater() throws Exception {
        Homokjaro homokjaro = new Homokjaro();
        assertTrue(homokjaro.isLiving());
        assertEquals(homokjaro.getMaxWater(), homokjaro.getWater());

        homokjaro.consumeWater(homokjaro.getMaxWater());
        assertEquals(0, homokjaro.getWater());
        assertFalse(homokjaro.isLiving());

        homokjaro.consumeWater(1);
        assertEquals(0, homokjaro.getWater());
        Homokjaro jani = new Homokjaro(name, water);
        assertEquals(name, jani.getName());
        assertEquals(water, jani.getWater());
        assertNotEquals(water, jani.getMaxWater());
        assertTrue(jani.isLiving());

        jani.consumeWater(jani.getMaxWater());
        assertFalse(jani.isLiving());
        assertNotEquals(water, jani.getWater());
        assertEquals(0, jani.getWater());

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
package hu.elte.progtech1.cwjkl1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static hu.elte.progtech1.cwjkl1.Leny.Faj.h;
import static org.junit.Assert.*;
import hu.elte.progtech1.cwjkl1.Homokjaro;
import hu.elte.progtech1.cwjkl1.Leny.Nap;

import java.util.Random;

public class HomokjaroTest {
    int water;
    final String name = "Jani";
    Homokjaro homokjaro, jani;
    int hadWater, hadDistance;
    boolean wasAlive;
    Random randomGenerator;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new Random();
        water = randomGenerator.nextInt(Homokjaro.maxWater);
        homokjaro = new Homokjaro();
        jani = new Homokjaro(name, water);
        hadWater = jani.getWater();
        hadDistance = jani.getDistance();
        wasAlive = jani.isLiving();
        assertTrue("A verseny kezdetekor élnie kéne", wasAlive);
    }

    @Test
    public void napos() throws Exception {
        int naposidx = Nap.n.getValue();

        jani.napos();
        assertEquals("Napos időben megfelelő mennyiségű vizet fogyaszt",
                (hadWater + Homokjaro.savedWater[naposidx] - Homokjaro.consumedWater[naposidx]),
                jani.getWater());

        if(jani.isLiving()) {
            assertEquals("Napos időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Homokjaro.moveDistance[naposidx]),
                    jani.getDistance());
        }

        for(int i = jani.getWater(); i >= 0; i-= Homokjaro.consumedWater[naposidx]) {
            jani.napos();
        }
        assertFalse("Ha elég sokáig masíroz napos időben szomjan kell haljon",
                jani.isLiving());
    }

    @Test
    public void felhos() throws Exception {
        int felhosidx = Nap.f.getValue();

        jani.felhos();

        assertEquals("Felhős időben megfelelő mennyiségű vizet fogyaszt",
                (hadWater + Homokjaro.savedWater[felhosidx] - Homokjaro.consumedWater[felhosidx]),
                jani.getWater());

        if(jani.isLiving()) {
            assertEquals("Felhős időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Homokjaro.moveDistance[felhosidx]),
                    jani.getDistance());
        }
    }

    @Test
    public void esos() throws Exception {
        int esosidx = Nap.e.getValue();

        jani.esos();
        int expWater = hadWater + Homokjaro.savedWater[esosidx] - Homokjaro.consumedWater[esosidx];
        assertEquals("Esős időben megfelelő mennyiségű vizet fogyaszt",
                (expWater > Homokjaro.maxWater ? Homokjaro.maxWater:expWater),
                jani.getWater());

        assertEquals("Esős időben az elvárásoknak megfelelően halad előre",
                (hadDistance + Homokjaro.moveDistance[esosidx]),
                jani.getDistance());

        for(int i = jani.getWater(); i <= jani.getMaxWater() + 1; i += Homokjaro.savedWater[esosidx]) {
            jani.esos();
        }
        assertEquals("ha elég sokat marad esőben egy idő után már nem tud több vizet elraktározni",
                jani.getMaxWater(),
                jani.getWater());
    }

}
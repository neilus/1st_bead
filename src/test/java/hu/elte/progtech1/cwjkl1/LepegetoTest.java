package hu.elte.progtech1.cwjkl1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

import hu.elte.progtech1.cwjkl1.Leny.Nap;

/**
 * Created by neilus on 4/14/16.
 */
public class LepegetoTest {
    int water;
    final String name = "Gipsz";
    Lepegeto jakab;
    int hadWater, hadDistance;
    boolean wasAlive;
    Random randomGenerator;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new Random();
        water = randomGenerator.nextInt(Lepegeto.maxWater);
        jakab = new Lepegeto(name, water);

        hadWater = jakab.getWater();
        hadDistance = jakab.getDistance();
        wasAlive = jakab.isLiving();
        assertTrue("A verseny kezdetekor élnie kéne", wasAlive);
    }

    @Test
    public void napos() throws Exception {
        int naposidx = Nap.n.getValue();

        jakab.napos();
        int expWater = hadWater + Lepegeto.savedWater[naposidx] - Lepegeto.consumedWater[naposidx];
        assertEquals("Napos időben megfelelő mennyiségű vizet fogyaszt",
                (expWater < 0 ? 0:expWater),
                jakab.getWater());

        if(jakab.isLiving()) {
            assertEquals("Napos időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Lepegeto.moveDistance[naposidx]),
                    jakab.getDistance());
        }

        for(int i = jakab.getWater(); i >= 0; i-= Lepegeto.consumedWater[naposidx]) {
            jakab.napos();
        }
        assertFalse("Ha elég sokáig masíroz napos időben szomjan kell haljon",
                jakab.isLiving());
    }

    @Test
    public void felhos() throws Exception {
        int felhosidx = Nap.f.getValue();

        jakab.felhos();
        int expWater = hadWater + Lepegeto.savedWater[felhosidx] - Lepegeto.consumedWater[felhosidx];
        assertEquals("Napos időben megfelelő mennyiségű vizet fogyaszt",
                (expWater < 0 ? 0:expWater),
                jakab.getWater());

        if(jakab.isLiving()) {
            assertEquals("Felhős időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Lepegeto.moveDistance[felhosidx]),
                    jakab.getDistance());
        }
    }

    @Test
    public void esos() throws Exception {
        int esosidx = Nap.e.getValue();

        jakab.esos();
        int expWater = hadWater + Lepegeto.savedWater[esosidx] - Lepegeto.consumedWater[esosidx];
        assertEquals("Esős időben megfelelő mennyiségű vizet fogyaszt",
                (expWater > Lepegeto.maxWater ? Lepegeto.maxWater:expWater),
                jakab.getWater());

        assertEquals("Esős időben az elvárásoknak megfelelően halad előre",
                (hadDistance + Lepegeto.moveDistance[esosidx]),
                jakab.getDistance());

        for(int i = jakab.getWater(); i <= jakab.getMaxWater() + 1; i += Lepegeto.savedWater[esosidx]) {
            jakab.esos();
        }
        assertEquals("ha elég sokat marad esőben egy idő után már nem tud több vizet elraktározni",
                jakab.getMaxWater(),
                jakab.getWater());
    }

}
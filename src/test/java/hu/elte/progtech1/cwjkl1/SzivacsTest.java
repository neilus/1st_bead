package hu.elte.progtech1.cwjkl1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by neilus on 4/14/16.
 */
public class SzivacsTest {
    int water;
    final String name = "Gipsz";
    Szivacs jakab;
    int hadWater, hadDistance;
    boolean wasAlive;
    Random randomGenerator;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new Random();
        water = randomGenerator.nextInt(Szivacs.maxWater);
        jakab = new Szivacs(name, water);

        hadWater = jakab.getWater();
        hadDistance = jakab.getDistance();
        wasAlive = jakab.isLiving();
        assertTrue("A verseny kezdetekor élnie kéne", wasAlive);
    }

    @Test
    public void napos() throws Exception {
        int naposidx = Leny.Nap.n.getValue();

        jakab.napos();
        int expWater = hadWater + Szivacs.savedWater[naposidx] - Szivacs.consumedWater[naposidx];
        assertEquals("Napos időben megfelelő mennyiségű vizet fogyaszt",
                (expWater < 0 ? 0:expWater),
                jakab.getWater());

        if(jakab.isLiving()) {
            assertEquals("Napos időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Szivacs.moveDistance[naposidx]),
                    jakab.getDistance());
        }

        for(int i = jakab.getWater(); i >= 0; i-= Szivacs.consumedWater[naposidx]) {
            jakab.napos();
        }
        assertFalse("Ha elég sokáig masíroz napos időben szomjan kell haljon",
                jakab.isLiving());
    }

    @Test
    public void felhos() throws Exception {
        int felhosidx = Leny.Nap.f.getValue();

        jakab.felhos();

        assertEquals("Felhős időben megfelelő mennyiségű vizet fogyaszt",
                (hadWater + Szivacs.savedWater[felhosidx] - Szivacs.consumedWater[felhosidx]),
                jakab.getWater());

        if(jakab.isLiving()) {
            assertEquals("Felhős időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + Szivacs.moveDistance[felhosidx]),
                    jakab.getDistance());
        }
    }

    @Test
    public void esos() throws Exception {
        int esosidx = Leny.Nap.e.getValue();

        jakab.esos();
        int expWater = hadWater + Szivacs.savedWater[esosidx] - Szivacs.consumedWater[esosidx];
        assertEquals("Esős időben megfelelő mennyiségű vizet fogyaszt",
                (expWater > Szivacs.maxWater ? Szivacs.maxWater:expWater),
                jakab.getWater());

        assertEquals("Esős időben az elvárásoknak megfelelően halad előre",
                (hadDistance + Szivacs.moveDistance[esosidx]),
                jakab.getDistance());

        for(int i = jakab.getWater(); i <= jakab.getMaxWater() + 1; i += Szivacs.savedWater[esosidx]) {
            jakab.esos();
        }
        assertEquals("ha elég sokat marad esőben egy idő után már nem tud több vizet elraktározni",
                jakab.getMaxWater(),
                jakab.getWater());
    }


}
package hu.elte.progtech1.cwjkl1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hu.elte.progtech1.cwjkl1.Leny.Nap;
import static org.junit.Assert.*;

/**
 * Created by neilus on 4/13/16.
 */
public class LenyTest {
    final String testName = "Teszt Elek";
    final int testWater = 3;
    final int testMaxWater = 21;
    TestElek tesztLeny;
    final String[] idojaras = {"Napos", "Felhős", "Esős"};

    public class TestElek extends Leny {

        @Override
        public int getSavingByDay(int idx) {
            return 0;
        }

        @Override
        public int getConsumptionByDay(int idx) {
            return 0;
        }

        @Override
        public int getDistanceByDay(int idx) {
            return 0;
        }

        /**
         * Constructs a Leny abstract object
         *
         * @param name  a leny neve
         * @param water mennyi vizzel kezdi a versenyt
         */
        public TestElek(String name, int water) {
            super(name, water);
        }


        @Override
        int getMaxWater() {
            return testMaxWater;
        }

        @Override
        public Leny napos() {
            return this;
        }

        @Override
        public Leny felhos() {
            return this;
        }

        @Override
        public Leny esos() {
            return this;
        }
    }

    @Test
    public void moveTest() throws Exception {
        final int testD = 3;
        assertEquals("After creation of a new object",
                0,
                tesztLeny.getDistance());
        assertEquals("After it moves " + testD,
                testD,
                tesztLeny.move(testD).getDistance());
        assertEquals("After it moves " + testD + " again",
                (tesztLeny.getDistance() + testD),
                tesztLeny.move(testD).getDistance());
    }

    @Test
    public void saveWaterTest() throws Exception {
        final int amount = 3;
        assertEquals("The unmodified water amount",
                testWater,
                tesztLeny.getWater());
        assertEquals("After it saves " + amount + " amount of water",
                (testWater + 3),
                tesztLeny.saveWater(3).getWater());
    }

    @Test
    public void consumeWaterTest() throws Exception {
        final int amount = 3;
        assertEquals("The unmodified water amount",
                testWater,
                tesztLeny.getWater());
        assertEquals("After it consumes " + amount + " amount of water",
                (tesztLeny.getWater() - amount),
                tesztLeny.consumeWater(amount).getWater());
    }

    @Test
    public void dieTest() throws Exception {
        assertTrue("After creation it should live", tesztLeny.isLiving());
        assertFalse("After it dies it should be dead", tesztLeny.die().isLiving());
    }

    @Before
    public void setUp() throws Exception {
        tesztLeny = new TestElek(testName, testWater);

    }

    public int elegetIszikEsHalad(Leny jakab, Nap milyen) {
        int idx = milyen.getValue();

        int hadWater = jakab.getWater();
        int hadDistance = jakab.getDistance();

        assertTrue("A verseny kezdetekor élnie kéne", jakab.isLiving());

        switch (idx) {
            case 0:
                jakab.napos();
                break;
            case 1:
                jakab.felhos();
                break;
            case 2:
                jakab.esos();
                break;
            default:
                assertTrue("Csak Napos, Felhős vagy esős napok a megengedettek",
                        (idx < 3) && (idx >= 0));
        }
        int expWater = hadWater + jakab.getSavingByDay(idx) - jakab.getConsumptionByDay(idx);
        assertEquals(idojaras[idx] + " időben megfelelő mennyiségű vizet fogyaszt",
                (expWater < 0 ? 0:expWater),
                jakab.getWater());

        if(jakab.isLiving()) {
            assertEquals(idojaras[idx] + " időben az elvárásoknak megfelelően halad előre",
                    (hadDistance + jakab.getDistanceByDay(idx)),
                    jakab.getDistance());
        }

        return idx;
    }
}
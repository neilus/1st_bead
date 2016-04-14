package hu.elte.progtech1.cwjkl1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import hu.elte.progtech1.cwjkl1.Leny.Nap;

import java.util.Random;

public class HomokjaroTest {
    int water;
    final String name = "Gipsz";
    Homokjaro jakab;
    int hadWater, hadDistance;
    boolean wasAlive;
    Random randomGenerator;
    LenyTest jakabTeszt;

    @Before
    public void setUp() throws Exception {
        randomGenerator = new Random();
        water = randomGenerator.nextInt(Homokjaro.maxWater);
        jakab = new Homokjaro(name, water);
        jakabTeszt = new LenyTest();
    }

    @Test
    public void napos() throws Exception {
        int naposidx = jakabTeszt.elegetIszikEsHalad(jakab, Nap.n);

        for(int i = jakab.getWater(); i >= 0; i-= Homokjaro.consumedWater[naposidx]) {
            jakab.napos();
        }
        assertFalse("Ha elég sokáig masíroz napos időben szomjan kell haljon",
                jakab.isLiving());
    }

    @Test
    public void felhos() throws Exception {
        int felhosidx = jakabTeszt.elegetIszikEsHalad(jakab, Nap.f);
    }

    @Test
    public void esos() throws Exception {
        int esosidx = jakabTeszt.elegetIszikEsHalad(jakab, Nap.e);
        for(int i = jakab.getWater(); i <= jakab.getMaxWater() + 1; i += Homokjaro.savedWater[esosidx]) {
            jakab.esos();
        }
        assertEquals("ha elég sokat marad esőben egy idő után már nem tud több vizet elraktározni",
                jakab.getMaxWater(),
                jakab.getWater());
    }

}
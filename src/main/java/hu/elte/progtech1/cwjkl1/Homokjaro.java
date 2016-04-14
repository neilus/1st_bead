package hu.elte.progtech1.cwjkl1;

import static hu.elte.progtech1.cwjkl1.Leny.Faj.l;

public class Homokjaro extends Leny {
    protected static final int maxWater = 8;

    protected static int[] savedWater =     {0, 0, 3};
    protected static int[] consumedWater =  {1, 0, 0};
    protected static int[] moveDistance =   {3, 1, 0};

    Homokjaro(){
        super("Homokjaro", 8);
    }
    public Homokjaro(String name, int water){
        super(name, water);
    }

    /**
     * @return the maximum amount of water the creature can save up
     */
    @Override
    int getMaxWater() {
        return this.maxWater;
    }

    /**
     * Ths method has to be implemented in the child class.
     * It has to move the creature towards in sunny conditions.
     * <ol>
     * <li>It has to check wether the creature is alive or not </li>
     * <li>It has to decrement the amount of water needed</li>
     * <li>It has to increase the distance the creature moved so far</li>
     * </ol>
     *
     * @return this object instance after application
     */
    @Override
    public Leny napos() {
        int napos = Nap.n.getValue();
        this.saveWater(savedWater[napos])
                .consumeWater(consumedWater[napos])
                .move(moveDistance[napos]);

        return this;
    }

    /**
     * Ths method has to be implemented in the child class.
     * It has to move the creature towards in cloudy conditions.
     * <ol>
     * <li>It has to check wether the creature is alive or not </li>
     * <li>It has to decrement the amount of water needed</li>
     * <li>It has to increase the distance the creature moved so far</li>
     * </ol>
     *
     * @return this object instance after application
     */
    @Override
    public Leny felhos() {
        int felhos = Nap.f.getValue();
        this.saveWater(savedWater[felhos])
                .consumeWater(consumedWater[felhos])
                .move(moveDistance[felhos]);

        return this;
    }

    /**
     * Ths method has to be implemented in the child class.
     * It has to move the creature towards in rainy conditions.
     * <ol>
     * <li>It has to check wether the creature is alive or not </li>
     * <li>It has to decrement the amount of water needed</li>
     * <li>It has to increase the distance the creature moved so far</li>
     * </ol>
     *
     * @return this object instance after application
     */
    @Override
    public Leny esos() {
        int esos = Nap.e.getValue();
        this.saveWater(savedWater[esos])
                .consumeWater(consumedWater[esos])
                .move(moveDistance[esos]);

        return null;
    }

}
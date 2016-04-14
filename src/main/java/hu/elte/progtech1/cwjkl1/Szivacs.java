package hu.elte.progtech1.cwjkl1;

public class Szivacs extends Leny {
    protected static final int maxWater = 20;

    protected static int[] savedWater =     {0, 0, 6};
    protected static int[] consumedWater =  {4, 1, 0};
    protected static int[] moveDistance =   {0, 1, 3};

    Szivacs() {
        super("Szivacs", 30);
    }

    public Szivacs(String name, int water){
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
        this.saveWater(0).consumeWater(4).move(0);

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
        this.saveWater(0).consumeWater(1).move(1);

        return null;
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
        this.saveWater(6).consumeWater(0).move(3);

        return null;
    }
}

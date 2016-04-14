package hu.elte.progtech1.cwjkl1;

public class Lepegeto extends Leny {
    protected static final int maxWater = 12;

    protected static int[] savedWater =     {0, 0, 3};
    protected static int[] consumedWater =  {2, 1, 0};
    protected static int[] moveDistance =   {1, 2, 1};

    Lepegeto(){
        super("Lepegeto", 20);
    }


    @Override
    public int getSavingByDay(int idx) {
        return savedWater[idx];
    }

    @Override
    public int getConsumptionByDay(int idx) {
        return consumedWater[idx];
    }

    @Override
    public int getDistanceByDay(int idx) {
        return moveDistance[idx];
    }

    public Lepegeto(String name, int water) {
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
    public @Override
    Leny napos() {
        this.saveWater(0).consumeWater(2).move(1);

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
        this.saveWater(0).consumeWater(1).move(2);

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
        this.saveWater(3).consumeWater(0).move(1);

        return this;
    }
}

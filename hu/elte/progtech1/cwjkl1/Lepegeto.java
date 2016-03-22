package hu.elte.progtech1.cwjkl1;

/**
 * Created by enorsan on 3/19/16.
 */
public class Lepegeto extends Leny{
    private final int maxWater = 12;
    Lepegeto(){
        super("Lepegeto", 20);
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
    @Override
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
    Leny felhos() {
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
    Leny esos() {
        this.saveWater(3).consumeWater(0).move(1);

        return this;
    }
}

package hu.elte.progtech1.cwjkl1;


/**
 * Lény absztrakt osztály
 */
public abstract class Leny {
    private boolean is_living;
    private String name;
    private int distance;
    private int water;

    /**
     * Moves the living creature forward with given distance
     * @param amount the amount to move forward in int
     * @return this creature
     */
    protected Leny move(int amount) {
        if(isLiving())
            this.distance += amount;

        return this;
    }

    /**
     * Makes the creature save/drink water with the given amount
     * @param amount the amount of water to be saved
     * @return this creature
     */
    protected Leny saveWater(int amount) {
        water += amount;
        if (water > getMaxWater())
            water = getMaxWater();

        return this;
    }

    /**
     * Makes the creature consume/waste the given amount of water.
     * If the creature does not have enough water it will die!
     *
     * @param amount the amounnt of water to consume
     * @return this creature
     */
    protected Leny consumeWater(int amount) {
        water -= amount;
        if(getWater() <= 0)
            die();

        return this;
    }

    /**
     * Makes this creature die
     * @return this <strong>dead</strong> creature
     */
    protected Leny die(){
        is_living = false;

        return this;
    }
    /**
     * Constructs a Leny abstract object
     *
     * @param name
     * @param water
     */
    public Leny(String name, int water){
        this.name = name;
        this.water = (water > getMaxWater())? getMaxWater():water;
        this.is_living = true;
        this.distance = 0;
    }

    /**
     * @return the maximum amount of water the creature can save up
     */
    abstract int getMaxWater();

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
    abstract Leny napos();

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
    abstract Leny felhos();

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
    abstract Leny esos();

    /**
     * Returns the amount of water the creature has
     *
     * @return
     */
    public int getWater() {
        return water;
    }

    /**
     * Returns the name of the creature
     * @return
     */
    public String getName() { return name; }

    /**
     * Returns the distance the creature has already taken
     *
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Returns wether the creature is alive or not
     *
     * @return
     */
    public boolean isLiving() {

        return is_living;
    }

    /**
     * pretty JSON-szeru alakban stringesiti az objektumot
     *
     * @return
     */
    @Override
    public String toString(){
        return "{" +
                "\n\tname: \"" + this.name + "\"" +
                ",\n\twater: " + this.water +
                ",\n\tdistance: " + this.distance +
                ",\n\tisLiving: "+ this.is_living +
                "\n}\n";
    }
}
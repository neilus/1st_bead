package hu.elte.progtech1.cwjkl1;


/**
 * Lény absztrakt osztály
 */
public abstract class Leny {
    private boolean isLiving;
    private String name;
    private int distance;
    private int water;

    /**
     *  Constructs a Leny abstract object
     * @param name
     * @param water
     */
    public Leny(String name, int water){
        this.name = name;
        this.water = water;
        this.isLiving = true;
        this.distance = 0;
    }
    abstract Leny napos();
    abstract Leny felhos();
    abstract Leny esos();

    public int getWater() {
        return water;
    }

    public String getName() {

        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean getIsLiving() {

        return isLiving;
    }

    protected void rush(int water, int distance){

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
                ",\n\twater: " + this.water +
                ",\n\tisLiving: "+ this.isLiving +
                "\n}\n";
    }
}
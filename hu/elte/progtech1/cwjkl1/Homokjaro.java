package hu.elte.progtech1.cwjkl1;

public class Homokjaro extends Leny {

    Homokjaro(){
        super("Homokjaro", 8);
    }
    public Homokjaro(String name, int water){
        super(name, water);
    }

    @Override
    Leny napos() {
        return this;
    }

    @Override
    Leny felhos() {
        return this;
    }

    @Override
    Leny esos() {
        return this;
    }
}
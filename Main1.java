import hu.elte.progtech1.cwjkl1.Homokjaro;

public class Main1 {
    public static void main(String[] args){
        Homokjaro bela = new Homokjaro(new String("Bela"), 12);
        System.out.println(bela);

        bela.napos();
        System.out.println(bela);

        bela.felhos();
        System.out.println(bela);

        bela.esos();
        System.out.println(bela);

        while (bela.isLiving()) {
            bela.napos();
            System.out.println(bela);
        }
    }
}



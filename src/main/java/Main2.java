import hu.elte.progtech1.cwjkl1.Homokjaro;
import hu.elte.progtech1.cwjkl1.Leny;
import hu.elte.progtech1.cwjkl1.Lepegeto;
import hu.elte.progtech1.cwjkl1.Szivacs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

    /**
     * letrehoz egy megfelelo tipusu versenyzot
     * @param sor az input egy String sorat, amely a versenyzo parametereit tartalmazza
     * @return Leny, amely a String alapjan megfelelo gyermek osztaly
     */
    private static Leny versenyzo(String sor) {
        StringTokenizer st = new StringTokenizer(sor);
        //FixMe: nem ellenorzom az input sort!
        String name = st.nextToken();
        Leny.Faj faj = Leny.Faj.valueOf(st.nextToken());
        int viz = Integer.parseInt(st.nextToken());

        switch(faj){
            case h:
                return new Homokjaro(name, viz);
            case s:
                return new Szivacs(name, viz);
            case l:
                return new Lepegeto(name, viz);
            default:
                return null;
        }
    }


    public static void main(String[] args) throws IOException {
        //Done: input inicializalasa
//        Scanner scan = new Scanner(System.in);
        if (args.length != 1) {
            System.err.println("ERROR: pontosan egy paramétert várok:");
            System.err.println("ERROR: az input fájl nevét:");
            System.err.println("ERROR: pl:");
            System.err.println("ERROR: $ java Main2 input1.txt");

            System.exit(1);
        }

        Scanner scan = new Scanner(new File(args[0]));
        //Done: 1. sor a az indulo lenyek szama
        int lenyekSzama = Integer.parseInt(scan.nextLine());

        //Done: a kovetkezo n sor az indulo lenyek
        List<Leny> versenyzok = new ArrayList<Leny>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(Leny.header());
                for (Leny i:this) {
                    sb.append("\n");
                    sb.append(i.toString());
                }
                sb.append("\n");
                sb.append(Leny.footer());
                return sb.toString();
            }
        };

        for(int i = 0; i < lenyekSzama; i++){
            versenyzok.add(versenyzo(scan.nextLine()));
        }

        System.out.println(versenyzok);

        /*
        Done: az utolso sorban a verseny napjai szerepelnek karaktersorozatban:
            n: napos,
            f: felhos,
            e: esos
         */
        String napok = scan.nextLine();
        for(int i=0; i < napok.length(); ){
            Leny.Nap nap = Leny.Nap.valueOf(napok.substring(i, ++i));
            switch(nap){
                case n:
                    versenyzok.forEach(Leny::napos);
                    break;
                case f:
                    versenyzok.forEach(Leny::felhos);
                    break;
                case e:
                    versenyzok.forEach(Leny::esos);
                    break;
            }
            System.out.println("Az allas a " + i + " napon:");
            System.out.println(versenyzok);
        }

        // ToDo: hatarozzuk meg es irjuk ki a nyertes nevet
        int max = 0;
        for(int i = 1; i < versenyzok.size(); i++){
            if ( versenyzok.get(i).getDistance() > versenyzok.get(max).getDistance() ) {
                // ha meg el is akkor o vezet...
                max = versenyzok.get(i).isLiving() ? i : max;
            }

        }

        if (versenyzok.get(max).isLiving()) {
            System.out.print("A nyertes versenyzo neve: ");
            System.out.println(versenyzok.get(max).getName());
        } else {
            System.out.println("sajnos minden versenyzo meghalt. ;(");
        }
    }
}

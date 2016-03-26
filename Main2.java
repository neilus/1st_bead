import hu.elte.progtech1.cwjkl1.Homokjaro;
import hu.elte.progtech1.cwjkl1.Leny;
import hu.elte.progtech1.cwjkl1.Lepegeto;
import hu.elte.progtech1.cwjkl1.Szivacs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
    private enum Faj { h, s, l};
    private enum Nap {n, f, e};
    /**
     * letrehoz egy megfelelo tipusu versenyzot
     * @param sor az input egy String sorat, amely a versenyzo parametereit tartalmazza
     * @return Leny, amely a String alapjan megfelelo gyermek osztaly
     */
    public static Leny versenyzo(String sor) {
        StringTokenizer st = new StringTokenizer(sor);
        //FixMe: nem ellenorzom az input sort!
        String name = st.nextToken();
        Faj faj = Faj.valueOf(st.nextToken());
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
        Scanner scan = new Scanner(System.in);

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
        ToDo: az utolso sorban a verseny napjai szerepelnek karaktersorozatban:
            n: napos,
            f: felhos,
            e: esos
         */
        String napok = scan.nextLine();
        for(int i=0; i < napok.length(); ){
            Nap nap = Nap.valueOf(napok.substring(i, ++i));
            switch(nap){
                case n:
                    for(Leny versenyzo:versenyzok){
                        versenyzo.napos();
                    }
                    break;
                case f:
                    for(Leny versenyzo:versenyzok){
                        versenyzo.felhos();
                    }
                    break;
                case e:
                    for(Leny versenyzo:versenyzok){
                        versenyzo.esos();
                    }
                    break;
            }
            System.out.println("Az allas a " + i + " napon:");
            System.out.println(versenyzok);
        }
    }
}

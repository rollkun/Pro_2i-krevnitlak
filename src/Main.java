import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tlak tlak = new Tlak();

        // načtu jméno
        System.out.print("Zadej jméno osoby: ");
        String jmeno = sc.next();
        tlak.vypisUvod(jmeno);

        // inicializace všech potřebných věcí globálně
        int platnaMereni = 0;
        int pocetChyb = 0;
        int soucetHorni = 0;
        int nejvyssiHorni = 0;

        // chci 3 platný měření
        while (platnaMereni < 3) {
            System.out.print("Zadej horní tlak: ");
            int horni = tlak.nactiHodnotu();

            System.out.print("Zadej dolní tlak: ");
            int dolni = tlak.nactiHodnotu();

            // tady kontroluju platnost měření
            if (tlak.jePlatne(horni, dolni)) {
                platnaMereni++;
                soucetHorni += horni;

                // tady určuju nejvyšší horní tlak
                // určuju ho tak přes while cyklus, že v něm vezmu hodnotu
                // jedné horní hodnoty, a ptám se, jestli je vyšší než nejvyšší (0, viz. int nejvyssiHorni = 0)
                // pokud je vyšší, čili pokud následující if-statement je pravdivej,
                // do hodnoty nejvyssiHorni se zapíše nejvyšší tlak.
                // pokud ten if pravdivej není, tak to prostě pokračuje dál.
                // takhle to loopne přes všechny hodnoty.
                if (horni > nejvyssiHorni) {
                    nejvyssiHorni = horni;
                }
            } else {
                // neplatné měření
                System.out.println("Neplatné měření");
                pocetChyb++;
            }
        }

        // průměr má docela dost velkou šanci toho,
        // že to bude desetinný číslo, takže vycastím int do double:
        double prumerHorni = (double) soucetHorni / 3;
        // ....................^ cast
        // to znamená, že přeměním něco, co dřív bylo int, na double
        // viz. https://www.w3schools.com/Java/java_type_casting.asp

        // závěrečný souhrn
        tlak.vypisSouhrn(pocetChyb, prumerHorni, nejvyssiHorni);
    }
}
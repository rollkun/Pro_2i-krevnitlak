import java.util.Scanner;

public class Tlak {
    Scanner sc = new Scanner(System.in);

    public void vypisUvod(String jmeno) {
        System.out.println("Ahoj, " + jmeno);
    }

    public int nactiHodnotu() {
        return sc.nextInt();
    }

    public boolean jePlatne(int horni, int dolni) {
        return horni > 0 && dolni > 0 && horni > dolni;
    }

    public void vypisSouhrn(int chyby, double prumer, int nejvyssi) {
        System.out.println("\nPočet neplatných měření: " + chyby);
        System.out.println("Průměr horních tlaků: " + prumer);
        System.out.println("Nejvyšší horní tlak: " + nejvyssi);
    }
}
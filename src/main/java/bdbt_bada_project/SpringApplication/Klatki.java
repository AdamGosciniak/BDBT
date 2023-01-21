package bdbt_bada_project.SpringApplication;

public class Klatki {

    private int nr_klatki;
    private int powierzchnia;
    private int pojemnosc;
    private String rodzaj_zwierzat;

    public Klatki(int nr_klatki, int powierzchnia, int pojemnosc, String rodzaj_zwierzat) {
        this.nr_klatki = nr_klatki;
        this.powierzchnia = powierzchnia;
        this.pojemnosc = pojemnosc;
        this.rodzaj_zwierzat = rodzaj_zwierzat;
    }

    public int getNr_klatki() {
        return nr_klatki;
    }

    public void setNr_klatki(int nr_klatki) {
        this.nr_klatki = nr_klatki;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }
    public String getRodzaj_zwierzat() {
        return rodzaj_zwierzat;
    }

    public void setRodzaj_zwierzat(String rodzaj_zwierzat) {
        this.rodzaj_zwierzat = rodzaj_zwierzat;
    }
    @Override
    public String toString() {
        return "Klatki{" +
                "nr_klatki=" + nr_klatki +
                ", powierzchnia=" + powierzchnia +
                ", pojemnosc=" + pojemnosc +
                ", rodzaj_zwierzat='" + rodzaj_zwierzat + '\'' +
                '}';
    }

}

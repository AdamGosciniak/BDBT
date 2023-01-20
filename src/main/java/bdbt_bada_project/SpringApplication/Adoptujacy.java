package bdbt_bada_project.SpringApplication;

public class Adoptujacy {

    private int nr_adoptujacego;
    private String imie;
    private String nazwisko;
    private int pesel;
    private String adres;
    private int nr_telefonu;
    private String email;

    public Adoptujacy(int nr_adoptujacego, String imie, String nazwisko, String adres, int pesel, int nr_telefonu, String email) {
        this.nr_adoptujacego = nr_adoptujacego;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
    }

    public int getNr_adoptujacego() {
        return nr_adoptujacego;
    }
    public void setNr_adoptujacego(int nr_adoptujacego) {
        this.nr_adoptujacego = nr_adoptujacego;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    public int getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Adoptujący{" +
                "Nr adoptującego=" + nr_adoptujacego +
                ", Imię='" + imie + '\'' +
                ", Nazwisko='" + nazwisko + '\'' +
                ", Pesel=" + pesel + '\'' +
                ", Adres=" + adres + '\'' +
                ", Nr telegonu=" + nr_telefonu + '\'' +
                ", Email=" + email + '\'' +
                '}';
    }


}
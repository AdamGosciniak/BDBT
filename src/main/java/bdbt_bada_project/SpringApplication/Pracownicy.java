package bdbt_bada_project.SpringApplication;

public class Pracownicy {

    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private int pesel;
    private String plec;
    private String email;
    private int nr_telefonu;
    private int nr_konta;
    private String data_zatrudnienia;
    private int nr_adresu;

    public Pracownicy(int nr_pracownika, String imie, String nazwisko, String data_urodzenia, int pesel, String plec, String email, int nr_telefonu, int nr_konta, String data_zatrudnienia, int nr_adresu) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_konta = nr_konta;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_adresu = nr_adresu;

    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }
    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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
    public String getData_urodzenia() {
        return data_urodzenia;
    }
    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }
    public int getPesel() {
        return pesel;
    }
    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
    public String getPlec() {
        return plec;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNr_telefonu() {
        return nr_telefonu;
    }
    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }
    public int getNr_konta() {
        return nr_konta;
    }
    public void setNr_konta(int nr_konta) {
        this.nr_konta = nr_konta;
    }
    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }
    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }
    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", Nr_adresu=" + nr_adresu +
                '}';
    }


}
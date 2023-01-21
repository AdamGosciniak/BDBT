package bdbt_bada_project.SpringApplication;

import java.sql.Date;

public class Zwierzeta {

    private int nr_zwierzecia;
    private String gatunek;
    private String rasa;
    private String rodzaj_karmy;
    private String imie;
    private Date data_przyjecia;
    private int wiek;
    private int waga;
    private Date data_kastracji;



    public Zwierzeta (int nr_zwierzecia, String gatunek, String rasa, String rodzaj_karmy, String imie, Date data_przyjecia, int wiek, int waga, Date data_kastracji) {
        this.nr_zwierzecia = nr_zwierzecia;
        this.gatunek = gatunek;
        this.rodzaj_karmy = rodzaj_karmy;
        this.imie = imie;
        this.data_przyjecia = data_przyjecia;
        this.wiek = wiek;
        this.data_kastracji = data_kastracji;

    }

    public int getNr_zwierzecia() {
        return nr_zwierzecia;
    }
    public void setNr_zwierzecia(int nr_zwierzecia) {
        this.nr_zwierzecia = nr_zwierzecia;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getGatunek() {
        return gatunek;
    }
    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }
    public String getRasa() {
        return rasa;
    }
    public void setRasa(String rasa) {
        this.rasa = rasa;
    }
    public String getRodzaj_karmy() {
        return rodzaj_karmy;
    }
    public void setRodzaj_karmy(String rodzaj_karmy) {
        this.rodzaj_karmy = rodzaj_karmy;
    }
    public Date getData_przyjecia() {
        return data_przyjecia;
    }
    public void setData_przyjecia(Date data_przyjecia) {
        this.data_przyjecia = data_przyjecia;
    }
    public int getWiek() {
        return wiek;
    }
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
    public int getWaga() {
        return waga;
    }
    public void setWaga(int waga) {
        this.waga = waga;
    }
    public Date getData_kastracji() {
        return data_kastracji;
    }
    public void setData_kastracji(Date data_kastracji) {
        this.data_kastracji = data_kastracji;
    }


    @Override
    public String toString() {
        return "Zwierzeta{" +
                "Nr_zwierzecia=" + nr_zwierzecia +
                ", Gatunek='" + gatunek + '\'' +
                ", Rasa='" + rasa + '\'' +
                ", Rodzaj_karmy='" + rodzaj_karmy + '\'' +
                ", Imie='" + imie + '\'' +
                ", Data_przyjęcia='" + data_przyjecia + '\'' +
                ", Wiek='" + wiek + '\'' +
                ", Waga='" + waga + '\'' +
                ", Data_kastracji='" + data_kastracji + '\'' +
                '}';
    }
}

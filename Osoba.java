public class Osoba extends Wpis {
    private String imie;
    private String nazwisko;
    private String adres;
    private NrTelefoniczny nrTelefonu;

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTelefonu){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public NrTelefoniczny getNrTelefonu() {
        return nrTelefonu;
    }


    public String opis() {
        return "Imie: " + imie + " Nazwisko: " + nazwisko + " Adres: " + adres + " Numer Telefonu: " + nrTelefonu;
    }
}

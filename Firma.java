public class Firma extends Wpis {
    private String nazwa;
    private String adres;
    private NrTelefoniczny nrTelefonu;

    public Firma(String nazwa, String adres, NrTelefoniczny nrTelefonu){
        this.nazwa = nazwa;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public NrTelefoniczny getNrTelefonu() {
        return nrTelefonu;
    }

    public String opis() {
        return "Nazwa: " + nazwa + " Adres: " + adres + " Numer Telefonu: " + nrTelefonu;
    }
}

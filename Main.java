import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
    // Creating Osoby, Firmy, telefon //
    NrTelefoniczny telefon1 = new NrTelefoniczny(+40,798210382);
    NrTelefoniczny telefon2 = new NrTelefoniczny(+10,487352018);
    NrTelefoniczny telefon3 = new NrTelefoniczny(+38,536203645);
    NrTelefoniczny telefon4 = new NrTelefoniczny(+72,293745102);
    NrTelefoniczny telefonFirmowy1 = new NrTelefoniczny(+52,563019237);
    NrTelefoniczny telefonFirmowy2 = new NrTelefoniczny(+86,127362510);
    NrTelefoniczny telefonFirmowy3 = new NrTelefoniczny(+93,302678127);
    NrTelefoniczny telefonFirmowy4 = new NrTelefoniczny(+28,392652921);
	Osoba osoba1 = new Osoba("Sebastian", "Bułecki", "Ujazdowo 13",telefon1);
	Osoba osoba2 = new Osoba("Tateusz", "Bananowski", "Borsukowo 26",telefon2);
	Osoba osoba3 = new Osoba("Michał", "Wałowski", "Mazowiecko 57",telefon3);
	Osoba osoba4 = new Osoba("Adrian", "Piekarski", "Konewkowo 69",telefon4);
	Firma firma1 = new Firma("Retro", "Nadjazdowo 17", telefonFirmowy1);
	Firma firma2 = new Firma("Pieski", "Sarnin 29", telefonFirmowy2);
	Firma firma3 = new Firma("Czołgi", "Rawsko 1", telefonFirmowy3);
	Firma firma4 = new Firma("Programy", "Dziabkowo 2137", telefonFirmowy4);

	// Creating TreeMap //
        TreeMap<NrTelefoniczny, Wpis>  treeMap = new TreeMap<NrTelefoniczny, Wpis>();     // First field (NrTelefoniczny) is key, by which we are sorting
        treeMap.put(osoba1.getNrTelefonu(), osoba1 );
        treeMap.put(osoba2.getNrTelefonu(), osoba2 );
        treeMap.put(osoba3.getNrTelefonu(), osoba3 );
        treeMap.put(osoba4.getNrTelefonu(), osoba4 );
        treeMap.put(firma1.getNrTelefonu(), firma1 );
        treeMap.put(firma2.getNrTelefonu(), firma2 );
        treeMap.put(firma3.getNrTelefonu(), firma3 );
        treeMap.put(firma4.getNrTelefonu(), firma4 );

    // Getting a set of entries
        Set set = treeMap.entrySet();
    // Getting an iterator
        Iterator iterator = set.iterator();

        for (Map.Entry<NrTelefoniczny, Wpis> entry : treeMap.entrySet()){
            NrTelefoniczny key = entry.getKey();
            Wpis value = entry.getValue();

            System.out.println(key.getNrKierunkowy() + " " + key.getNrTelefonu() +  " => " + value.opis());

        }

    }
}

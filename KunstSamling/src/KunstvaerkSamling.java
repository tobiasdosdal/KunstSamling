import java.util.ArrayList;

public class KunstvaerkSamling
{
    private ArrayList<Kunstvaerk> kunstvaerker;

    public KunstvaerkSamling() {
        kunstvaerker = new ArrayList<>();
    }

    public void add(Kunstvaerk kunstvaerk) {
        kunstvaerker.add(kunstvaerk);
    }

    // Method a: Find songs with multiple composers
    public void findSangeMedFlereKomponister() {
        for (Kunstvaerk k : kunstvaerker) {
            if (k instanceof Komposition && k.getAntalOphavsmænd() > 1) {
                System.out.println(k.getTitel());
            }
        }
    }


    public void findSangeMedEnKomponist() {
        for (int i = 0; i < kunstvaerker.size(); i++) {

            Kunstvaerk k = kunstvaerker.get(i);
            if (k instanceof Komposition && k.getAntalOphavsmænd() == 1) {
                System.out.println(k.getTitel());
            }
        }
    }


    public void findMalerierPaaMuseum(String museumNavn) {
        for (int i = 0; i < kunstvaerker.size(); i++) {
            Kunstvaerk kunstvaerk = kunstvaerker.get(i);

            // Check if it's a painting
            if (kunstvaerk instanceof Maleri) {
                Maleri maleri = (Maleri) kunstvaerk;
                String malerietsMuseum = maleri.getMuseum().getNavn();

                // Check if it's in the specified museum
                if (malerietsMuseum.equals(museumNavn)) {
                    System.out.println(maleri.getTitel());
                }
            }
        }
    }


    public void udskrivKunstvaerker(){
        for (int i = 0; i < kunstvaerker.size(); i++) {
            System.out.println( "Titel: "+ kunstvaerker.get(i).getTitel() +
                                " Ophavsmænd: " + kunstvaerker.get(i).getAntalOphavsmænd() +
                                " Årstal: " + kunstvaerker.get(i).getAar() +
                                " Person: " + kunstvaerker.get(i).getPersonNavn());
        }
    }

    // Method c: Calculate total pages read
    public void beregnAntalLaesteSider() {
        int totalSider = 0;
        for (Kunstvaerk k : kunstvaerker) {
            if (k instanceof Bog b) {
                totalSider += b.getAntalSider();
            }
        }
        System.out.println(totalSider);
    }

    public void skrivBogNavn() {
        String bogNavn = "";
        for (Kunstvaerk k : kunstvaerker) {
            if (k instanceof Bog b) {
                bogNavn = b.getTitel();
                System.out.println(bogNavn);

            }
        }
    }
}
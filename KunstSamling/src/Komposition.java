public class Komposition extends Kunstvaerk {
    protected String genre;
    protected int spilletid;

    public Komposition(String titel, int aar, String genre, int spilletid) {
        super(titel, aar);
        this.genre = genre;
        this.spilletid = spilletid;
    }

    public String getGenre() {
        return genre;
    }

    public int getSpilletid() {
        return spilletid;
    }
}
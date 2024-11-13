class Bog extends Kunstvaerk {
    private String genre;
    private int antalSider;

    public Bog(String titel, int aar, String genre, int antalSider) {
        super(titel, aar);
        this.genre = genre;
        this.antalSider = antalSider;
    }

    public int getAntalSider() {
        return antalSider;
    }
}
public class Maleri extends Kunstvaerk {
    protected int laengde;
    protected int bredde;
    private Museum museum;

    public Maleri(String titel, int aar, int laengde, int bredde, Museum museum) {
        super(titel, aar);
        this.laengde = laengde;
        this.bredde = bredde;
        this.museum = museum;
    }

    public Museum getMuseum() {
        return museum;
    }
}
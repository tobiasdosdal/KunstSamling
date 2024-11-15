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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(getTitel())
                .append(" Ophavsmænd: ").append(getAntalOphavsmænd())
                .append(" Årstal: ").append(getAar())
                .append(" Genre: ").append(genre)
                .append(" Antal sider: ").append(antalSider);
        if (getOphavsmænd().length != 0) {
            sb.append(" Person: ").append(getOphavsmænd()[0].getNavn());
        }
        return sb.toString();
    }
}
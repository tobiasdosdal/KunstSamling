class Person {
    private String navn;
    private String nationalitet;
    private int fødselsår;
    private int dødsår;

    public Person(String navn, String nationalitet, int fødselsår, int dødsår) {
        this.navn = navn;
        this.nationalitet = nationalitet;
        this.fødselsår = fødselsår;
        this.dødsår = dødsår;
    }

    public String getNavn() {
        return navn;
    }
}
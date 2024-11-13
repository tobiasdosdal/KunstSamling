import java.util.Arrays;

public abstract class Kunstvaerk
{
    protected String titel;
    protected int aar;
    protected Person[] ophavsmænd;
    protected int antalOphavsmænd;

    public Kunstvaerk(String titel, int aar)
    {
        this.titel = titel;
        this.aar = aar;
        this.ophavsmænd = new Person[5];
        this.antalOphavsmænd = 0;
    }

    public void addOphavsmand(Person person)
    {
        if (antalOphavsmænd < 5)
        {
            ophavsmænd[antalOphavsmænd++] = person;
        }
    }

    public String getTitel()
    {
        return titel;
    }

    public Person[] getOphavsmænd()
    {
        return ophavsmænd;
    }

    public String getPersonNavn()
    {
        return ophavsmænd[0].getNavn();
    }

    public int getAntalOphavsmænd()
    {
        return antalOphavsmænd;
    }

    public int getAar()
    {
        return aar;
    }
}
package src;

public class Zug
{
    /**  public Variablen, damit Schachmodell Klasse auch darauf zugriff hat **/
    public int vonReihe, vonSpalte, zuReihe, zuSpalte;

    public Zug()
    {}

    public Zug(int vonReihe, int vonSpalte, int zuReihe, int zuSpalte)
    {
        this.vonReihe = vonReihe;
        this.vonSpalte = vonSpalte;
        this.zuReihe = zuReihe;
        this.zuSpalte = zuSpalte;
    }
}
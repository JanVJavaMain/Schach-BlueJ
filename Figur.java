package src;


public abstract class Figur implements ISchachFigur
{
    private Spieler besitzer;

    public Figur(Spieler spieler)
    {
        this.besitzer = spieler;
    }

    public abstract String typ();

    /**  gibt Spieler zurueck, dem die Figur gehoert  **/
    public Spieler spieler()
    {
        return besitzer;
    }

    /**  Diese Methode wird von der Klasse jeder Figur aufgerufen, da es sich hierbei um eine Methode handelt, die bei allen Figuren, v.a.,
     * wenn man sie bewegen will, Anwendung findet.**/
     
    public boolean istGueltigerZug(Zug zug,ISchachFigur[][] brett)
    {
        /**  wenn man sich nicht zu dem ort bewegen kann  **/
        if ((zug.vonReihe == zug.zuReihe) && (zug.vonSpalte == zug.zuSpalte))
        {
            return false;
        }

        /**  wenn man versucht, mit den Figuren des Gegners zu spielen  **/
        if ( this != brett[zug.vonReihe][zug.vonSpalte] )
        {
            return false;
        }

        /**  Man kann nicht auf seine eigene Figur drauf seine Figur stellen... ;)  **/
        if((brett[zug.zuReihe][zug.zuSpalte] != null) && (brett[zug.zuReihe][zug.zuSpalte].spieler() == besitzer))
        {
            return false;
        }

        return true;
    }
}
package src;


public class Koenig extends Figur
{
    public Koenig(Spieler spieler)
    {
        super(spieler);
    }

    public String typ()
    {
        return "Koenig";
    }

    public boolean istGueltigerZug(Zug zug, ISchachFigur[][] brett)
    {
        boolean gueltig = false;

        if (!super.istGueltigerZug(zug,brett))
        {
            return false;
        }
        /** Position 1  **/
        if((zug.zuReihe == zug.vonReihe) && (zug.zuSpalte == zug.vonSpalte + 1))
        {
            gueltig = true;
        }

        /** Position 2  **/
        else if((zug.zuReihe == zug.vonReihe - 1) && (zug.zuSpalte == zug.vonSpalte + 1))
        {
            gueltig = true;
        }

        /** Position 3  **/
        else if((zug.zuReihe == zug.vonReihe - 1) && (zug.zuSpalte == zug.vonSpalte))
        {
            gueltig = true;
        }

        /** Position 4  **/
        else if((zug.zuReihe == zug.vonReihe - 1) && (zug.zuSpalte == zug.vonSpalte - 1))
        {
            gueltig = true;
        }

        /** Position 5  **/
        else if((zug.zuReihe == zug.vonReihe) && (zug.zuSpalte == zug.vonSpalte - 1))
        {
            gueltig = true;
        }

        /** Position 6  **/
        else if((zug.zuReihe == zug.vonReihe + 1) && (zug.zuSpalte == zug.vonSpalte - 1))
        {
            gueltig = true;
        }

        /** Position 7  **/
        else if((zug.zuReihe == zug.vonReihe + 1) && (zug.zuSpalte == zug.vonSpalte))
        {
            gueltig = true;
        }

        /** Position 1  **/
        else if((zug.zuReihe == zug.vonReihe + 1) && (zug.zuSpalte == zug.vonSpalte + 1))
        {
            gueltig = true;
        }
        return gueltig;
    }
}

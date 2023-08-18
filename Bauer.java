package src;


public class Bauer extends Figur
{
    public Bauer(Spieler spieler)
    {
        super(spieler);
    }

    public String typ()
    {
        return "Bauer";
    }

    public boolean istGueltigerZug(Zug zug,ISchachFigur[][] brett)
    {
        boolean gueltig = false;

        if (!super.istGueltigerZug(zug,brett))
        {
            return false;
        }

        if (brett[zug.vonReihe][zug.vonSpalte].spieler() == Spieler.WEISS)
        {
            if (((zug.zuReihe - 1 == zug.vonReihe) && (zug.zuSpalte + 1 == zug.vonSpalte))
                    || ((zug.zuReihe - 1 == zug.vonReihe) && (zug.zuSpalte - 1 == zug.vonSpalte)))       // prueft, ob Figur diagonal nach unten bewegt wird
                if (brett[zug.zuReihe][zug.zuSpalte] != null)           // prueft, ob Figur eine andere Figur "schmeisst"
                    gueltig = true;
            if (zug.vonReihe == 1)          // prueft, ob es ein schwarzer Bauer in Reihe 2 ist

                if ((zug.zuSpalte == zug.vonSpalte) && (zug.zuReihe == 3))        // prueft,  ob Figur zwei Felder nach vorn bewegt wird

                    if ((brett[2][zug.vonSpalte]) == null && (brett[3][zug.vonSpalte]) == null)     // prueft, ob der "Weg frei ist"
                        gueltig = true;
            if ((zug.zuSpalte == zug.vonSpalte) && (zug.zuReihe - 1 == zug.vonReihe))         // prueft, ob Figur nach unten bewegt wird (von oben ausgehend)
                if ((brett[zug.zuReihe][zug.zuSpalte]) == null)         // prueft, ob der "Weg frei ist"
                    gueltig = true;
        }

        else if (brett[zug.vonReihe][zug.vonSpalte].spieler() == Spieler.SCHWARZ)
        {       // prueft, ob Schwarz am Zug ist
            if (((zug.zuReihe + 1 == zug.vonReihe) && (zug.zuSpalte + 1 == zug.vonSpalte))
                    || ((zug.zuReihe + 1 == zug.vonReihe) && (zug.zuSpalte - 1 == zug.vonSpalte)))        // prueft, ob der Bauer diagonal nach links oder rechts oben sich bewegt

                if (brett[zug.zuReihe][zug.zuSpalte] != null)       // prueft, ob Figur eine andere Figur "schmeisst"
                    gueltig = true;

            if (zug.vonReihe == 6)      // prueft, ob die Figur ein schwarzer Bauer in 7. Reihe ist
                if ((zug.zuSpalte == zug.vonSpalte) && (zug.zuReihe == 4))
                {        // prueft, ob die Figur zwei Feldeer nach vorn bewegt wird
                    if ((brett[5][zug.vonSpalte]) == null && (brett[4][zug.vonSpalte]) == null)
                    {     // prueft, ob die Figur einen freien Weg hat
                        gueltig = true;
                    }
                }
            if ((zug.zuSpalte == zug.vonSpalte) && (zug.zuReihe + 1 == zug.vonReihe))     // "prueft, ob die Figur ein Feld nach vorne bewegt wird

                if ((brett[zug.zuReihe][zug.zuSpalte]) == null)         // prueft, ob der "Weg frei ist"
                    gueltig = true;
        }

        return gueltig;
    }
}

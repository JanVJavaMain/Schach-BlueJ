package src;


public class Turm extends Figur
{
    private Spieler besitzer;

    public Turm(Spieler spieler)
    {
        super(spieler);
    }

    public String typ()
    {
        return "Turm";
    }

    public boolean istGueltigerZug(Zug zug, ISchachFigur[][] brett)
    {
        int aenderungY = Math.abs(zug.vonReihe - zug.zuReihe);
        int aenderungX = Math.abs(zug.vonSpalte - zug.zuSpalte);

        boolean gueltig = true;

        /**  prueft, ob Zug auf dem Brett stattfindet  **/
        if (!super.istGueltigerZug(zug,brett))
        {
            return false;
        }
        /**prueft, ob in selber Spalte / Zeile bewegt wird  **/
        else if((zug.vonReihe != zug.zuReihe) && (zug.vonSpalte != zug.zuSpalte))
        {
            gueltig = false;
        }
        /**  prueft den Raum unterhalb des Turms **/
        else if(zug.zuReihe > zug.vonReihe)
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe + i][zug.vonSpalte] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft den Raum oberhalb des Turms  **/
        else if(zug.zuReihe < zug.vonReihe)
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe - i][zug.vonSpalte] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft den Raum rechts neben den Turm  **/
        else if(zug.zuSpalte > zug.vonSpalte)
        {
            for(int i = 1; i < aenderungX ; i++)
            {
                if(brett[zug.vonReihe][zug.vonSpalte + i] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft den Raum links neben den Turm  **/
        else if(zug.zuSpalte < zug.vonSpalte)
        {
            for(int i = 1; i < aenderungX ; i++)
            {
                if(brett[zug.vonReihe][zug.vonSpalte - i] != null)
                {
                    gueltig = false;
                }
            }
        }

        return gueltig;
    }
}



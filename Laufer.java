package src;


public class Laufer extends Figur
{
    public Laufer(Spieler spieler)
    {
        super(spieler);
    }

    public String typ()
    {
        return "Laufer";
    }

    public boolean istGueltigerZug(Zug zug, ISchachFigur[][] brett)
    {
        int aenderungY = Math.abs(zug.vonReihe - zug.zuReihe);
        int aenderungX = Math.abs(zug.vonSpalte - zug.zuSpalte);

        /**  prueft, ob zug auf dem Brett  **/
        if (!super.istGueltigerZug(zug,brett))
        {
            return false;
        }
        else if((zug.vonReihe == zug.zuReihe) || (zug.vonSpalte == zug.zuSpalte) || (aenderungY != aenderungX))
        {
            return false;
        }
        /**  prueft den Raum diagonal oben rechts  **/
        else if((zug.zuReihe < zug.vonReihe) && (zug.zuSpalte > zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe - i][zug.vonSpalte + i] != null)
                {
                    return false;
                }
            }
        }
        /**   prueft den Raum diagonal oben links  **/
        else if((zug.zuReihe < zug.vonReihe) && (zug.zuSpalte < zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe - i][zug.vonSpalte - i] != null)
                {
                    return false;
                }
            }
        }
        /**   prueft den Raum diagonal unten links **/
        else if((zug.zuReihe > zug.vonReihe) && (zug.zuSpalte < zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY; i++)
            {
                if(brett[zug.vonReihe + i][zug.vonSpalte - i] != null)
                {
                    return false;
                }
            }
        }
        /**  prueft den Raum diagonal unten rechts **/
        else if((zug.zuReihe > zug.vonReihe) && (zug.zuSpalte > zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY; i++)
            {
                if(brett[zug.vonReihe + i][zug.vonSpalte + i] != null)
                {
                    return false;
                }
            }
        }
        return true;
    }
}


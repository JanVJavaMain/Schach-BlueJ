package src;


public class Dame extends Figur
{
    public Dame(Spieler spieler)
    {
        super(spieler);
    }

    public String typ()
    {
        return "Dame";
    }

    public boolean istGueltigerZug(Zug zug, ISchachFigur[][] brett)
    {
        boolean gueltig = true;
        int aenderungY = Math.abs(zug.vonReihe - zug.zuReihe);
        int aenderungX = Math.abs(zug.vonSpalte - zug.zuSpalte);

        if (!super.istGueltigerZug(zug,brett))
        {
            return false;
        }

        /*********************   diagonal  *************************/

        /**  prueft diagonal oben rechts gelegene Felder  **/
        if((zug.zuReihe < zug.vonReihe) && (zug.zuSpalte > zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe - i][zug.vonSpalte + i] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft die Fleder oben gelegen diagonal links  **/
        else if((zug.zuReihe < zug.vonReihe) && (zug.zuSpalte < zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY ; i++)
            {
                if(brett[zug.vonReihe - i][zug.vonSpalte - i] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft die Felder diagonal links unten **/
        else if((zug.zuReihe > zug.vonReihe) && (zug.zuSpalte < zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY; i++)
            {
                if(brett[zug.vonReihe + i][zug.vonSpalte - i] != null)
                {
                    gueltig = false;
                }
            }
        }
        /**  prueft die Felder diagonal rechts unten **/
        else if((zug.zuReihe > zug.vonReihe) && (zug.zuSpalte > zug.vonSpalte))
        {
            for(int i = 1; i < aenderungY; i++)
            {
                if(brett[zug.vonReihe + i][zug.vonSpalte + i] != null)
                {
                    gueltig = false;
                }
            }
        }

        /*********************   horizontal  *************************/

        /**  prueft den Raum unterhalb der Dame  **/
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
        /** prueft Raum oberhalb  **/
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
        /**  rechts daneben  **/
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
        /**  links  **/
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


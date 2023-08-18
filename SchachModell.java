package src;


public class SchachModell implements ISchachModell
{
    private ISchachFigur[][] brett;
    public Spieler spieler;

    final private int SCHWARZ = 0, WEISS = 1;
    private int groesse = 8; //Groesse des Schachbretts

    public SchachModell()
    {
        spieler = Spieler.SCHWARZ;
        brett = new Figur[groesse][groesse];

        /**  Die Orte fuer die weissen Figuren und diese setzen:  **/
        brett[0][0] = new Turm(spieler.WEISS);            brett[1][0] = new Bauer(spieler.WEISS);
        brett[0][1] = new Pferd(spieler.WEISS);           brett[1][1] = new Bauer(spieler.WEISS);
        brett[0][2] = new Laufer(spieler.WEISS);          brett[1][2] = new Bauer(spieler.WEISS);
        brett[0][3] = new Dame(spieler.WEISS);            brett[1][3] = new Bauer(spieler.WEISS);
        brett[0][4] = new Koenig(spieler.WEISS);          brett[1][4] = new Bauer(spieler.WEISS);
        brett[0][5] = new Laufer(spieler.WEISS);          brett[1][5] = new Bauer(spieler.WEISS);
        brett[0][6] = new Pferd(spieler.WEISS);           brett[1][6] = new Bauer(spieler.WEISS);
        brett[0][7] = new Turm(spieler.WEISS);            brett[1][7] = new Bauer(spieler.WEISS);

        /**  Die Orte fuer die schwarzen Figuren und diese setzen:  **/
        brett[7][0] = new Turm(spieler.SCHWARZ);          brett[6][0] = new Bauer(spieler.SCHWARZ);
        brett[7][1] = new Pferd(spieler.SCHWARZ);         brett[6][1] = new Bauer(spieler.SCHWARZ);
        brett[7][2] = new Laufer(spieler.SCHWARZ);        brett[6][2] = new Bauer(spieler.SCHWARZ);
        brett[7][3] = new Koenig(spieler.SCHWARZ);        brett[6][3] = new Bauer(spieler.SCHWARZ);
        brett[7][4] = new Dame(spieler.SCHWARZ);          brett[6][4] = new Bauer(spieler.SCHWARZ);
        brett[7][5] = new Laufer(spieler.SCHWARZ);        brett[6][5] = new Bauer(spieler.SCHWARZ);
        brett[7][6] = new Pferd(spieler.SCHWARZ);         brett[6][6] = new Bauer(spieler.SCHWARZ);
        brett[7][7] = new Turm(spieler.SCHWARZ);          brett[6][7] = new Bauer(spieler.SCHWARZ);

        for(int reihe = 2; reihe < 6; reihe++)
        {
            for(int spalte = 0; spalte < groesse; spalte++)
                brett[reihe][spalte] = null;
        }
    }

    public boolean istGueltigerZug(Zug zug)
    {
        boolean gueltig = false;

        /** Falls auf dem Ziel eine Figur steht:  **/
        if(brett[zug.vonReihe][zug.vonSpalte] != null)
        {
            /**  implimentiert, ob Zug laut Regelwerk ok / valide ist  **/
            if(brett[zug.vonReihe][zug.vonSpalte].istGueltigerZug(zug, brett) == true)
            {
                gueltig = true;
            }
        }
        else
        {
            gueltig = false;
        }

        return gueltig;
    }
    
    public boolean istFertigAufgebaut()
    {
        return false;
    }
    public void bewegeFigur(Zug zug)
    {
        brett[zug.zuReihe][zug.zuSpalte] = brett[zug.vonReihe][zug.vonSpalte];
        brett[zug.vonReihe][zug.vonSpalte] = null;
    }
    public boolean imSchach(Spieler s)
    {
        return false;
    }
    public Spieler derzeitigerSpieler()
    {
        return spieler;
    }
    public int numReihe()
    {
        return groesse;
    }
    public int numSpalte()
    {
        return groesse;
    }
    public ISchachFigur figurBei(int reihe, int spalte)
    {
        return brett[reihe][spalte];
    }
    public Spieler naechsterSpieler()
    {
        spieler = spieler.naechst();
        return spieler;
    }
}


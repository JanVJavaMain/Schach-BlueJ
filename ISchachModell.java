package src;


public interface ISchachModell
{
    boolean istFertigAufgebaut(); //gibt zurueck, ob Spiel komplett aufgebaut ist
    void bewegeFigur(Zug zug); //bewegt die Figur
    boolean imSchach(Spieler s); //gibt zurueck, ob Spieler sich im "Schach" befindet; true - er befindet sich "im Schach"
    Spieler derzeitigerSpieler(); //gibt den aktuellen Spieler zurueck
    int numReihe() ;
    int numSpalte();
    public ISchachFigur figurBei(int reihe, int spalte);
}


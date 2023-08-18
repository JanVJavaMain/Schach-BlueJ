package src;


public interface ISchachFigur
{
    Spieler spieler(); //gibt Besitzer der Figur zurueck
    String typ(); // gibt figurentyp zurueck
    boolean istGueltigerZug(Zug zug, ISchachFigur[][] board); //prueft, ob zug legal ist; wenn valid = false, eine Meldung erscheint - zug illegal 
}
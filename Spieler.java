package src;

public enum Spieler
{
    SCHWARZ, WEISS; 

    public Spieler naechst() //wer ist als naechstes dran?
    {
        if(this == SCHWARZ)
        {
            return WEISS;
        }
        else
        {
            return SCHWARZ;
        }
    }
}
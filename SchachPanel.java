package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchachPanel extends JPanel
{
    //Variablen:
    private int gedrueckt = 0,        groesse = 8;
    private int zuReihe,      zuSpalte;
    private int vonReihe,    vonSpalte;

    //Arrays:
    private JButton[][] selektion;

    //Objekte:
    private Zug z;
    private ISchachModell iSchachModell;
    private SchachModell modell;

    //Brettfarben Icons
    private ImageIcon brettBlauQuadrat, brettGrauQuadrat;

    //buttonlistener / checkt, ob Button gedrueckt wurde und reagiert dementsprechend
    ButtonListener listener = new ButtonListener();         // erstellt das Objekt

    /**  Icons fuer die Figuren deklarieren (sorry fuer die komischen Namen)  */
    private ImageIcon   wb_King,    wg_King,    bb_King,    bg_King;
    private ImageIcon   wb_Queen,   wg_Queen,   bb_Queen,   bg_Queen;
    private ImageIcon   wb_Rook,    wg_Rook,    bb_Rook,    bg_Rook;
    private ImageIcon   wb_Bishop,  wg_Bishop,  bb_Bishop,  bg_Bishop;
    private ImageIcon   wb_Knight,  wg_Knight,  bb_Knight,  bg_Knight;
    private ImageIcon   wb_Pawn,    wg_Pawn,    bb_Pawn,    bg_Pawn;

    public SchachPanel()
    {
        //Objekte
        selektion = new JButton[groesse][groesse];
        iSchachModell = new SchachModell();
        modell = new SchachModell();

        /** Erstellt Brett, das durch die Variablengroeße bestimmt wird*/
        setLayout(new GridLayout(groesse,groesse));                                   // Legt die Größe des Rasterlayouts über die Variable groesse fest
        brettBlauQuadrat = new ImageIcon ("Board Blue.png");                                       // blaues brett
        brettGrauQuadrat = new ImageIcon ("Board Gray.png");                                       // graues Brett

        /** Icons der Figuren initialisieren **/
        wb_King = new ImageIcon ("WBKing.png");         wg_King = new ImageIcon ("WGKing.png");
        wb_Queen = new ImageIcon ("WBQueen.png");       wg_Queen = new ImageIcon ("WGQueen.png");
        wb_Rook = new ImageIcon ("WBRook.png");         wg_Rook = new ImageIcon ("WGRook.png");
        wb_Bishop = new ImageIcon ("WBBishop.png");     wg_Bishop = new ImageIcon ("WGBishop.png");
        wb_Knight = new ImageIcon ("WBKnight.png");     wg_Knight = new ImageIcon ("WGKnight.png");
        wb_Pawn = new ImageIcon ("WBPawn.png");         wg_Pawn = new ImageIcon ("WGPawn.png");

        bb_King = new ImageIcon ("BBKing.png");         bg_King = new ImageIcon ("BGKing.png");
        bb_Queen = new ImageIcon ("BBQueen.png");       bg_Queen = new ImageIcon ("BGQueen.png");
        bb_Rook = new ImageIcon ("BBRook.png");         bg_Rook = new ImageIcon ("BGRook.png");
        bb_Bishop = new ImageIcon ("BBBishop.png");     bg_Bishop = new ImageIcon ("BGBishop.png");
        bb_Knight = new ImageIcon ("BBKnight.png");     bg_Knight = new ImageIcon ("BGKnight.png");
        bb_Pawn = new ImageIcon ("BBPawn.png");         bg_Pawn = new ImageIcon ("BGPawn.png");

        /**  kreiert Standartbrett **/
        standardBrett();
    }

    private void standardBrett()
    {
        /**erstellt das Standardbrett*/
        for (int reihe = 0; reihe < groesse; reihe++)
        {
            for (int spalte = 0; spalte < groesse; spalte++)
            {
                /**  erstellt alle selektierten Knoepfe */
                selektion[reihe][spalte] = new JButton ("");
                selektion[reihe][spalte].addActionListener(listener);                             // den Knopf zum "ActionListener" hinzufuegen -> reagiert
                
                /**  erstellt alle weissen Figuren **/
                if((reihe % 2) == (spalte % 2))
                {
                    if(reihe == 1)                                    selektion[reihe][spalte].setIcon(wb_Pawn);
                    else if(reihe == 0 && (spalte == 0 || spalte == 7))     selektion[reihe][spalte].setIcon(wb_Rook);
                    else if(reihe == 0 && (spalte == 1 || spalte == 6))     selektion[reihe][spalte].setIcon(wb_Knight);
                    else if(reihe == 0 && (spalte == 2 || spalte == 5))     selektion[reihe][spalte].setIcon(wb_Bishop);
                    else if(reihe == 0 && spalte == 3)                   selektion[reihe][spalte].setIcon(wb_Queen);
                    else if(reihe == 0 && spalte == 4)                   selektion[reihe][spalte].setIcon(wb_King);
                    else                                            selektion[reihe][spalte].setIcon(brettBlauQuadrat);
                }
                else
                {
                    if(reihe == 1)                                    selektion[reihe][spalte].setIcon(wg_Pawn);
                    else if(reihe == 0 && (spalte == 0 || spalte == 7))     selektion[reihe][spalte].setIcon(wg_Rook);
                    else if(reihe == 0 && (spalte == 1 || spalte == 6))     selektion[reihe][spalte].setIcon(wg_Knight);
                    else if(reihe == 0 && (spalte == 2 || spalte == 5))     selektion[reihe][spalte].setIcon(wg_Bishop);
                    else if(reihe == 0 && spalte == 3)                   selektion[reihe][spalte].setIcon(wg_Queen);
                    else if(reihe == 0 && spalte == 4)                   selektion[reihe][spalte].setIcon(wg_King);
                    else                                            selektion[reihe][spalte].setIcon(brettGrauQuadrat);
                }

                /**  Erstellt alle schwarzen Figuren **/
                if((reihe % 2) == (spalte % 2))
                {
                    if(reihe == 6)                                    selektion[reihe][spalte].setIcon(bb_Pawn);
                    else if(reihe == 7 && (spalte == 0 || spalte == 7))     selektion[reihe][spalte].setIcon(bb_Rook);
                    else if(reihe == 7 && (spalte == 1 || spalte == 6))     selektion[reihe][spalte].setIcon(bb_Knight);
                    else if(reihe == 7 && (spalte == 2 || spalte == 5))     selektion[reihe][spalte].setIcon(bb_Bishop);
                    else if(reihe == 7 && spalte == 3)                   selektion[reihe][spalte].setIcon(bb_King);
                    else if(reihe == 7 && spalte == 4)                   selektion[reihe][spalte].setIcon(bb_Queen);
                }
                else
                {
                    if(reihe == 6)                                    selektion[reihe][spalte].setIcon(bg_Pawn);
                    else if(reihe == 7 && (spalte == 0 || spalte == 7))     selektion[reihe][spalte].setIcon(bg_Rook);
                    else if(reihe == 7 && (spalte == 1 || spalte == 6))     selektion[reihe][spalte].setIcon(bg_Knight);
                    else if(reihe == 7 && (spalte == 2 || spalte == 5))     selektion[reihe][spalte].setIcon(bg_Bishop);
                    else if(reihe == 7 && spalte == 3)                   selektion[reihe][spalte].setIcon(bg_King);
                    else if(reihe == 7 && spalte == 4)                   selektion[reihe][spalte].setIcon(bg_Queen);
                }
                add(selektion[reihe][spalte]);
            }
        }
    }

    //Methode, die Brett updatet
    private void updateBrett()
    {
        ISchachFigur schachfigur = iSchachModell.figurBei(vonReihe, vonSpalte);
        {
            if((modell.istGueltigerZug(z)) && modell.derzeitigerSpieler() == schachfigur.spieler())
            {
                /**  Jedes Argument überprueft den Figurentyp, den Besitzer und die Position auf dem Brett (WEISS) (die Verwendung des Moduls zeigt ein blaues oder graues Quadrat) und setzt die Figur auf das Brett.**/
                if((zuReihe % 2) == (zuSpalte % 2))
                {
                    if((schachfigur.typ().equals("Turm")) && (schachfigur.spieler() == Spieler.WEISS)){           selektion[zuReihe][zuSpalte].setIcon(wb_Rook);    }
                    if ((schachfigur.typ().equals("Pferd")) && (schachfigur.spieler() == Spieler.WEISS)){        selektion[zuReihe][zuSpalte].setIcon(wb_Knight);  }
                    if ((schachfigur.typ().equals("Laufer")) && (schachfigur.spieler() == Spieler.WEISS)){        selektion[zuReihe][zuSpalte].setIcon(wb_Bishop);  }
                    if ((schachfigur.typ().equals("Koenig")) && (schachfigur.spieler() == Spieler.WEISS)){          selektion[zuReihe][zuSpalte].setIcon(wb_King);    }
                    if ((schachfigur.typ().equals("Dame")) && (schachfigur.spieler() == Spieler.WEISS)){         selektion[zuReihe][zuSpalte].setIcon(wb_Queen);   }
                    if ((schachfigur.typ().equals("Bauer")) && (schachfigur.spieler() == Spieler.WEISS)){          selektion[zuReihe][zuSpalte].setIcon(wb_Pawn);    }

                    if((schachfigur.typ().equals("Turm")) && (schachfigur.spieler() == Spieler.SCHWARZ)){           selektion[zuReihe][zuSpalte].setIcon(bb_Rook);    }
                    if ((schachfigur.typ().equals("Pferd")) && (schachfigur.spieler() == Spieler.SCHWARZ)){        selektion[zuReihe][zuSpalte].setIcon(bb_Knight);  }
                    if ((schachfigur.typ().equals("Laufer")) && (schachfigur.spieler() == Spieler.SCHWARZ)){        selektion[zuReihe][zuSpalte].setIcon(bb_Bishop);  }
                    if ((schachfigur.typ().equals("Koenig")) && (schachfigur.spieler() == Spieler.SCHWARZ)){          selektion[zuReihe][zuSpalte].setIcon(bb_King);    }
                    if ((schachfigur.typ().equals("Dame")) && (schachfigur.spieler() == Spieler.SCHWARZ)){         selektion[zuReihe][zuSpalte].setIcon(bb_Queen);   }
                    if ((schachfigur.typ().equals("Bauer")) && (schachfigur.spieler() == Spieler.SCHWARZ)){          selektion[zuReihe][zuSpalte].setIcon(bb_Pawn);    }
                }

                /**  Selbiges, bloss fuer SCHWARZ**/
                if((zuReihe % 2) != (zuSpalte % 2))
                {
                    if((schachfigur.typ().equals("Turm")) && (schachfigur.spieler() == Spieler.WEISS)){           selektion[zuReihe][zuSpalte].setIcon(wg_Rook);    }
                    if ((schachfigur.typ().equals("Pferd")) && (schachfigur.spieler() == Spieler.WEISS)){        selektion[zuReihe][zuSpalte].setIcon(wg_Knight);  }
                    if ((schachfigur.typ().equals("Laufer")) && (schachfigur.spieler() == Spieler.WEISS)){        selektion[zuReihe][zuSpalte].setIcon(wg_Bishop);  }
                    if ((schachfigur.typ().equals("Koenig")) && (schachfigur.spieler() == Spieler.WEISS)){          selektion[zuReihe][zuSpalte].setIcon(wg_King);    }
                    if ((schachfigur.typ().equals("Dame")) && (schachfigur.spieler() == Spieler.WEISS)){         selektion[zuReihe][zuSpalte].setIcon(wg_Queen);   }
                    if ((schachfigur.typ().equals("Bauer")) && (schachfigur.spieler() == Spieler.WEISS)){          selektion[zuReihe][zuSpalte].setIcon(wg_Pawn);    }

                    if((schachfigur.typ().equals("Turm")) && (schachfigur.spieler() == Spieler.SCHWARZ)){           selektion[zuReihe][zuSpalte].setIcon(bg_Rook);    }
                    if ((schachfigur.typ().equals("Pferd")) && (schachfigur.spieler() == Spieler.SCHWARZ)){        selektion[zuReihe][zuSpalte].setIcon(bg_Knight);  }
                    if ((schachfigur.typ().equals("Laufer")) && (schachfigur.spieler() == Spieler.SCHWARZ)){        selektion[zuReihe][zuSpalte].setIcon(bg_Bishop);  }
                    if ((schachfigur.typ().equals("Koenig")) && (schachfigur.spieler() == Spieler.SCHWARZ)){          selektion[zuReihe][zuSpalte].setIcon(bg_King);    }
                    if ((schachfigur.typ().equals("Dame")) && (schachfigur.spieler() == Spieler.SCHWARZ)){         selektion[zuReihe][zuSpalte].setIcon(bg_Queen);   }
                    if ((schachfigur.typ().equals("Bauer")) && (schachfigur.spieler() == Spieler.SCHWARZ)){          selektion[zuReihe][zuSpalte].setIcon(bg_Pawn);    }
                }

                /** setzt das Von-Positionssymbol immer auf ein Leerzeichen **/
                if((vonReihe % 2) != (vonSpalte % 2)) {selektion[vonReihe][vonSpalte].setIcon(brettGrauQuadrat);  }
                else if((vonReihe % 2) != (vonSpalte % 2)) {selektion[vonReihe][vonSpalte].setIcon(brettBlauQuadrat);  }

                iSchachModell.bewegeFigur(z);
                modell.bewegeFigur(z);

                //gibt die Person an, die als naecchstes am Zug ist:
                System.out.println("Der naechste Spieler am Zug ist: " + modell.naechsterSpieler());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Kein gueltiger Zug.");
            }
        }
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int reihe = 0, spalte = 0;
            JComponent button = (JComponent) event.getSource();
            gedrueckt++;

            if(gedrueckt == 1)
            {
                for(reihe = 0; reihe < groesse; reihe++)
                {
                    for (spalte = 0; spalte < groesse; spalte++)
                    {
                        if(selektion[reihe][spalte] == button)
                        {
                            vonReihe = reihe;
                            vonSpalte = spalte;
                        }
                    }
                }
            }

            if(gedrueckt == 2)
            {
                for(reihe = 0; reihe < groesse; reihe++)
                {
                    for (spalte = 0; spalte < groesse; spalte++)
                    {
                        if(selektion[reihe][spalte] == button)
                        {
                            zuReihe = reihe;
                            zuSpalte = spalte;
                        }
                    }
                }
                gedrueckt = 0;
                z = new Zug(vonReihe, vonSpalte, zuReihe, zuSpalte);
                updateBrett();
            }
        }
    }
}


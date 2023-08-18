package src;

import javax.swing.*;
import javax.swing.border.*;

public class schachoberflaeche extends JPanel
{
    public static void main(String[] args)
    {
        JMenuBar menu;

        JFrame rahmen = new JFrame("Schach");
        rahmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new JMenuBar();
        rahmen.setJMenuBar(menu);

        SchachPanel panel = new SchachPanel();
        rahmen.getContentPane().add(panel);

        rahmen.pack();
        rahmen.setSize(400, 400);
        rahmen.setVisible(true);

        System.out.println("--------------------------------");
        System.out.println("Nicht vorhandene Funktionen:    |");
        System.out.println("Rochade                         |");
        System.out.println("Schachindikator                 |");
        System.out.println("En Peasant                      |");
        System.out.println("--------------------------------");
        System.out.println("Schwarz beginnt.                |");
        System.out.println("Auf ein gutes Spiel.            |");
        System.out.println("--------------------------------");
    }
}


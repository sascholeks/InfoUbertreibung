





import javax.swing.*;

import java.awt.event.*;
public class BUTTON
{
    private JButton beendezug;
    private JButton heilen;
    private JButton kaempfen;
    private JButton bewegen;
    public BUTTON()
    {
        beendezug = new JButton("Beende Zug");
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(beendezug,"unten");
        beendezug.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }
            });
        heilen = new JButton("Heilen");
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(heilen,"unten");
        heilen.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }
            });
        kaempfen = new JButton("Kämpfen");
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(kaempfen,"unten");
        kaempfen.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }
            });
        bewegen = new JButton("Bewegen");
        ZEICHENFENSTER.gibFenster().komponenteHinzufuegen(bewegen,"unten");
        bewegen.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }
            });
    }
    
    
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TASTATUR implements KeyListener
{
    private JFrame f;
    public TASTATUR()
    {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
     
    }

    public void keyTyped(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_UNDEFINED){ 
            System.out.println("Kein Unicode-Character gedr\u00FCckt!"); 
        } 
    } 
    
    public void keyPressed(KeyEvent e) { 
    } 
    
    public void keyReleased(KeyEvent e) { 
    } 
}

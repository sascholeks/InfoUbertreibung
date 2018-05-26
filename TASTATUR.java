import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TASTATUR implements KeyListener
{
    private JFrame f;
    WELT welt;
    public TASTATUR()
    {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        welt=new WELT();
    }
    
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == 65) {  //a
            welt.bewegen(0);
        }else if(e.getKeyCode() == 87) {  //w
            welt.bewegen(1);
        }else if(e.getKeyCode() == 68) {  //d
            welt.bewegen(2);
        }else if(e.getKeyCode() == 83) {  //s
            welt.bewegen(3);
        }
    } 
    
    public void keyTyped(KeyEvent e) { 
    }    
    public void keyReleased(KeyEvent e) {    
    } 
}

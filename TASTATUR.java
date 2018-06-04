import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TASTATUR implements KeyListener
{
    private JFrame f;
    WELT welt;
    boolean help=false;
    public TASTATUR()
    {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        welt=new WELT();
    }
    
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == 65 && welt.bewegungssperre==false) {        //a
            welt.bewegen(0);
        }else if(e.getKeyCode() == 87 && welt.bewegungssperre==false) {  //w
            welt.bewegen(1);
        }else if(e.getKeyCode() == 68 && welt.bewegungssperre==false) {  //d
            welt.bewegen(2);
        }else if(e.getKeyCode() == 83 && welt.bewegungssperre==false) {  //s
            welt.bewegen(3);
        }else if(e.getKeyCode() == 73 && welt.bewegungssperre==false) {  //i
            if(help==false) {
                welt.inventaraufruf();
                help=true;
            }else {
                help=false;
                welt.zeichneansicht();
            }
        }else if(e.getKeyCode() == 27) {                                  //esc
            
        }
    } 
    
    public void keyTyped(KeyEvent e) { 
    }    
    public void keyReleased(KeyEvent e) {    
    } 
}

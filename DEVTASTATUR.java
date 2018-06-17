import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DEVTASTATUR implements KeyListener {

    private JFrame f;
    public DEVTASTATUR() {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        DEV.getDev();
    }

    public void keyPressed(KeyEvent e) { 
        if(e.getKeyChar()=='a') {
            DEV.getDev().complDecide();
        }
        if(e.getKeyChar()=='0') {
            DEV.getDev().skipOrder(0);
        }
        if(e.getKeyChar()=='1') {
            DEV.getDev().skipOrder(1);
        }
        if(e.getKeyChar()=='2') {
            DEV.getDev().skipOrder(2);
        }
        if(e.getKeyChar()=='3') {
            DEV.getDev().skipOrder(3);
        }
        if(e.getKeyChar()=='4') {
            DEV.getDev().skipOrder(4);
        }
        if(e.getKeyChar()=='s') {
            DEV.getDev().beendezug();
        }
    } 

    public void keyTyped(KeyEvent e) { 

    }    

    public void keyReleased(KeyEvent e) {  

    } 
}
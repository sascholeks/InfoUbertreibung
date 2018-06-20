import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class COOKIECLICKER implements MouseListener
{
    JFrame j;
    double aleben = 500;
    double leben = aleben;
    double lebentl = aleben/50;

    double totdmg = 0;
    int tl = 50;

    double attack = 30;
    
    double count = lebentl/attack;
    GRAFIKELEMENTE g;

    public COOKIECLICKER() {
        if(count >= 1) {
            count = 1;
        } else {
            count = count*10;
        }
        
        g = new GRAFIKELEMENTE();
        j = ZEICHENFENSTER.gibFenster().frame;
        j.addMouseListener(this);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(300,100,100,100,4);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(100,50,500,15,33);

        for(int i=0; i<50;i++) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(100+(i*10),50,10,15,38);
        }

        ZEICHENFENSTER.gibFenster().zeichneRechteck(100,50,500,15);

        g.kons("Leben:" +leben);
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=300 && e.getX()<=400 && e.getY() >= 125 && e.getY() <= 225) {
            if(leben>0) {
                leben = leben - attack;
                totdmg = totdmg + attack;
                removetl();
                if(leben<0) {
                    leben = 0;
                }
                g.kons("Leben: " +leben);
            }
        }
    }

    public void removetl() {
        if(totdmg>=lebentl) {
            totdmg = totdmg - lebentl;
            loeschetl(tl,(int)count);
        }
    }

    public void loeschetl(int tl,int count) {
        for(int i=0;i<count;i++) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(100+((tl-1)*10),50,10,15,4);
            tl--;
            System.out.println(tl);
        }
       
        ZEICHENFENSTER.gibFenster().zeichneRechteck(100,50,500,15);
    }

    public void mouseReleased(MouseEvent e) 
    {
    }

    public void mousePressed(MouseEvent e) 
    {  
    } 

    public void mouseEntered(MouseEvent e) 
    {    
    }  

    public void mouseExited(MouseEvent e) 
    {
    } 
}

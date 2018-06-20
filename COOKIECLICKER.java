import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class COOKIECLICKER implements MouseListener
{
    JFrame j;
    COOKIEGRAFIK cg;

    double aleben = 3000;
    double leben = aleben;
    double lebentl = aleben/50;

    double totdmg = 0;
    int tl = 50;

    double attack = 30;

    GRAFIKELEMENTE g;
    int level = 1;
    double totattack = attack;

    double count = lebentl/totattack;
    public COOKIECLICKER() {
        

        cg = new COOKIEGRAFIK();
        g = new GRAFIKELEMENTE();
        j = ZEICHENFENSTER.gibFenster().frame;
        j.addMouseListener(this);

        cg.upgradekasten(50,205);
        cg.text(50+17,205+25,""+level);
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
                leben = leben - totattack;
                totdmg = totdmg + totattack;
                removetl();

                if(leben<0) {
                    leben = 0;
                }

                g.kons("Leben: \t" + leben);
            }
        } else if(e.getX()>=50 && e.getX()<=90 && e.getY() >= 230 && e.getY()<= 310 && level < 99) {
            level++;
            if(level<10) {
                cg.upgradekasten(50,205); 
                cg.text(50+17,205+25,""+level);
            } else {
                cg.upgradekasten(50,205);
                cg.text(50+14,205+25,""+level);
            }
            totattack = attack + (0.1*(level-1)*attack);
            calccount();
        }
    }

    public void removetl() {
        if(totdmg>=lebentl*count) {
            totdmg = totdmg - (lebentl*count);
            loeschetl((int)count);
        }
    }

    public void loeschetl(int count) {
        for(int i=0;i<count;i++) {
            if(tl>0) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(100+((tl-1)*10),50,10,15,4);
                tl--;
            }
        }

        ZEICHENFENSTER.gibFenster().zeichneRechteck(100,50,500,15);
    }

    public void calccount() {
        count = lebentl/totattack;
        if(count>1) {
            count=1;
        } else {
            count = 1/count;
            count = (int) count;
        }
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

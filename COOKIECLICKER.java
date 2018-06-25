import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class COOKIECLICKER implements MouseListener
{
    Random r;
    JFrame j;
    COOKIEGRAFIK cg;
    Timer t;

    double aleben;
    double leben;
    int tl;
    double lebentl;
    double totdmg;
    double attack;
    int level;
    double totattack = attack;
    int coins;
    int time;
    double count = lebentl/totattack;
    public COOKIECLICKER(int dif) {
        r= new Random();
        switch(dif) {
            case 1:
            aleben = (r.nextInt(5)+1)*500;
            break;
            case 2:
            aleben = (r.nextInt(5)+3)*1000;
            break;
            case 3:
            aleben = (r.nextInt(5)+2)*2000;
            break;
            case 4:
            aleben = (r.nextInt(1)+1)*10000;
            break;
            default:
            aleben = (r.nextInt(5)+1)*500;
            break;
        }
        coins = 0;
        leben = aleben;

        tl = 50;
        lebentl = aleben/tl;

        totdmg = 0;
        attack = 30;
        level = 1;
        totattack = attack;

        cg = new COOKIEGRAFIK();
        j = ZEICHENFENSTER.gibFenster().frame;
        j.addMouseListener(this);

        cg.upgradekasten(50,205);
        cg.text(50+17,205+25,""+level);
        cg.leben(leben,100,205);
        cg.schaden((int)totattack,100,235);
        cg.coins(coins,100,265);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(300,100,100,100,4);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(100,50,500,15,33);

        for(int i=0; i<50;i++) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(100+(i*10),50,10,15,38);
        }

        time = 0;
        t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    time++;
                }    
            });

        ZEICHENFENSTER.gibFenster().zeichneRechteck(100,50,500,15);
        calccount();
        t.start();
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=300 && e.getX()<=400 && e.getY() >= 125 && e.getY() <= 225) {
            if(leben>0) {
                leben = leben - totattack;
                totdmg = totdmg + totattack;
                removetl();

                if(leben<=0) {
                    stop();
                }

            }
            cg.leben(leben,100,205);
        } else if(e.getX()>=50 && e.getX()<=90 && e.getY() >= 230 && e.getY()<= 310 && level < 99) {
            if(coins>=100) {
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
                cg.schaden((int)totattack,100,235);
                coins = coins - 100;
                cg.coins(coins,100,265);
            }
        }
    }

    public void removetl() {
        while(totdmg>=lebentl*count) {
            totdmg = totdmg - (lebentl*count);
            loeschetl((int)count);      
            coins = coins + 50;
            cg.coins(coins,100,265);
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

    public void stop() {
        t.stop();
        leben = 0;
    }
    
    public void calccount() {
        count = lebentl/totattack;
        if(count>1) {
            count = 1;
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

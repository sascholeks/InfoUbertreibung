import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class COOKIECLICKER implements MouseListener, KeyListener
{
    Random r;
    JFrame j;
    COOKIEGRAFIK cg;
    Timer t,t2;
    WELT w;

    double aleben;
    double leben;
    int tl;
    double lebentl;
    double totdmg;
    double attack;
    int level,level2;
    double totattack = attack;
    int coins;
    int time;
    double count = lebentl/totattack;
    int activedmg;
    int min,sec;
    double passive;
    int type;
    int dif;
    public COOKIECLICKER() {
        cg = new COOKIEGRAFIK();
        // w = new WELT();
        r= new Random();
        dif = r.nextInt(4)+1;
        img();
        passive = 0;

        activedmg = 0;
        coins = 0;
        leben = aleben;

        tl = 50;
        lebentl = aleben/tl;

        totdmg = 0;
        attack = 30;
        level = 1;
        level2 = 1;
        totattack = attack;

        j = ZEICHENFENSTER.gibFenster().frame;
        j.addMouseListener(this);
        j.addKeyListener(this);

        cg.upgradekasten(20,205);
        cg.text(20+17,205+25,""+level);
        cg.upgradekasten1(70,205);
        cg.text(70+17,205+25,""+level2);
        cg.leben(leben,120,205);
        cg.schaden((int)totattack,(int)passive,120,235);
        cg.coins(coins,120,265);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(100,50,500,15,33);
        min=0;
        cg.text(340,15,"00:00");

        for(int i=0; i<50;i++) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(100+(i*10),50,10,15,38);
        }

        time = 0;
        t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ZEICHENFENSTER.gibFenster().fuelleRechteck(300,2,100,20,8);
                    time++;
                    if(time==60) {
                        min++;
                        time=0;
                    }
                    if(time>=10) {
                        if(min>=10) {
                            cg.text(340,15,min+":"+time);
                        } else {
                            cg.text(340,15,"0"+min+":"+time);
                        }
                    } else {
                        if(min>=10) {
                            cg.text(340,15,min+":0"+time);
                        } else {
                            cg.text(340,15,"0"+min+":0"+time);
                        }

                    }
                    attack(passive);
                }    
            });

        t2 = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    img();
                    t2.stop();
                }    
            });

        ZEICHENFENSTER.gibFenster().zeichneRechteck(100,50,500,15);
        calccount();
        t.start();
    }

    public void img() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(250,70,225,235,8);
        switch(dif) {
            case 1:
            aleben = (r.nextInt(5)+1)*500;
            cg.img(270,75,200,200,0);
            break;
            case 2:
            aleben = (r.nextInt(5)+3)*1000;
            cg.img(270,75,200,200,1);
            break;
            case 3:
            aleben = (r.nextInt(5)+2)*2000;
            cg.img(270,75,200,200,2);
            break;
            case 4:
            aleben = (r.nextInt(1)+1)*10000;
            cg.img(250,55,225,235,3);
            break;
            default:
            aleben = (r.nextInt(5)+1)*500;
            cg.img(270,75,200,200,0);
            break;
        }
    }

    public void imga() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(250,70,225,235,8);
        switch(dif) {
            case 1:
            aleben = (r.nextInt(5)+1)*500;
            cg.imga(270,75,200,200,0);
            break;
            case 2:
            aleben = (r.nextInt(5)+3)*1000;
            cg.imga(270,75,200,200,1);
            break;
            case 3:
            aleben = (r.nextInt(5)+2)*2000;
            cg.imga(270,75,200,200,2);
            break;
            case 4:
            aleben = (r.nextInt(1)+1)*10000;
            cg.imga(250,55,225,235,3);
            break;
            default:
            aleben = (r.nextInt(5)+1)*500;
            cg.imga(270,75,200,200,0);
            break;
        }   
    }

    public void keyPressed(KeyEvent e) { 
        if((e.getKeyCode() == 49)) {     
            upgrade();
        } else if((e.getKeyCode() == 50)) {     
            upgrade1();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=250 && e.getX()<=500 && e.getY() >= 55 && e.getY() <= 275) {
            attack(totattack);
        } else if(e.getX()>=20 && e.getX()<=60 && e.getY() >= 230 && e.getY()<= 310 && level < 99) {
            upgrade();
        } else if(e.getX()>=70 && e.getX() <=110 && e.getY()>= 230 && e.getY() <=310 && level2 <99) {
            upgrade1();
        }
    }

    public void upgrade1() {
        if(coins>=100) {
            level2++;
            if(level2<10) {
                cg.upgradekasten1(70,205); 
                cg.text(70+17,205+25,""+level2);
            } else {
                cg.upgradekasten1(70,205);
                cg.text(70+14,205+25,""+level2);
            }
            coins = coins - 100;
            cg.coins(coins,120,265);
            passive = attack*0.1*(level2-1);
        }
        cg.schaden((int)totattack,(int)passive,120,235);
    }

    public void attack(double attack) {
        if(leben>0) {
            imga();
            t2.start();
            leben = leben - attack;
            totdmg = totdmg + attack;
            removetl();

            if(leben<=0) {
                stop();
            }

        }
        cg.leben((int)leben,120,205);    
    }

    public void upgrade() {
        if(coins>=100) {
            level++;
            if(level<10) {
                cg.upgradekasten(20,205); 
                cg.text(20+17,205+25,""+level);
            } else {
                cg.upgradekasten(20,205);
                cg.text(20+14,205+25,""+level);
            }
            totattack = attack + (0.1*(level-1)*attack);
            calccount();
            cg.schaden((int)totattack,(int)passive,120,235);
            coins = coins - 100;
            cg.coins(coins,120,265);
        }
    }

    public void removetl() {
        while(totdmg>=lebentl*count) {
            totdmg = totdmg - (lebentl*count);
            loeschetl((int)count);      
            coins = coins + 50;
            cg.coins(coins,120,265);
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
        imga();
        leben = 0;
        w.zeichneansicht();
        w.hp16=false;
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

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

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

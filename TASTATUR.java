import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class TASTATUR implements KeyListener
{
    private JFrame f;
    WELT welt; 
    boolean help=false,kom=false;
    int eingabe,hlp;
    public TASTATUR() {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        welt=new WELT();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
    
    public void keyPressed(KeyEvent e) { 
        if((e.getKeyCode() == 65 || e.getKeyCode() == 37) && welt.bewegungssperre==false) {         //a
            welt.bewegen(0);
        }else if((e.getKeyCode() == 87 || e.getKeyCode() == 38)  && welt.bewegungssperre==false) {  //w
            welt.bewegen(1);
        }else if((e.getKeyCode() == 68 || e.getKeyCode() == 39)  && welt.bewegungssperre==false) {  //d
            welt.bewegen(2);
        }else if((e.getKeyCode() == 83 || e.getKeyCode() == 40) && welt.bewegungssperre==false) {   //s
            welt.bewegen(3);
        }else if((e.getKeyCode() == 77) && welt.bewegungssperre==false) {                           //m
            welt.navi();
            welt.mausfreigabe=true;
            welt.bewegungssperre=true;
        }else if(e.getKeyCode() == 73 && welt.bewegungssperre==false) {                             //i
            if(help==false) {
                welt.inventaraufruf();
                help=true;
                //welt.zeichner.stop();
            }else {
                help=false;
                welt.zeichneansicht();
                //welt.zeichner.start();
            }
        }else if (e.getKeyCode() == 10 && welt.bewegungssperre==false) {     //enter
            welt.zeichneansicht();
        }else if(e.getKeyCode() == 27) {                                     //esc
            if(welt.objschirm.shp==true && welt.hp13==0) {
                welt.objschirm.hauptstadt(welt.quest[0]);
            }else if(welt.objschirm.shp==true && welt.hp13==1) {
                welt.objschirm.kaserne(welt.quest[1]);
            }else if(welt.objschirm.shp==true && welt.hp13==2) {
                welt.objschirm.hafen(welt.quest[2]);
            }else if(welt.objschirm.shp==true && welt.hp13==3) {
                welt.objschirm.dorf();
            }else if(welt.objschirm.nav==true) {
                welt.bewegungssperre=false;
                welt.objschirm.nav=false;
                ZEICHENFENSTER.gibFenster().loescheAlles();
                welt.grafik.zeichnerahmen();
                welt.zeichneansicht();
                welt.mausfreigabe=false;
            }else if(welt.objschirm.opt==true) {
                welt.objschirm.esc();
            }else if(welt.objschirm.esc==true) {
                welt.bewegungssperre=false;
                welt.objschirm.hpt=false;
                ZEICHENFENSTER.gibFenster().loescheAlles();
                welt.grafik.zeichnerahmen();
                welt.zeichneansicht();
                welt.mausfreigabe=false;
                welt.objschirm.esc=false;
                welt.objschirm.opt=false;
            }else if(help==true) {  //i
                help=false;
                welt.zeichneansicht();
                //welt.zeichner.start();
            }else if(welt.objschirm.hpt==true || welt.objschirm.kas==true || welt.objschirm.haf==true || welt.objschirm.drf==true) {
                welt.bewegungssperre=false;
                welt.objschirm.hpt=false;
                ZEICHENFENSTER.gibFenster().loescheAlles();
                welt.grafik.zeichnerahmen();
                welt.zeichneansicht();
                welt.mausfreigabe=false;
                welt.objschirm.hpt=false;
                welt.objschirm.kas=false;
                welt.objschirm.haf=false;
                welt.objschirm.drf=false;
                welt.soundausw.play();    
             }else {
                welt.grafik.loeschekons();
                welt.bewegungssperre=true;
                welt.mausfreigabe=true;
                welt.objschirm.esc();
            }
            welt.soundausw.play();
        }
        
        //kommands
        if(e.getKeyCode() == 130) {
            if(kom==false) {
                kom=true;
                eingabe=0;
                welt.grafik.cheat("Cheateingabe");
                welt.bewegungssperre=true;
            }else {
                kom=false;
                welt.bewegungssperre=false;
                welt.grafik.cheat("Cheateingabe beendet");
            }
        }
        if(e.getKeyCode() ==77 && kom==true) {        //m
            eingabe=eingabe+1;
        }else if(e.getKeyCode() ==85 && kom==true) {  //u
            eingabe=eingabe+2;
        }else if(e.getKeyCode() ==84 && kom==true) {  //t
            eingabe=eingabe+3;
        }else if(e.getKeyCode() ==69 && kom==true) {  //e
            eingabe=eingabe+4;
        }else if(e.getKeyCode() ==87 && kom==true) {  //w
            eingabe=eingabe+5;
        }else if(e.getKeyCode() ==76 && kom==true) {  //l
            eingabe=eingabe+6;
        }else if(e.getKeyCode() ==75 && kom==true) {  //k
            eingabe=eingabe+7;
        }else if(e.getKeyCode() ==65 && kom==true) {  //a
            eingabe=eingabe+8;
        }else if(e.getKeyCode() ==70 && kom==true) {  //f
            eingabe=eingabe+9;
        }else if(e.getKeyCode() ==80 && kom==true) {  //p
            eingabe=eingabe+10;  
        }else if(e.getKeyCode() ==83 && kom==true) {  //s
            eingabe=eingabe+11;  
        }else if(e.getKeyCode() ==78 && kom==true) {  //n
            eingabe=eingabe+12; 
        }else if(e.getKeyCode() ==71 && kom==true) {  //g
            eingabe=eingabe+13; 
        }else if(e.getKeyCode() ==73 && kom==true) {  //i
            eingabe=eingabe+14;
        }else if(e.getKeyCode() ==86 && kom==true) {  //v
            eingabe=eingabe+15; 
        }else if(e.getKeyCode() ==79 && kom==true) {  //o
            eingabe=eingabe+16; 
        }else if(e.getKeyCode() ==88 && kom==true) {  //x
            eingabe=eingabe+17; 
        }else if(e.getKeyCode() ==82 && kom==true) {  //r
            eingabe=eingabe+18; 
        }else if(e.getKeyCode() ==67 && kom==true) {  //c
            eingabe=eingabe+19;    
        }else if(e.getKeyCode() ==72 && kom==true) {  //h
            eingabe=eingabe+20;  
        }else if(e.getKeyCode() ==74 && kom==true) {  //j
            eingabe=eingabe+21;
        }else if(e.getKeyCode() ==48 && kom==true) {  //0
            eingabe=eingabe+100;
        }else if(e.getKeyCode() ==49 && kom==true) {  //1
            eingabe=eingabe+101;
        }else if(e.getKeyCode() ==52 && kom==true) {  //4
            eingabe=eingabe+102;
        }else if(e.getKeyCode() ==50 && kom==true) {  //2
            eingabe=eingabe+103;
        }else if(e.getKeyCode() ==51 && kom==true) {  //3
            eingabe=eingabe+104;
        }else if(e.getKeyCode() ==10 && kom==true) {
            switch (eingabe) {
                case 24:
                    welt.tonan();
                    welt.grafik.cheat("Ton: an");
                    break;
                case 10:
                    welt.tonaus();
                    welt.grafik.cheat("Ton: aus");
                    break;
                case 28:
                    welt.tonweltaus();
                    welt.grafik.cheat("TonWelt: aus");
                    break;
                case 45:
                    welt.tonkampfaus();
                    welt.grafik.cheat("Tonkampf: aus");
                    break;
                case 347:
                    welt.gegnerpos[welt.aktpos]=100;
                    welt.zeichneansicht();
                    welt.grafik.cheat("Erstelle Kämpfer");
                    break;
                case 248: 
                    welt.welt[welt.aktpos]=40;
                    welt.zeichneansicht();
                    welt.grafik.cheat("Erstelle Dungeon");
                    break;
                case 146:
                    welt.inv.anz[0]=welt.inv.anz[0]+100;
                    welt.grafik.cheat("100 Bogenschützen erhalten");
                    break;
                case 147:
                    welt.inv.anz[1]=welt.inv.anz[1]+100;
                    welt.grafik.cheat("100 Speerkämpfer erhalten");
                    break;
                case 149:
                    welt.inv.anz[2]=welt.inv.anz[3]+100;
                    welt.grafik.cheat("100 Schildknappen erhalten");
                    break;
                case 150:
                    welt.inv.anz[3]=welt.inv.anz[3]+100;
                    welt.grafik.cheat("100 Ritter erhalten");
                    break;
                case 148:
                    welt.inv.anz[4]=welt.inv.anz[4]+100;
                    welt.grafik.cheat("100 Paladin erhalten");
                    break;
                case 40:
                    welt=new WELT();
                    welt.tonweltaus();
                    welt.grafik.cheat("Generiere Welt");
                    welt.zeichneansicht();
                    kom=false;
                    break;
               case 38:
                    welt.zeichneansicht();
                    welt.hp16=false;
                    welt.kampf.aktionssperre=false;
                    welt.grafik.cheat("Exit Screen");
                    welt.kampf.kampf.musik.stop();
                    break;
               case 96:
                    welt.ignor=true;
                    welt.kampf.kampf.musik.stop();
                    welt.grafik.cheat("Ignoriere Events");
                    break;
               case 68:
                    welt.ignor=false;
                    welt.grafik.cheat("Beachte Events");
                    break;
               case 46:
                    for(int a=0;a<250000;a++) {
                        if(welt.welt[a]==26) {
                            hlp=a;
                        }
                    }
                    welt.grafik.cheat("Tp Hpt");
                    welt.aktpos=hlp;
                    welt.zeichneansicht();
                    break;
               case 249:
                    welt.welt[welt.aktpos]=41;
                    welt.zeichneansicht();
                    welt.grafik.cheat("Spawne Dorf");
                    break;
               case 66:
                    welt.inv.anz[0]=welt.inv.anz[0]+100;
                    welt.inv.anz[1]=welt.inv.anz[1]+100;
                    welt.inv.anz[2]=welt.inv.anz[2]+100;
                    welt.inv.anz[3]=welt.inv.anz[3]+100;
                    welt.inv.anz[4]=welt.inv.anz[4]+100;
                    welt.grafik.cheat("alle Kaempfer erhalten");
                    break;
               case 64:
                    welt.gegnerpos[welt.aktpos]=100;
                    welt.bewegen(0);
                    welt.bewegen(2);
                    break;
               case 49:
                    welt.boot=true;
                    welt.inv.heiltrankkl=welt.inv.heiltrankkl+500;
                    welt.inv.heiltrankgr=welt.inv.heiltrankgr+500;
                    welt.inv.anz[0]=welt.inv.anz[0]+1000;
                    welt.inv.anz[1]=welt.inv.anz[1]+1000;
                    welt.inv.anz[2]=welt.inv.anz[2]+1000;
                    welt.inv.anz[3]=welt.inv.anz[3]+1000;
                    welt.inv.anz[4]=welt.inv.anz[4]+1000;
                    welt.grafik.cheat("set player=Jesus");
                    welt.quest[2]=true;       //für anzeige boot gekauft
                    break;
               case 251:
                    welt.welt[welt.aktpos]=42;
                    welt.zeichneansicht();
                    welt.grafik.cheat("Spawne Hafen");
                    break;
               case 75:
                    welt.inv.geld=welt.inv.geld+100000;
                    welt.grafik.cheat("Du bimst Millionär");
                    break;
               case 94:
                     for(int a=0;a<250000;a++) {
                        welt.gegnerpos[a]=0;
                    }
                    welt.grafik.cheat("Entferne gegner");
                    break;
               case 83:
                    welt.inv.gesap=welt.inv.gesap+1000;
                    welt.grafik.cheat("1000 Äpfel erhalten");
                    break;
               default:
                    welt.grafik.cheat("Ungültiger Cheat"); 
            }
            kom=false;
            eingabe=0;
            welt.bewegungssperre=false;
        }
       
    } 
    
    public void keyTyped(KeyEvent e) { 
    }    
    public void keyReleased(KeyEvent e) {    
    } 
}







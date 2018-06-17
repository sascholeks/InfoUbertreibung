import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TASTATUR implements KeyListener
{
    private JFrame f;
    WELT welt;
    boolean help=false,kom=false;
    int eingabe;
    public TASTATUR() {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        welt=new WELT();
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
            }else {
                help=false;
                welt.zeichneansicht();
            }
        }else if (e.getKeyCode() == 10 && welt.bewegungssperre==false) {     //enter
            welt.zeichneansicht();
        }else if(e.getKeyCode() == 27) {                                     //esc
            
        }//else if(welt.kampf.sieg==true && welt.bewegungssperre==true) {
           // welt.bewegungssperre=false;
        //}
        
        //kommands
        if(e.getKeyCode() == 130) {
            if(kom==false) {
                kom=true;
                eingabe=0;
                welt.grafik.kons("Cheateingabe");
                welt.bewegungssperre=true;
            }else {
                kom=false;
                welt.bewegungssperre=false;
                welt.grafik.kons("Cheateingabe beendet");
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
        }else if(e.getKeyCode() ==48 && kom==true) {  //0
            eingabe=eingabe+100;
        }else if(e.getKeyCode() ==49 && kom==true) {  //1
            eingabe=eingabe+101;
        }else if(e.getKeyCode() ==52 && kom==true) {  //4
            eingabe=eingabe+102;
        }else if(e.getKeyCode() ==52 && kom==true) {  //2
            eingabe=eingabe+103;
        }else if(e.getKeyCode() ==52 && kom==true) {  //3
            eingabe=eingabe+104;
        }else if(e.getKeyCode() ==10) {
            switch (eingabe) {
                case 24:
                    welt.tonan();
                    welt.grafik.kons("Ton an");
                    break;
                case 10:
                    welt.tonaus();
                    welt.grafik.kons("Ton aus");
                    break;
                case 28:
                    welt.tonweltaus();
                    welt.grafik.kons("TonWelt aus");
                    break;
                case 45:
                    welt.tonkampfaus();
                    welt.grafik.kons("Tonkampf aus");
                    break;
                case 347:
                    welt.gegnerpos[welt.aktpos]=100;
                    welt.grafik.kons("erstelle kaempfer");
                    break;
                case 248: 
                    welt.welt[welt.aktpos]=40;
                    welt.grafik.kons("erstelle dungeon");
                    break;
                case 146:
                    welt.inv.anz[0]=welt.inv.anz[0]+100;
                    welt.grafik.kons("100 Bogenschützen erhalten");
                    break;
                case 147:
                    welt.inv.anz[1]=welt.inv.anz[1]+100;
                    welt.grafik.kons("100 Speerkämpfer erhalten");
                    break;
                case 149:
                    welt.inv.anz[2]=welt.inv.anz[3]+100;
                    welt.grafik.kons("100 Schildknappen erhalten");
                    break;
                case 150:
                    welt.inv.anz[3]=welt.inv.anz[3]+100;
                    welt.grafik.kons("100 Ritter erhalten");
                    break;
                case 148:
                    welt.inv.anz[4]=welt.inv.anz[4]+100;
                    welt.grafik.kons("100 Paladin erhalten");
                    break;
                case 40:
                    welt=new WELT();
                    welt.tonweltaus();
                    welt.grafik.kons("Generiere Welt");
                    break;
                default:
                    welt.grafik.kons("ungültiger Cheat"); 
            }
            eingabe=0;
            welt.zeichneansicht();
        }
    } 
    
    public void keyTyped(KeyEvent e) { 
    }    
    public void keyReleased(KeyEvent e) {    
    } 
}







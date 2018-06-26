import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;
public class KAMPFEINGABE implements MouseListener 
{
    private ZEICHENFENSTER f;
    GRAFIKELEMENTE grafik;
    JFrame frame;
    KAMPF kampf;
    int[] x,y;
    int xyp=20,hlp2,feld,konbewegt;
    boolean heilen,kampffreigabe,gekämpft,konbewegen,aktionssperre;
    public KAMPFEINGABE() {
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        grafik=new GRAFIKELEMENTE();
        kampf=new KAMPF();
        x=new int[5];
        y=new int[5];
        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }
        aktionssperre=true;
        frame = ZEICHENFENSTER.gibFenster().frame;
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void kampf(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr,double schwer,boolean tone) {
        kampf.kampf(ausanz0,ausanz1,ausanz2,ausanz3,ausanz4,geganz0,geganz1,geganz2,geganz3,geganz4,heiltrkl,heiltrgr,schwer,tone);
        heilen=false;
        kampffreigabe=false;
        gekämpft=false;
        konbewegen=false;
        konbewegt=0;
    }

    public void mouseReleased(MouseEvent e) {
        if(aktionssperre==false) {
            if(e.getX()>458-20 && e.getX()<458+20 && e.getY()>130-20 && e.getY()<131+20) {       //heilen
                grafik.zeichneaktionsauswahl(0); 
                heilen=true;
                grafik.kons("Wähle die Größe");
            }else if(e.getX()>508-20 && e.getX()<508+20 && e.getY()>82-20 && e.getY()<80+20) {              //kämpfen
                kampffreigabe=true;
                konbewegen=false;
                grafik.zeichneaktionsauswahl(1);
            }else if(e.getX()>558-20 && e.getX()<558+20 && e.getY()>131-20 && e.getY()<131+20) {            //bewegen
                konbewegen=true;
                kampffreigabe=false;
                grafik.zeichneaktionsauswahl(2);
            }else if(e.getX()>505-20 && e.getX()<508+20 && e.getY()>180-20 && e.getY()<180+20) {           //zug beenden            
                if(kampf.reihenfolge[0]>=0 && kampf.reihenfolge[0] <5) {
                    hlp2++;
                    grafik.kons("Zug beenden?");
                    grafik.zeichneaktionsauswahl(3);
                    if(hlp2==2) {
                        hlp2=0;
                        heilen=false;

                        kampffreigabe=false;
                        kampf.beendezug();
                    }
                } else {
                    kampf.complDecide();
                }
            }
            if(heilen==true && e.getX()>418 && e.getX()<437 && e.getY()>110 && e.getY()<130) {      //heilen 2.Auswahl
                heilen=false;
                grafik.heileauswahl(0);
                kampf.heile(0);
                grafik.zeichneaktionswahl();
            }else if(heilen==true && e.getX()>418 && e.getX()<437 && e.getY()>130 && e.getY()<150) {
                heilen=false;
                grafik.heileauswahl(1);
                kampf.heile(1);
                grafik.zeichneaktionswahl();
            }
            if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81 ) {   //kämpfen
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,x[0]+3,45,45,8);
                feld=0;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[0]+3,45,45,8);
                feld=1;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[0]+3,45,45,8);
                feld=2;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[0]+3,45,45,8);
                feld=3;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[0]+3,45,45,8);
                feld=4;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[1]+3,45,45,8);
                feld=5;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[1]+3,45,45,8);
                feld=6;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[1]+3,45,45,8);
                feld=7;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[1]+3,45,45,8);
                feld=8;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[1]+3,45,45,8);
                feld=9;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[2]+3,45,45,8);
                feld=10;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[2]+3,45,45,8);
                feld=11;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[2]+3,45,45,8);
                feld=12;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[2]+3,45,45,8);
                feld=13;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[2]+3,45,45,8);
                feld=14;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[3]+3,45,45,8);
                feld=15;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[3]+3,45,45,8);
                feld=16;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[3]+3,45,45,8);
                feld=17;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[3]+3,45,45,8);
                feld=18;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[3]+3,45,45,8);
                feld=19;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[4]+3,45,45,8);
                feld=20;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[4]+3,45,45,8);
                feld=21;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[4]+3,45,45,8);
                feld=22;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[4]+3,45,45,8);
                feld=23;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[4]+3,45,45,8);
                feld=24;
                gekämpft=true;
            }else if(konbewegen==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81 ) {   //bewegen
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,x[0]+3,45,45,8);
                feld=0;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[0]+3,45,45,8);
                feld=1;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[0]+3,45,45,8);
                feld=2;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[0]+3,45,45,8);
                feld=3;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[0]+3,45,45,8);
                feld=4;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[1]+3,45,45,8);
                feld=5;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[1]+3,45,45,8);
                feld=6;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[1]+3,45,45,8);
                feld=7;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[1]+3,45,45,8);
                feld=8;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[1]+3,45,45,8);
                feld=9;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[2]+3,45,45,8);
                feld=10;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[2]+3,45,45,8);
                feld=11;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[2]+3,45,45,8);
                feld=12;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[2]+3,45,45,8);
                feld=13;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[2]+3,45,45,8);
                feld=14;
                konbewegt++;

            }else if(konbewegen==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[3]+3,45,45,8);
                feld=15;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[3]+3,45,45,8);
                feld=16;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[3]+3,45,45,8);
                feld=17;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[3]+3,45,45,8);
                feld=18;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[3]+3,45,45,8);
                feld=19;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[4]+3,45,45,8);
                feld=20;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[4]+3,45,45,8);
                feld=21;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[4]+3,45,45,8);
                feld=22;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[4]+3,45,45,8);
                feld=23;
                konbewegt++;
            }else if(konbewegen==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[4]+3,45,45,8);
                feld=24;
                konbewegt++;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81 ) {   //kämpfen
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,x[0]+3,45,45,8);
                feld=0;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[0]+3,45,45,8);
                feld=1;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[0]+3,45,45,8);
                feld=2;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[0]+3,45,45,8);
                feld=3;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[0]+3,45,45,8);
                feld=4;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[1]+3,45,45,8);
                feld=5;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[1]+3,45,45,8);
                feld=6;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[1]+3,45,45,8);
                feld=7;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[1]+3,45,45,8);
                feld=8;
                konbewegt++;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[1]+3,45,45,8);
                feld=9;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[2]+3,45,45,8);
                feld=10;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[2]+3,45,45,8);
                feld=11;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[2]+3,45,45,8);
                feld=12;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[2]+3,45,45,8);
                feld=13;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[2]+3,45,45,8);
                feld=14;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[3]+3,45,45,8);
                feld=15;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[3]+3,45,45,8);
                feld=16;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[3]+3,45,45,8);
                feld=17;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[3]+3,45,45,8);
                feld=18;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[3]+3,45,45,8);
                feld=19;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[4]+3,45,45,8);
                feld=20;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[4]+3,45,45,8);
                feld=21;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[4]+3,45,45,8);
                feld=22;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[4]+3,45,45,8);
                feld=23;
                gekämpft=true;
            }else if(kampffreigabe==true && e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[4]+3,45,45,8);
                feld=24;
                gekämpft=true;
            }
            grafik.zeichneinfeld(kampf.welt[feld],feld,(int)kampf.leben[kampf.welt[feld]]/(kampf.kaempfer.leben(kampf.welt[feld]%5)));  
            if(kampffreigabe==true && gekämpft==true) {
                kampffreigabe=false;
                gekämpft=false;
                kampf.kaempfen(feld);
            }else if(konbewegen==true && konbewegt>0) {
                konbewegt=0;
                konbewegen=false;
                kampf.bewege(feld);
            }
        }
    }

    public void mousePressed(MouseEvent e) {   
    } 

    public void mouseEntered(MouseEvent e) {  
    }  

    public void mouseExited(MouseEvent e) {     
    } 

    public void mouseClicked(MouseEvent e) {
    }

    public void dev() {
        aktionssperre=false;
        kampf(20,20,20,20,20,20,20,20,20,20,4,4,2.45,true);
    }
}


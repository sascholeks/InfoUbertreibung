import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class MOUSE implements MouseListener 
{
    private ZEICHENFENSTER f;
    int i=1,feld;
    int xyp=20;
    int[] x,y;
    boolean kont=false;
    public MOUSE()
    {
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        x=new int[5];
        y=new int[5];
        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }
        kont=false;
    }

    public void mousePressed(MouseEvent e) { 
        if(i==0) {  
            if(e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81 ) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,x[0]+3,45,45,8);
                feld=0;
                kont=true;
                i++;
            }else if(e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[0]+3,45,45,8);
                feld=1;
                kont=true;
                i++;
            }else if(e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[0]+3,45,45,8);
                feld=2;
                kont=true;
                i++;
            }else if(e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[0]+3,45,45,8);
                feld=3;
                kont=true;
                i++;
            }else if(e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[0]+30 && e.getY()<y[0]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[0]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[0]+3,45,45,8);
                feld=4;
                kont=true;
                i++;
            }else if(e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[1]+3,45,45,8);
                feld=5;
                kont=true;
                i++;
            }else if(e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[1]+3,45,45,8);
                feld=6;
                kont=true;
                i++;
            }else if(e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[1]+3,45,45,8);
                feld=7;
                kont=true;
                i++;
            }else if(e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[1]+3,45,45,8);
                feld=8;
                kont=true;
                i++;
            }else if(e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[1]+30 && e.getY()<y[1]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[1]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[1]+3,45,45,8);
                feld=9;
                kont=true;
                i++;
            }else if(e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[2]+3,45,45,8);
                feld=10;
                kont=true;
                i++;
            }else if(e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[2]+3,45,45,8);
                feld=11;
                kont=true;
                i++;
            }else if(e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[2]+3,45,45,8);
                feld=12;
                kont=true;
                i++;
            }else if(e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[2]+3,45,45,8);
                feld=13;
                kont=true;
                i++;
            }else if(e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[2]+30 && e.getY()<y[2]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[2]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[2]+3,45,45,8);
                feld=14;
                kont=true;
                i++;
            }else if(e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[3]+3,45,45,8);
                feld=15;
                kont=true;
                i++;
            }else if(e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[3]+3,45,45,8);
                feld=16;
                kont=true;
                i++;
            }else if(e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[3]+3,45,45,8);
                feld=17;
                kont=true;
                i++;
            }else if(e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[3]+3,45,45,8);
                feld=18;
                kont=true;
                i++;
            }else if(e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[3]+30 && e.getY()<y[3]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[3]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[3]+3,45,45,8);
                feld=19;
                kont=true;
                i++;
            }else if(e.getX()>x[0]+7 && e.getX()<x[0]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[0]+3,y[4]+3,45,45,8);
                feld=20;
                kont=true;
                i++;
            }else if(e.getX()>x[1]+7 && e.getX()<x[1]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[1]+3,y[4]+3,45,45,8);
                feld=21;
                kont=true;
                i++;
            }else if(e.getX()>x[2]+7 && e.getX()<x[2]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[2]+3,y[4]+3,45,45,8);
                feld=22;
                kont=true;
                i++;
            }else if(e.getX()>x[3]+7 && e.getX()<x[3]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[3]+3,y[4]+3,45,45,8);
                feld=23;
                kont=true;
                i++;
            }else if(e.getX()>x[4]+7 && e.getX()<x[4]+58 && e.getY()>y[4]+30 && e.getY()<y[4]+81) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+1,y[4]+1,49,49,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[4]+3,y[4]+3,45,45,8);
                feld=24;
                kont=true;
                i++;
            }           
        }
    }
    public void mouseReleased(MouseEvent e) 
    {   
    } 
    public void mouseEntered(MouseEvent e) 
    {  
    }  
    public void mouseExited(MouseEvent e) 
    {     
    } 
    public void mouseClicked(MouseEvent e) 
    {
    }
}

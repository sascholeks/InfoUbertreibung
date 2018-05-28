import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class KAMPFEINGABE implements MouseListener 
{
    private ZEICHENFENSTER f;
    KAMPF kampf;
    MOUSE mouse;
    GRAFIKELEMENTE grafik;
    int help;
    boolean heilen=false,heilenauswahl=false;
    public KAMPFEINGABE(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr)
    {
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        kampf=new KAMPF(ausanz0,ausanz1,ausanz2,ausanz3,ausanz4,geganz0,geganz1,geganz2,geganz3,geganz4,heiltrkl,heiltrgr);
        mouse=new MOUSE();
        grafik=new GRAFIKELEMENTE();
        help=0;
    }
    
    public void mouseReleased(MouseEvent e) {
        if(heilenauswahl==false &&e.getX()>458-20 && e.getX()<458+20 && e.getY()>130-20 && e.getY()<131+20) {       //heilen
            grafik.zeichneaktionsauswahl(0); 
            heilen=true;
            grafik.kons("wähle Größe");
        }                                                                    
        else if(e.getX()>508-20 && e.getX()<508+20 && e.getY()>82-20 && e.getY()<80+20) {              //kämpfen
            grafik.zeichneaktionsauswahl(1);
            mouse.auswahlfreigabe();
            kampf.kaempfen(mouse.feldauswahl);
        }
        else if(e.getX()>558-20 && e.getX()<558+20 && e.getY()>131-20 && e.getY()<131+20) {            //bewegen
            grafik.zeichneaktionsauswahl(2);
            mouse.auswahlfreigabe();
            kampf.bewegen(mouse.feldauswahl); 
        }
        else if(e.getX()>508-20 && e.getX()<508+20 && e.getY()>180-20 && e.getY()<180+20) {           //zug beenden            
            grafik.zeichneaktionsauswahl(3);
            help++;
            heilenauswahl=false;
            if(help==2) {
                kampf.beendezug();
                help=0;
            }else {
                grafik.kons("Sicher, dass du den Zug beenden möchtest");
            }
        }else if(heilen==true && e.getX()>418 && e.getX()<437 && e.getY()>110 && e.getY()<130) {
            heilen=false;
            grafik.heileauswahl(0);
            kampf.heilen(0);
        }else if(heilen==true && e.getX()>418 && e.getX()<437 && e.getY()>130 && e.getY()<150) {
            heilen=false;
            grafik.heileauswahl(1);
            kampf.heilen(1);
        }
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
    public void mouseClicked(MouseEvent e) 
    {
    }
}

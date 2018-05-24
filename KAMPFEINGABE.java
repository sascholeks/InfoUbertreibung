import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class KAMPFEINGABE implements MouseListener 
{
    private ZEICHENFENSTER f;
    KAMPF kampf;
    MOUSE mouse;
    GRAFIKELEMENTE grafik;
  
    public KAMPFEINGABE()
    {
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        kampf=new KAMPF();
        mouse=new MOUSE();
        grafik=new GRAFIKELEMENTE();
    }
    
    public void mouseReleased(MouseEvent e) {
        if(e.getX()>458-20 && e.getX()<458+20 && e.getY()>130-20 && e.getY()<131+20) {                                                     //heilen
            grafik.zeichneaktionsauswahl(0); 
            kampf.heilen(0);                                           //trank eingeben lassen  
        }                                                                    
        else if(e.getX()>508-20 && e.getX()<508+20 && e.getY()>82-20 && e.getY()<80+20) {                                                   //kämpfen
            grafik.zeichneaktionsauswahl(1);
            mouse.auswahlfreigabe();
            kampf.kaempfen(mouse.feldauswahl);
        }
        else if(e.getX()>558-20 && e.getX()<558+20 && e.getY()>131-20 && e.getY()<131+20) {                                                  //bewegen
            grafik.zeichneaktionsauswahl(2);
            mouse.auswahlfreigabe();
            kampf.bewegen(mouse.feldauswahl); 
        }
        else if(e.getX()>508-20 && e.getX()<508+20 && e.getY()>180-20 && e.getY()<180+20) {                                                    //zug beenden
            grafik.zeichneaktionsauswahl(3);
            kampf.beendezug();
            
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

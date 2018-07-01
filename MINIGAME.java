import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.Random;
public class MINIGAME implements KeyListener
{
     private JFrame f;
    Random r;
    MINIGAMEGRAFIK grafik;
    int[] feld;
    int helpspawn,maxzahl;
    boolean bewegung=false;
    public MINIGAME()
    {
        f = ZEICHENFENSTER.gibFenster().frame;     
        f.addKeyListener(this);
        grafik=new MINIGAMEGRAFIK();
        r=new Random();
        feld=new int[16];
    }
    
    public void spiele() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        for(int a=0;a<16;a++) {
            feld[a]=0;
        } 
        grafik.spielfeld();
        neuezahl();
        neuezahl();
        zeichneansicht();
        bewegung=true;
        maxzahl=0;
    }
    
    public void verschieben(int richtung) {
        switch(richtung) {
            case 0:
                for(int a=0;a<3;a++) {
                    for(int x=1;x<4;x++) {
                        for(int y=0;y<4;y++) {
                            if(feld[x+y*4-1]==0) {
                                feld[x+y*4-1]=feld[x+y*4];
                                feld[x+y*4]=0;
                            }else if(feld[x+y*4-1]==feld[x+y*4]) {
                                feld[x+y*4-1]=feld[x+y*4-1]*2;
                                feld[x+y*4]=0;
                            }else if(feld[x+y*4-1]!=feld[x+y*4]) {
                                System.out.println("auftrete3n");
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int a=0;a<3;a++) {
                    for(int y=1;y<4;y++) {
                        for(int x=0;x<4;x++) {
                            if(feld[x+y*4-4]==0) {
                                feld[x+y*4-4]=feld[x+y*4];
                                feld[x+y*4]=0;
                            }else if(feld[x+y*4-4]==feld[x+y*4]) {
                                feld[x+y*4-4]=feld[x+y*4-4]*2;
                                feld[x+y*4]=0;
                            }else {
                                System.out.println("auftrete2n");
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int a=0;a<3;a++) {
                    for(int x=2;x>-1;x--) {
                        for(int y=0;y<4;y++) {
                            if(feld[x+y*4+1]==0) {
                                feld[x+y*4+1]=feld[x+y*4];
                                feld[x+y*4]=0;
                            }else if(feld[x+y*4+1]==feld[x+y*4]) {
                                feld[x+y*4+1]=feld[x+y*4+1]*2;
                                feld[x+y*4]=0;
                                if(maxzahl<feld[x+y*4+1]) {
                                    maxzahl=feld[x+y*4+1];
                                }
                            }else {
                                System.out.println("auftreten1");
                            } 
                        }
                    }
                }
                break;
            case 3:
                for(int a=0;a<3;a++) {
                    for(int y=2;y>-1;y--) {
                        for(int x=0;x<4;x++) {
                            if(feld[x+y*4+4]==0) {
                                feld[x+y*4+4]=feld[x+y*4];
                                feld[x+y*4]=0;
                            }else if(feld[x+y*4+4]==feld[x+y*4]) {
                                feld[x+y*4+4]=feld[x+y*4+4]*2;
                                feld[x+y*4]=0;
                            }else {
                                System.out.println("auftrete1");
                            }
                        }
                    }
                }
                break;
        }
        neuezahl();
        zeichneansicht();
    }
    
    public void neuezahl() {
        do {
            helpspawn=r.nextInt(16);
        }while(feld[helpspawn]!=0);
        feld[helpspawn]=2;
    }
    
    public void zeichneansicht() {
        for(int a=0;a<16;a++) {
            grafik.zeichnekarte(a,feld[a]);
        }
    }
    
    public void kontrolleende() {
    
           // bewegung=false;
        
    }
    
    public void keyPressed(KeyEvent e) { 
        if((e.getKeyCode() == 65 || e.getKeyCode() == 37) && bewegung==true) {        //a
            verschieben(0);
        }else if((e.getKeyCode() == 87 || e.getKeyCode() == 38) && bewegung==true) {  //w
            verschieben(1);
        }else if((e.getKeyCode() == 68 || e.getKeyCode() == 39) && bewegung==true) {  //d
            verschieben(2);
        }else if((e.getKeyCode() == 83 || e.getKeyCode() == 40) && bewegung==true) {  //s
            verschieben(3);
        }
    }
    
    public void keyTyped(KeyEvent e) { 
        
    }  
    
    public void keyReleased(KeyEvent e) {  
        
    }     
}

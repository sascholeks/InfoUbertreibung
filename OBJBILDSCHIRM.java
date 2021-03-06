import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
public class OBJBILDSCHIRM 
{
    int[] anz,ausanz,kaeauswahl,anzauswahl;
    boolean freigabe,hpt,shp,kas,kaserne,nav,haf,drf,esc,opt,tonan;
    BufferedImage img;
    Graphics g;
    JFrame fr;
    public OBJBILDSCHIRM()
    {
        g = ZEICHENFENSTER.gibFenster().getGraphic();
        fr = ZEICHENFENSTER.gibFenster().frame;
        anz=new int[10];
        ausanz=new int[5];
        kaeauswahl=new int[5];
        anzauswahl=new int[5];
        for(int a=0;a<10;a++) {
            anz[a]=10;                 //anfang
            ausanz[a%5]=0; 
            kaeauswahl[a%5]=0;

        }
        hpt=false;
        kaserne=false;
    }

    public void img(int x,int y,int xs,int ys,int ID) {
        try {
            switch(ID) {
                case 0:
                img = ImageIO.read(new File("dorf.png"));
                break;
                case 1:
                img = ImageIO.read(new File("hafen.png"));
                break;
                case 2:
                img = ImageIO.read(new File("stadt.png"));
                break;
                case 3:
                img = ImageIO.read(new File("kampf1.png"));
                break;
                case 4:
                img = ImageIO.read(new File("kampf2.png"));
                break;
                case 5:
                img = ImageIO.read(new File("kampf3.png"));
                break;
                case 6:
                img = ImageIO.read(new File("kampf.jpg"));
                break;
                case 7:
                img = ImageIO.read(new File("menü.png"));
                break;
                case 8:
                img= ImageIO.read(new File("inventar.png"));
                break;
                default:
                img = ImageIO.read(new File("stadt.png"));
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(img,x,y,xs,ys,null);
        ZEICHENFENSTER.gibFenster().repaint();
    }
    


    public void hauptstadt(boolean erfüllt) {
        hpt=true;
        shp=false;
        kas=false;
        nav=false;
        haf=false;
        drf=false;
        esc=false;
        opt=false;
        ZEICHENFENSTER.gibFenster().loescheAlles();
        img(0,0,700,300,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);       
        ZEICHENFENSTER.gibFenster().zeichneText("Quest",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("Shop",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,115);
        if(erfüllt==true) {
            haken();
        }
    }

    public void shop() {
        shp=true;
        hpt=false;
        kas=false;
        nav=false;
        haf=false;
        drf=false;
        esc=false;
        opt=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);      
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,124,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,124,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,144,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,144,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,164,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,164,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Bogenschütze",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Speerkämpfer",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Schildknappe",61,115);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Ritter",61,135);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Paladin",61,155);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,175);
    }

    public void kaserne(boolean erfüllt) {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kas=true;
        shp=false;
        nav=false;
        haf=false;
        drf=false;
        esc=false;
        opt=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("Quest",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("shop",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,115);
        if(erfüllt==true) {
            haken();
        }
    }  

    public void hafen(boolean gekauft) {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        img(0,0,700,300,1);
        haf=true;
        kas=false;
        shp=false;
        nav=false;
        drf=false;
        esc=false;
        opt=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("Kaufe Boot",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("Shop",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,115);
        if(gekauft==true) {
            hakenhf();
        }
    }
    
    public void dorf() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        drf=true;
        kas=false;;
        shp=false;
        nav=false;
        haf=false;
        esc=false;
        opt=false;
        img(0,0,700,300,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("Quest",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("shop",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,115);
    }  

    public void navi() {
        nav=true;
        hpt=false;
        shp=false;
        kas=false;
        haf=false;
        drf=false;
        esc=false;
        opt=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,55,168,132,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,55,168,132);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);      
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,124,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,124,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,144,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,144,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,164,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,164,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("Hauptstadt",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("Kaserne",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Letzter Hafen",61,115);
        ZEICHENFENSTER.gibFenster().zeichneText("Letztes Dorf",61,135);
        ZEICHENFENSTER.gibFenster().zeichneText("Entferne Anzeige",61,155);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,175);
    }

    public void esc() {
        esc=true;
        nav=false;
        hpt=false;
        shp=false;
        kas=false;
        haf=false;
        drf=false;
        opt=false;
        img(0,0,700,300,7);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);      
        ZEICHENFENSTER.gibFenster().zeichneText("Zurück zum Spiel",61,75);
        ZEICHENFENSTER.gibFenster().zeichneText("Optionen",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Verlassen",61,115);
    }
    
    public void optionen(boolean tonan) {
        opt=true;
        nav=false;
        hpt=false;
        shp=false;
        kas=false;
        haf=false;
        drf=false;
        esc=false;
        img(0,0,700,300,7);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);      
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,124,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,124,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,144,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,144,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,164,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,164,150,13);
        if(tonan==true) {
            ZEICHENFENSTER.gibFenster().zeichneText("Ton aus",61,75);
        }else {
            ZEICHENFENSTER.gibFenster().zeichneText("Ton an",61,75);
        }
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,95);
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,115);
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,135);
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,155);
        ZEICHENFENSTER.gibFenster().zeichneText("Verlassen",61,175);
    }
    
    public void haken() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(112,70,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(113,71,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(114,72,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(115,73,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(116,76,3,1,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(117,73,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(118,72,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(119,71,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(120,70,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(121,69,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(122,68,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(123,67,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(124,66,3,3,2);
    }

    public void hakenhf() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(132,70,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(133,71,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(134,72,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(135,73,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(136,76,3,1,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(137,73,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(138,72,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(139,71,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(140,70,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(141,69,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(142,68,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(143,67,3,3,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(144,66,3,3,2);
    }

    public void quest() {
        kaserne=true;
    }
}

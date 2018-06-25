import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.applet.Applet;
public class COOKIEGRAFIK extends Applet
{
    BufferedImage img;
    Graphics g;
    JFrame f;
    public COOKIEGRAFIK() {
        g = ZEICHENFENSTER.gibFenster().getGraphic();
        f = ZEICHENFENSTER.gibFenster().frame;
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }

    public void img(int x,int y,int xs,int ys,int ID) {

        try {
            switch(ID) {
                case 0:
                img = ImageIO.read(new File("cookie0.png"));
                break;
                case 1:
                img = ImageIO.read(new File("cookie1.png"));
                break;
                case 2:
                img = ImageIO.read(new File("cookie2.png"));
                break;
                case 3:
                img = ImageIO.read(new File("cookie3.png"));
                break;
                default:
                img = ImageIO.read(new File("cookie0.png"));
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(img,x,y,xs,ys,null);
        ZEICHENFENSTER.gibFenster().repaint();
    }

    public void kasten(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,40,40,11);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+40,40,40,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,40,40);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y+40,40,40);
    }

    public void upgrade(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y,6,30,36);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+12,30,6,36);
    }

    public void upgradekasten(int x,int y) {
        kasten(x,y);
        upgrade(x+5,y+45);
        typ(x+5,y+5);
    }

    public void typ(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+15,y+15,15,36);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+15,y+15,12,11);
    }

    public void text(int x,int y,String text) {
        ZEICHENFENSTER.gibFenster().zeichneText(text,x,y);
    }

    public void leben(double leben, int x,int y) {
        String text = "Leben:     " + leben;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

    public void schaden(int attack, int x,int y) {
        String text = "Schaden: " + attack;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

    public void coins(int coins, int x,int y) {
        String text = "Coins:      " + coins + "/100";
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

}

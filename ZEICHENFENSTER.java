
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class ZEICHENFENSTER - Eine Klasse, die einfache grafische Zeichnungen 
 * in einem Programmfenster ermoeglicht.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 * @author Christian Heidrich
 *
 * @version 2007.05.07
 */

public class ZEICHENFENSTER
{
    public JFrame frame;
    private CanvasPane canvas;
    private JPanel steuerungOst,steuerungSued;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private static ZEICHENFENSTER singleton;

    /**
     * Erzeugt eine Zeichenfenster mit Standardma�en 700*290 und Hintergrundfarbe wei� 
     * @param titel  Titel des Fensters     
     */
    public ZEICHENFENSTER(String titel)
    {
        this(titel, 700, 300, Color.white);          
    }

    /**
     * Erzeugt ein Zeichenfenster mit wei�em Hintergrund.
     * @param titel  Fensterueberschirft
     * @param breite  Breite des Fensters
     * @param hoehe  Hoehe des Fensters
     */
    public ZEICHENFENSTER(String titel, int breite, int hoehe)
    {
        this(titel, breite, hoehe, Color.white);
    }

    public void setTitle(String title){

    }

    /**
     * Erzeugt ein Zeichenfenster.
     * @param titel  Fensterueberschirft
     * @param breite  Breite des Fensters
     * @param hoehe  Hoehe des Fensters
     * @param hintergrundFarbe  Hintergrundfarbe des Zeichenfensters
     */
    private ZEICHENFENSTER(String titel, int breite, int hoehe, Color hintergrundFarbe)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        frame.getContentPane().add(canvas,BorderLayout.CENTER);
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        steuerungOst = new JPanel();
        steuerungSued = new JPanel();
        steuerungOst.setLayout(new BoxLayout(steuerungOst,BoxLayout.Y_AXIS));
        steuerungSued.setLayout(new BoxLayout(steuerungSued,BoxLayout.X_AXIS));
        p1.add(steuerungOst,BorderLayout.NORTH);
        frame.getContentPane().add(p1,BorderLayout.EAST);
        frame.getContentPane().add(steuerungSued,BorderLayout.SOUTH);
        frame.setTitle(titel);
        backgroundColor = hintergrundFarbe;
        frame.pack();
        zeige();
    }

    public static ZEICHENFENSTER gibFenster()
    {
        if (singleton==null){singleton=new ZEICHENFENSTER("Spiel", 700, 300);}
        singleton.zeige();
        return singleton;
    }

    /**
     * Macht das Zeichenfenster sichtbar bzw. setzt es in den Vordergrund,
     * falls es bereits sichtbar ist.
     */
    public void zeige()
    {
        if(graphic == null) {
            // nur beim ersten Aufruf wird der Hintergrund mit der Hintergrundfarbe 
            // gefuellt
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Gibt Information �ber die Sichtbarkeit.
     * @return  true falls das Fenster sichtbar ist.
     */
    public boolean istSichtbar()
    {
        return frame.isVisible();
    }

    /**
     * Zeichnet einen Elipsenbogen (Siehe Graphics.drawArc)
     * @param x x-Koordinate des Elipsenmittelpunkts
     * @param y y-Koordinate des Elipsenmittelpunkts
     * @param halbachseX Halbachse der Elipse in x-Richtung
     * @param halbachseY Halbachse der Elipse in y-Richtung
     * @param startWinkel Polarwinkel, an dem der Bogen anf�ngt
     * @param winkel Polarwinkel, welchen der Bogen durchl�uft
     */
    public void zeichneBogen(int x, int y, int halbachseX, int halbachseY, int startWinkel, int winkel)
    {
        graphic.drawArc(x-halbachseX,y-halbachseY,2*halbachseX,2*halbachseY,startWinkel,winkel);
        canvas.repaint();
    }

    /**
     * Zeichnet einen Kreis (Siehe Graphics.drawOval)
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void zeichneKreis(int x, int y, int radius)
    {
        graphic.drawOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Kreises mit der angegebenen Farbe. 
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param  farbe  F�llfarbe f�r den Kreis, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleKreis(int x, int y, int radius, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Kreises mit der angegebenen Farbe. 
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param  farbnr  F�llfarbnummer f�r den Kreis (0 bis 8)
     */
    public void fuelleKreis(int x, int y, int radius, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht das Innere eines Kreises 
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void loescheKreis(int x, int y, int radius)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x-radius, y-radius, 2*radius, 2*radius);
        loesche(circle);
    }

    /**
     * Zeichnet den Umriss eines Shape-Objekts.
     * @param  shape  das Shape-Object, welches gezeichnet werden soll
     */
    public void zeichne(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Shape-Objekts mit der angegebenen Farbe. 
     * @param  shape  das Shape-Objekt, welches gef�llt werden soll 
     * @param  farbe  F�llfarbe f�r das Shape-Objekt, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelle(Shape shape, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Shape-Objekts mit der angegebenen Farbe. 
     * @param  shape  das Shape-Objekt, welches gef�llt werden soll 
     * @param  farbnr  F�llfarbnummer f�r das Shape-Objekt (0 bis 8)
     */
    public void fuelle(Shape shape, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht das Innere eines Shape-Objekts.
     * @param  shape  das Shape-Object, welches gel�scht werden soll 
     */
    public void loesche(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet den Rand des Rechtecks mit der aktuellen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke 
     * @param breite, hoehe Breite und H�he des Rechtecks
     */
    public void zeichneRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        graphic.drawRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        // fill(new Rectangle(xPos, yPos, breite, hoehe));
    }

    /**
     * F�llt das Innere des Rechtecks mit der angegebenen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke 
     * @param breite, hoehe Breite und H�he des Rechtecks
     * @param  farbe  F�llfarbe f�r das Rechteck, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere des Rechtecks mit der angegebenen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke 
     * @param breite, hoehe Breite und H�he des Rechtecks
     * @param  farbnr  F�llfarbnummer f�r das Rechteck (0 bis 8)
     */
    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht das Innere eines Rechtecks.
     * @param xPos,yPos Koordinaten der linken oberen Ecke 
     * @param breite, hoehe Breite und H�he des Rechtecks
     */
    public void loescheRechteck(int xPos, int yPos, int breite, int hoehe)
    {
        loesche(new Rectangle(xPos, yPos, breite, hoehe));
    }

    private Polygon gibDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        Polygon p=new Polygon();
        p.addPoint(x1,y1);
        p.addPoint(x2,y3);
        p.addPoint(x3,y3);
        return p;
    }

    /**
     * Zeichnet den Rand eines Dreiecks mit der aktuellen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts 
     * @param x2,y2 Koordinaten des zweiten Eckpunkts 
     * @param x3,y3 Koordinaten des dritten Eckpunkts 
     */
    public void zeichneDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphic.drawPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Dreiecks mit der angegebenen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts 
     * @param x2,y2 Koordinaten des zweiten Eckpunkts 
     * @param x3,y3 Koordinaten des dritten Eckpunkts 
     * @param  farbe  F�llfarbe f�r das Dreieck, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Dreiecks mit der angegebenen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts 
     * @param x2,y2 Koordinaten des zweiten Eckpunkts 
     * @param x3,y3 Koordinaten des dritten Eckpunkts 
     * @param  farbnr  F�llfarbnummer f�r das Dreieck (0 bis 8)
     */
    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht das Innere eines Dreicks
     * @param x1,y1 Koordinaten des ersten Eckpunkts 
     * @param x2,y2 Koordinaten des zweiten Eckpunkts 
     * @param x3,y3 Koordinaten des dritten Eckpunkts 
     */
    public void loescheDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        loesche(gibDreieck(x1, y1, x2, y2, x3, y3));
    }

    /**
     * L�scht den Inhalt des Zeichenfensters.
     */
    public void loescheAlles()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * L�scht den Umriss eines Shape-Objekts.
     * @param  shape  das Shape-Object, dessen Umriss gel�scht werden soll 
     */
    public void loescheRand(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // L�schen durch �bermalen mit Hintergrundfarbe
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet ein Bild in das Zeichnenfenster .
     * @param  bild    das anzuzeigende Bild 
     * @param  x       x-Koordinate des linken Bildrands 
     * @param  y       y-Koordinate des oberen Bildrands 
     * @return  gibt eines booleschen Wert zur�ck, der angibt, ob das Bild vollst�ndig geladen 
     *          werden konnte 
     */
    public boolean zeichneBild(Image bild, int x, int y)
    {
        boolean result = graphic.drawImage(bild, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Zeichnet einen Text.
     * @param  text    die anzuzeigende Zeichenkette 
     * @param  x       x-Koordinate des linken Rands 
     * @param  y       y-Koordinate des oberen Rands 
     */
    public void zeichneText(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * L�scht einen Text vom Zeichenfenster.
     * @param  text    die zu l�schende Zeichenkette 
     * @param  x       x-Koordinate des linken Rands 
     * @param  y       y-Koordinate des oberen Rands 
     */
    public void loescheText(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet eine Strecke ins Zeichenfenster.
     * @param  x1   x-Koordinate des Anfangspunkts der Strecke 
     * @param  y1   y-Koordinate des Anfangspunkts der Strecke
     * @param  x2   x-Koordinate des Endpunkts der Strecke 
     * @param  y2   y-Koordinate des Endpunkts der Strecke  
     */
    public void zeichneStrecke(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * Setzt die Vordergrundfarbe des Zeichenfensters.
     * @param  neueFarbe   neue Vordergrundfarbe 
     */
    public void setzeVordergrundFarbe(String neueFarbe)
    {
        graphic.setColor(farbeZuColor(neueFarbe));
    }

    private void setzeVordergrundFarbe(Color neueFarbe)
    {
        graphic.setColor(neueFarbe);
    }

    private Color farbeZuColor(int farbnr)
    {
        switch (farbnr)
        {
            case 0: return Color.black;
            case 1: return Color.blue;
            case 2: return Color.green;
            case 3: return Color.cyan;
            case 4: return Color.red;
            case 5: return Color.magenta;
            case 6: return Color.yellow;
            case 7: return Color.gray;
            case 8: return Color.white;
            case 9: Color c1 = new Color(255,20,147);
            return c1;
            case 10: Color c2 = new Color(127,126,0); 
            return c2;  
            case 11: Color whitegray = new Color(180,189,180);
            return whitegray; 
            case 12: Color hellbraun = new Color(181,160,95);
            return hellbraun;
            case 13: Color lel = new Color(115,81,42);
            return lel;
            case 14: Color lel2 =new Color(150,106,55);
            return lel2; 
            case 15: Color base = new Color(43,190,21);
            return base;
            case 16: Color grau = new Color(170,170,170);
            return grau;
            case 17: Color Gras = new Color(10,150,90);
            return Gras;
            case 18: Color rötlich= new Color(143,18,7);
            return rötlich;
            case 19: Color blau = new Color(8,38,112);
            return blau;
            case 20: Color gelb = new Color(229,230,21);
            return gelb;
            case 22: Color schnee = new Color(191,191,191);
            return schnee;
            case 23: Color berghellgrau = new Color(115,115,115);
            return berghellgrau;
            case 24: Color bergfusbemoost = new Color(81,105,89);
            return bergfusbemoost;
            case 25: Color hellrot = new Color (169,30,35);
            return hellrot;
            case 26: Color dunkelrot = new Color(123,19,20);
            return dunkelrot;
            case 27: Color hellgrau = new Color(177,177,177);
            return hellgrau;
            case 28: Color dunkelgrau = new Color(82,84,83);
            return dunkelgrau;
            case 29: Color hautfarbe = new Color(253,182,120);
            return hautfarbe;
            case 30: Color orange = new Color(244,118,34);
            return orange;
            case 31 : Color weg=new Color(130,119,98);
            return weg;

            default: return graphic.getColor();
        }

    }

    private Color farbeZuColor(String farbe)
    {
        if (farbe=="weiss") return Color.white;
        if (farbe=="schwarz") return Color.black;
        if (farbe=="rot") return Color.red;
        if (farbe=="gruen") return Color.green;
        if (farbe=="blau") return Color.blue;
        if (farbe=="gelb") return Color.yellow;
        if (farbe=="magenta") return Color.magenta;
        if (farbe=="cyan") return Color.cyan;
        if (farbe=="grau") return Color.gray;
        return graphic.getColor();
    }

    private String colorZuFarbe(Color color)
    {
        if (color==Color.white) return "weiss";
        if (color==Color.black) return "schwarz";
        if (color==Color.red) return "rot";
        if (color==Color.green) return "gruen";
        if (color==Color.blue) return "blau";
        if (color==Color.yellow) return "gelb";
        if (color==Color.magenta) return "magenta";
        if (color==Color.cyan) return "cyan";
        if (color==Color.gray) return "gruen";
        return "";
    }

    /**
     * Gibt die aktuelle Vordergrundfarbe des Zeichenfensters zur�ck.
     * @return   die aktuelle Vordergrundfarbe 
     */
    public String gibVordergrundFarbe()
    {
        return colorZuFarbe(graphic.getColor());
    }
    //public Color gibVordergrundFarbe()
    //{
    //    return graphic.getColor();
    //}

    /**
     * Setzt die Hintergrundfarbe des Zeichenfensters.
     * @param  neueFarbe   neue Hintergrundfarbe 
     */
    public void setzeHintergrundFarbe(String neueFarbe)
    {
        backgroundColor = farbeZuColor(neueFarbe);   
        graphic.setBackground(backgroundColor);
    }

    private void setzeHintergrundFarbe(Color neueFarbe)
    {
        backgroundColor = neueFarbe;   
        graphic.setBackground(neueFarbe);
    }

    /**
     * Gibt die aktuelle Hintergrundfarbe des Zeichenfensters zur�ck.
     * @return   die aktuelle Hintergrundfarbe 
     */
    public String gibHintergrundFarbe()
    {
        return colorZuFarbe(backgroundColor);
    }
    //public Color gibHintergrundFarbe()
    //{
    //    return backgroundColor;
    //}

    /**
     * �ndert den aktuellen Zeichensatz des Zeichenfensters.
     * @param  neuerZeichensatz   Zeichensatz, der k�nftig f�r Zeichenkettenausgaben verwendet wird
     */
    public void setzeZeichensatz(Font neuerZeichensatz)
    {
        graphic.setFont(neuerZeichensatz);
    }

    /**
     * Gibt den aktuellen Zeichensatz des Zeichenfensters zur�ck.
     * @return     den aktuellen Zeichensatz
     **/
    public Font gibZeichensatz()
    {
        return graphic.getFont();
    }

    /**
     * �ndert die Abmessungen des Zeichenfensters.
     * @param  breite    neue Breite 
     * @param  hoehe     neue H�he 
     */
    public void setzeMasse(int breite, int hoehe)
    {
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(breite, hoehe);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Gibt die Abmessungen des Zeichenfensters zur�ck.
     * @return     die aktuellen Abmessungen des Zeichenfensters
     */
    public Dimension gibMasse()
    {
        return canvas.getSize();
    }

    /**
     * Wartet eine bestimmte Zeit.
     * Eine kurze Verz�gerung kann z. B. f�r Animationen verwendet werden.
     * @param  zeit  Wartezeit in Millisekunden 
     */
    public void warte(int zeit)
    {
        try
        {
            Thread.sleep(zeit);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * F�gt ein weiteres Steuerungselement in die rechte Steuerungsleiste ein.
     * @param  element  Das einzuf�gende Steuerungselement muss aus JComponent abgeleitet
     * sein. z. B. JButton, JComboBox. 
     */
    public void komponenteHinzufuegen(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.add(element);
        else if (position=="unten") steuerungSued.add(element);
        frame.pack();
    }

    /**
     * Beschriftet den Titel des Zeichenfensters neu.
     * @param  titelNeu  Text der neuen Fenster�berschrift
     */
    public void setzeTitel(String titelNeu)
    {
        frame.setTitle(titelNeu);
    }

    public void schliesse()
    {
        frame.dispose();
    }

    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 20060330L;

        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}

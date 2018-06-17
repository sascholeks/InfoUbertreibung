
public class OBJBILDSCHIRM 
{
    GRAFIKELEMENTE grafik;
    int[] anz,ausanz,kaeauswahl,anzauswahl;
    boolean freigabe,hpt,shp,kas,kaserne,nav;
    public OBJBILDSCHIRM()
    {
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
    
    public void hauptstadt(boolean erfüllt) {
        hpt=true;
        shp=false;
        kas=false;
        nav=false;
        grafik=new GRAFIKELEMENTE();
        ZEICHENFENSTER.gibFenster().loescheAlles();
         //png
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,140,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,140);
        
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,50,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,50,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,50,13);       
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
        //png
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,140,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,140);
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
        //png
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,140,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,140);
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
    
    public void navi() {
        nav=true;
        hpt=false;
        shp=false;
        kas=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,140,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,140);
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
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,115);
        ZEICHENFENSTER.gibFenster().zeichneText("--",61,135);
        ZEICHENFENSTER.gibFenster().zeichneText("Entferne Anzeige",61,155);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",61,175);
    }
    
    public void esc() {
        //fertig machen
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
    
    public void quest() {
        kaserne=true;
    }
}


public class OBJBILDSCHIRM 
{
    GRAFIKELEMENTE grafik;
    int[] anz,ausanz,kaeauswahl,anzauswahl;
    boolean freigabe,hpt,shp,kas,kaserne;
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
    
    public void hauptstadt() {
        hpt=true;
        shp=false;
        grafik=new GRAFIKELEMENTE();
        ZEICHENFENSTER.gibFenster().loescheAlles();
         //png
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,120,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,120);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,50,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,50,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,50,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,50,13);       
        ZEICHENFENSTER.gibFenster().zeichneText("Quest (kommt noch)",60,75);
        ZEICHENFENSTER.gibFenster().zeichneText("Shop",60,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",60,115);
       
    }
    
    public void shop() {
        shp=true;
        hpt=false;
        kas=false;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,120,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,120);
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
        ZEICHENFENSTER.gibFenster().zeichneText("1 Bogenschütze",60,75);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Speerkämpfer",60,95);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Schildknappe",60,115);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Ritter",60,135);
        ZEICHENFENSTER.gibFenster().zeichneText("1 Paladin",60,155);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",60,175);
    }
    
    public void quest() {
        kaserne=true;
    }
    
    public void kaserne() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kas=true;
        shp=false;
        //png
        ZEICHENFENSTER.gibFenster().fuelleRechteck(50,50,400,120,7);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(50,50,400,120);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,64,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,64,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,84,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,84,150,13);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(59,104,150,13,16);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(59,104,150,13);
        ZEICHENFENSTER.gibFenster().zeichneText("Questabgabe",60,75);
        ZEICHENFENSTER.gibFenster().zeichneText("shop",60,95);
        ZEICHENFENSTER.gibFenster().zeichneText("Exit",60,115);
    }  
}

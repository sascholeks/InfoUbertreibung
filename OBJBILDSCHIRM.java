
public class OBJBILDSCHIRM
{
    GRAFIKELEMENTE grafik;
    int[] anz,ausanz,kaeauswahl,anzauswahl;
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
    }
    
    public void hauptstadt() {
        grafik=new GRAFIKELEMENTE();
        ZEICHENFENSTER.gibFenster().loescheAlles();
        
         //png
    }
    
    public void stadtmiene() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
    }
    
}

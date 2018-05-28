
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
    
    public void inventar() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        grafik.zeichneinventar(anz[0],anz[1],anz[2],anz[3],anz[4],anz[5],anz[6],anz[7],anz[8],anz[9],ausanz[0],ausanz[1],ausanz[2],ausanz[3],ausanz[4],kaeauswahl[0],kaeauswahl[1],kaeauswahl[2],kaeauswahl[3],kaeauswahl[4]);  
    }

}

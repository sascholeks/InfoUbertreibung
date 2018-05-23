
public class INVENTAR
{
    GRAFIKELEMENTE grafik;
    int[] anz;
    int[] ausanz;
    int[] kaeauswahl;
    public INVENTAR()
    {
        grafik=new GRAFIKELEMENTE();
        anz=new int[10];
        ausanz=new int[5];
        kaeauswahl=new int[5];
    }
    
    public void invnetar() {
        grafik.zeichneinventar();
    }
    
    public void waehlekaempferaus(int typ,int anz,int platz) {
        
    }   
}

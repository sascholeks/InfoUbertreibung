
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
        for(int a=0;a<5;a++) {
            anz[a]=0;
            ausanz[a]=0;
        }
    }
    
    public void invnetar() {
        grafik.zeichneinventar();
    }
    
    public void waehlekaempferaus(int typ,int anzaus,int platz) {
        if(anz[typ]!=0) {
            if(anz[typ]>anzaus) {
                kaeauswahl[platz]=anzaus;
                anz[typ]=anz[typ]-anzaus;
                grafik.anzahlkaempfer(platz,anzaus);
            }else {
                grafik.kons("nicht genügend Einheiten");
            }
        }else if( anz[typ]==0) {
            grafik.kons("keine Einheiten vorhanden");
        }
    }   
    
    public void ändereAuswahl(int anz,int feld) {
        if(anzauswahl[kaeauswahl[feld]
    }
    
    public void pluskaempfer(int anza,int feld) {
        if(anz[kaeauswahl[feld]]>=anza) {
            if(anza!=0) {
                ausanz[kaeauswahl[feld]]=ausanz[kaeauswahl[feld]]+anza;
                anz[kaeauswahl[feld]]=anz[kaeauswahl[feld]]-anza;
            }else 
            grafik.kons("Du weißt doch selber, dass das keinen Sinn macht");
        }else {
            grafik.kons("nicht genügend Einheiten");
        }
    }
    
    public void minuskaempfer(int anza,int feld) {
        if(ausanz[kaeauswahl[feld]]>anza) {
            if(anza!=0) {
                ausanz[kaeauswahl[feld]]=ausanz[kaeauswahl[feld]]-anza;
                anz[kaeauswahl[feld]]=anz[kaeauswahl[feld]]+anza;
            }else 
            grafik.kons("Du weißt doch selber, dass das keinen Sinn macht");
        }else {
            grafik.kons("zu viele Einheiten ausgewählt");
        }
    }
}





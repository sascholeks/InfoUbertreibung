public class INVENTAR
{
    GRAFIKWELT grafik;
    int[] anz;
    int[] ausanz;
    int[] kaeauswahl;
    int[] anzauswahl;   //siehe unten
    int heiltrankkl=0,heiltrankgr=0,geld,gesap;
    public INVENTAR()
    {
        grafik=new GRAFIKWELT();
        anz=new int[10];
        ausanz=new int[5];
        kaeauswahl=new int[5];
        for(int a=0;a<10;a++) {
            anz[a]=0;
            ausanz[a%5]=0;   
        }  
        geld=0;
    }
    
    public void kaufetruppen(int typ) {
        switch (typ) {
            case 0:
                if(geld>=150) {
                    geld=geld-150;
                    anz[0]=anz[0]+1;
                    grafik.kons("Anz: "+anz[0]); 
                }else {
                    grafik.kons("nicht genug Geld");
                }
                break;
            case 1:
                if(geld>=200) {
                    geld=geld-200;
                    anz[1]=anz[1]+1;
                    grafik.kons("Anz: "+anz[1]); 
                }else {
                    grafik.kons("nicht genug Geld");
                }
                break;
            case 2:
                if(geld>=100) {
                    geld=geld-100;
                    anz[2]=anz[2]+1;
                    grafik.kons("Anz: "+anz[2]); 
                }else {
                    grafik.kons("nicht genug Geld");
                }
                break;
            case 3:
                if(geld>=350) {
                    geld=geld-350;
                    anz[3]=anz[3]+1;
                    grafik.kons("Anz: "+anz[3]); 
                }else {
                    grafik.kons("nicht genug Geld");
                }
                break;
            case 4:
                if(geld>=500) {
                    geld=geld-500;
                    anz[4]=anz[4]+1;
                    grafik.kons("Anz: "+anz[4]); 
                }else {
                    grafik.kons("nicht genug Geld");
                }
                break;
            }
        zeichnegeld();
    }
    
    public void zeichnegeld() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(255,145,100,20,12);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(255,145,100,20);
        ZEICHENFENSTER.gibFenster().zeichneText("Geld: "+geld,260,160);
    }
    
    public void inventar() {
        grafik.zeichneinventar(anz[0],anz[1],anz[2],anz[3],anz[4]);   
        zeichnegeld();  
        zeichneäpfel();
    }
    
    public void zeichneäpfel() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(255,115,100,20,12);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(255,115,100,20);
        ZEICHENFENSTER.gibFenster().zeichneText("Äpfel: "+gesap,260,130);
    }
    
    public void waehlekaempferaus(int typ,int anza,int platz){
        if(anz[typ]>=anza) {
            if(ausanz[platz]==0) {
                anz[typ]=anz[typ]-anza;
                kaeauswahl[platz]=typ;
                ausanz[platz]=anza;
                inventar();
            }else {
                grafik.kons("bereitsbelegt");
            }
        }else {
            grafik.kons("Zu viele Kämpfer ausgewählt");
        }
    }
    
    public void waehlekaempferab(int feld) {
        if(ausanz[feld]>=0) {
            anz[kaeauswahl[feld]]=anz[kaeauswahl[feld]]+ausanz[feld];
            ausanz[feld]=0;
            kaeauswahl[feld]=11;
        }else {
            grafik.kons("zuerst kaempfer auswählen");
        }
    }
    
    public void plusanz(int feld,int anza) {
        if(ausanz[feld]>0) {
            if(anz[kaeauswahl[feld]]>=anza) {
                ausanz[feld]=ausanz[feld]+anza;
                anz[kaeauswahl[feld]]=anz[kaeauswahl[feld]]-anza;
                inventar();
            }else {
                grafik.kons("Du hast nicht soviele Einheiten");
            }
        }else {
            grafik.kons("Du must zuerst Einheiten auswählen");
        }
    }
    
    public void minuskaempfer(int feld,int anza) {
        if(ausanz[feld]>0) {
            if (ausanz[feld]>=anza) {
                ausanz[feld]=ausanz[feld]-anza;
                anz[kaeauswahl[feld]]=anz[kaeauswahl[feld]]+anza;
                inventar();
            }else {
                grafik.kons("Zu viele Einheiten ausgewählt");
            }
        }else {
            grafik.kons("Du must zuerst Einheiten auswählen");
        }
    }
    
    public void plusheiltrank(int gr ,int anz) {
        switch (gr) {
            case 0:
                heiltrankkl=heiltrankkl+anz;
                break;
            case 1:
                heiltrankgr=heiltrankgr+anz;
                break;
            default :
                System.out.println("Ungültige Nummer");
                break;
        }
    }
    
    public void benutzeheiltrank(int gr) {
        switch (gr) {
            case 0:
                heiltrankkl--;
                break;
            case 1:
                heiltrankgr--;
                break;
            default :
                System.out.println("Ungültige Nummer");
                break;
        }
    }
    
    public void fuellestandart() {  //dev
        kaeauswahl[0]=0;
        kaeauswahl[1]=1;
        kaeauswahl[2]=2;
        kaeauswahl[3]=3;
        kaeauswahl[4]=4;
        ausanz[0]=20;
        ausanz[1]=25;
        ausanz[2]=15;
        ausanz[3]=10;
        ausanz[4]=5;
    }
    
}



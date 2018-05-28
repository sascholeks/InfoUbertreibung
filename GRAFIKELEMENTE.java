import java.util.Random;

public class GRAFIKELEMENTE
{
    int ra = 10; //Verschiebung nach rechts
   
    int[] x,y;    //kordinaten der einzelnen [felder](geteilt-/=y & %=x)
    Random r;
    public GRAFIKELEMENTE()
    {
        r=new Random();
        x=new int [5];
        y=new int [5];
        int xyp=20;              //anfangskordinaten

        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }
    }

    public void setTitle(String title){
        ZEICHENFENSTER.gibFenster().setzeTitel(title);
    }

    public void spielfeld() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kampffeld();
        kampfreihenfolge();
        zeichneaktionswahl();
        kons("");
    }

    public void kampffeld() {
        for(int a=0;a<5;a++) {
            for(int b=0;b<5;b++) {
                ZEICHENFENSTER.gibFenster().zeichneRechteck(x[a],y[b],50,50);
            }
        }
    }

    public void kampfreihenfolge() {
        int c=0;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(300,192,71,70,12);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(305+c,197,60,60);
        c=c+60+ra;
        for(int a=0;a<5;a++) {
            ZEICHENFENSTER.gibFenster().zeichneRechteck(305+c,197,60,60);
            c=c+60;
        }
    }

    public void zeichneaktionswahl() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(400,50,200,80,8);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,70,13);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,65,14);
        ZEICHENFENSTER.gibFenster().fuelleKreis(450,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,50,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(550,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,150,20,6);
    }

    public void anzahlreihenfolge(int reihe,int anz) {   
        if(reihe==0) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308,241,22,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe,241,22,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe,252);
        } else {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*reihe+ra,241,22,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe+ra,241,22,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe+ra,252);
        }
    }

    public void anzahl(int feld,int anz) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+35,22,12,11);               
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x[feld%5]+3,y[feld/5]+35,22,12);
        ZEICHENFENSTER.gibFenster().zeichneText(anz+"",x[feld%5]+4,y[feld/5]+46); 
    }

    public void zeichnehindernis(int feld) {
        int zf=r.nextInt(2);
        if(zf==0) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+8,y[feld/5]+12,30,25,7);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+15,y[feld/5]+20,25,20,7);
        }else {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+7,19,40,7);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+15,y[feld/5]+20,25,20,7);
        }
    }

    public void bogenschütze(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+4,5,40,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+9,20,5,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+39,20,5,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+4,5,15,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+24,5,15,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+24,45,3,3);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+45,y[feld/5]+21,3,10,2);
    }

    public void speerkämpfer(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+20,40,4,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+35,y[feld/5]+18,2,10,2);
    }

    public void schildknappe(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,15,2);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,3,f);
    }

    public void ritter(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,5,40,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+17,y[feld/5]+23,15,3,2);
    }

    public void paladin(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,10,40,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+23,45,10,2);
    }

    public void zeichneinfeld(int kaempferID,int feld,int anz) {
        switch(kaempferID) {
            case 0:                //bogenschütze
            bogenschütze(x,y,feld,1);
            anzahl(feld,anz);
            break;
            case 1:                //speerkämpfer
            speerkämpfer(x,y,feld,1);
            anzahl(feld,anz);
            break;
            case 2:                 //schildknappe
            schildknappe(x,y,feld,1);
            anzahl(feld,anz);
            break;
            case 3:                 //ritter
            ritter(x,y,feld,1);
            anzahl(feld,anz);
            break;
            case 4:              //paladin
            paladin(x,y,feld,1);
            anzahl(feld,anz);
            break;
            case 5:                //bogenschütze
            bogenschütze(x,y,feld,4);
            anzahl(feld,anz);
            break;
            case 6:                //speerkämpfer
            speerkämpfer(x,y,feld,4);
            anzahl(feld,anz);
            break;
            case 7:                 //schildknappe
            schildknappe(x,y,feld,4);
            anzahl(feld,anz);
            break;
            case 8:                 //ritter
            ritter(x,y,feld,4);
            anzahl(feld,anz);
            break;
            case 9:              //paladin
            paladin(x,y,feld,4);
            anzahl(feld,anz);
            break;           
        }
    }

    public void zeichenReihenfolgeEinheit(int typ, int x, int f) {
        if(x!=0) {
            x = x*60+ra;
        }
        switch(typ) {
                case 0:                //bogenschütze
                ZEICHENFENSTER.gibFenster().fuelleRechteck(306+x,198,59,59,f);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(312+x,210,5,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(312+x,210,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(312+x,250,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(332+x,215,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(332+x,235,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(312+x,231,50,3,3);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(360+x,228,3,10,2);
                break;
                case 1:                //speerkämpfer
                ZEICHENFENSTER.gibFenster().fuelleRechteck(306+x,198,59,59,f);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(310+x,220,40,4,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(342+x,217,2,10,2);
                break;
                case 2:                 //schildknappe
                ZEICHENFENSTER.gibFenster().fuelleRechteck(306+x,198,59,59,f);
                ZEICHENFENSTER.gibFenster().fuelleKreis(336+x,228,20,2);
                ZEICHENFENSTER.gibFenster().fuelleKreis(336+x,228,5,f);
                break;
                case 3:                 //ritter
                ZEICHENFENSTER.gibFenster().fuelleRechteck(306+x,198,59,59,f);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(332+x,205,5,45,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(327+x,240,15,3,2);
                break;
                case 4:              //paladin
                ZEICHENFENSTER.gibFenster().fuelleRechteck(306+x,198,59,59,f);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(310+x,225,50,10,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(330+x,205,10,50,2);
                break;
            }
    }
    
    public void zeichneKaempferreihenfolge(int typ,int team,int x) {
        switch (team) {
            case 1:
            zeichenReihenfolgeEinheit(typ,x,1);
            break;
            case 2:
            zeichenReihenfolgeEinheit(typ,x,4);
            break;
        }
    }
    
    public void heileauswahl(int gr) {
        if(gr==1) {
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,110,10,4);     //kleine auswahl für größe
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,110,8,1);
        }else if(gr==0) {
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,90,10,4);
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,90,8,1);
        }
    }

    public void zeichneaktionsauswahl(int nr) {
        switch (nr) {
            case 0:
            ZEICHENFENSTER.gibFenster().fuelleKreis(450,100,20,4); 
            ZEICHENFENSTER.gibFenster().fuelleKreis(450,100,18,6);
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,110,10,1);     //kleine auswahl für größe
            ZEICHENFENSTER.gibFenster().fuelleKreis(420,90,10,1);
            break;
            case 1:
            ZEICHENFENSTER.gibFenster().fuelleKreis(500,50,20,4); 
            ZEICHENFENSTER.gibFenster().fuelleKreis(500,50,18,6);
            break;
            case 2:
            ZEICHENFENSTER.gibFenster().fuelleKreis(550,100,20,4);
            ZEICHENFENSTER.gibFenster().fuelleKreis(550,100,18,6);
            break;
            case 3:
            ZEICHENFENSTER.gibFenster().fuelleKreis(500,150,20,4);
            ZEICHENFENSTER.gibFenster().fuelleKreis(500,150,18,6);
            break;
        }
    }

    public void kons(String st) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(275,265,420,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(275,265,420,20);
        ZEICHENFENSTER.gibFenster().zeichneText(st,280,280);
    }

    public void markiereaktuell(int aktuellesfeld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+1,y[aktuellesfeld/5]+1,49,49,7);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+3,y[aktuellesfeld/5]+3,45,45,8);
    }

    public void auswahlfeld(int feld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+1,y[feld/5]+1,49,49,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,8);
    }

    public void loeschemarkierung(int aktuellesfeld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+1,y[aktuellesfeld/5]+1,49,49,8);
    }

    public void markieretod(int x) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*x,225,55,5,6);
    }

    public void zeichnesieg() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
    }

    public void zeichneverloren() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
    }

   
}


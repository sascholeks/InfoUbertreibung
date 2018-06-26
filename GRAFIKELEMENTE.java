import java.util.Random;

public class GRAFIKELEMENTE
{
    GRAFIKWELT weltgr;
    OBJBILDSCHIRM obj;
    int ra = 10; //Verschiebung nach rechts
    int[] x,y;    //kordinaten der einzelnen [felder](geteilt-/=y & %=x)
    Random r;
    public GRAFIKELEMENTE()
    {
        weltgr= new GRAFIKWELT();
        r=new Random();
        obj = new OBJBILDSCHIRM();
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
        img();
        kampffeld();
        kampfreihenfolge();
        zeichneaktionswahl();
    }

    public void img()
    {
        switch(r.nextInt(3)) {
            case 0:
            obj.img(0,0,700,300,3);
            break;
            case 1:
            obj.img(0,0,700,300,4);
            break;
            case 2:
            obj.img(0,0,700,300,5);
            break;
        }  
    }
    
    public void kampffeld() {
        for(int a=0;a<5;a++) {
            for(int b=0;b<5;b++) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[a],y[b],50,50,11);
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
        //ZEICHENFENSTER.gibFenster().fuelleRechteck(400,50,200,80,8);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,70,13);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,65,14);
        ZEICHENFENSTER.gibFenster().fuelleKreis(450,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,50,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(550,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,150,20,6);
        ZEICHENFENSTER.gibFenster().zeichneText("Heilen",430,130);
        ZEICHENFENSTER.gibFenster().zeichneText("Kämpfen",478,80);
        ZEICHENFENSTER.gibFenster().zeichneText("Bewegen",530,130);
        ZEICHENFENSTER.gibFenster().zeichneText("Zug beenden",475,178);
    }

    public void zeichnehinder(int wert,int feld) {
        switch (wert) {

            case 11:
            zeichnehindernis(feld);
            break;
        }
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
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+8,y[feld/5]+12,30,25,7);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+15,y[feld/5]+20,25,20,7);
    }

    public void bogenschütze(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        Bogenschießerer(x[feld%5]+8,y[feld/5]+5);
    }

    public void speerkämpfer(int[] x, int[] y, int feld, int f) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,f);
        sperrsoldat(x[feld%5]+5,y[feld/5]+3);
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
            case 11:              //hinderniss
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+8,y[feld/5]+12,30,25,7);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+15,y[feld/5]+20,25,20,7);
            break;
        }
    }

    public void Bogenschießerer(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+17,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+16,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+18,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+15,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+16,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+17,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+19,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+21,1,4,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+14,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+15,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+16,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+17,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+18,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+20,1,5,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+13,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+15,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+16,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+17,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+19,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+20,1,6,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+14,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+16,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+17,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+19,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+21,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+23,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+26,1,3,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+15,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+16,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+18,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+20,1,3,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+21,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+22,1,3,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+32,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+33,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+17,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+19,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+21,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+22,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+23,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+24,1,3,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+30,1,2,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+33,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+35,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+18,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+20,1,2,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+22,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+23,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+25,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+27,1,3,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+31,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+33,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+14,1,9,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+23,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+25,1,2,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+27,1,3,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+30,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+31,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+34,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+12,1,2,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+14,1,3,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+17,1,5,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+22,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+23,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+25,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+26,1,4,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+31,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+1,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+11,1,2,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+13,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+14,1,2,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+17,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+18,1,3,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+21,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+23,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+24,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+25,1,1,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+26,1,4,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+30,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+31,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+1,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+2,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+11,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+12,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+14,1,1,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+15,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+17,1,3,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+20,1,2,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+22,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+23,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+24,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+27,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+28,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+29,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+31,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+1,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+2,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+3,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+10,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+11,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+13,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+17,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+18,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+20,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+21,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+22,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+27,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+28,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+29,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+30,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16,y+31,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+2,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+3,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+4,1,2,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+9,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+10,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+11,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+13,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+17,1,4,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+21,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+22,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+23,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+27,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+28,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+29,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+31,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+5,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+6,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+8,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+9,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+11,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+12,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+17,1,4,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+21,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+22,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+23,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+25,1,5,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+30,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18,y+31,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+9,1,1,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+10,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+12,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+13,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+17,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+19,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+20,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+21,1,3,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+27,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+28,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+29,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+31,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+10,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+12,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+17,1,5,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+22,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+23,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+25,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+26,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+27,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+28,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+29,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+30,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+31,1,3,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19,y+32,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+11,1,5,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+17,1,5,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+22,1,1,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+23,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+25,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+26,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+28,1,2,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+30,1,1,30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+31,1,3,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20,y+34,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+11,1,3,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+17,1,4,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+21,1,3,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+24,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+27,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+31,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+32,1,2,26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+34,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+12,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+15,1,1,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+17,1,2,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+19,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+20,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+21,1,1,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+22,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+23,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+24,1,1,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+25,1,2,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+27,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+31,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+34,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+13,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+14,1,2,6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+16,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+17,1,5,28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+22,1,1,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+23,1,2,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+25,1,2,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+31,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23,y+35,1,1,25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24,y+22,1,4,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24,y+26,1,1,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24,y+30,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25,y+23,1,5,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25,y+29,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26,y+24,1,5,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26,y+29,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27,y+22,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27,y+26,1,3,29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28,y+21,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28,y+26,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29,y+20,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29,y+25,1,1,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30,y+19,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30,y+24,1,2,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31,y+18,1,1,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31,y+19,1,6,12);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32,y+18,1,1,12);
    }  

    public void sperrsoldat (int x, int y)
    {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+0, y+0, 1, 8, 30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1, y+2, 1, 4, 30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2, y+4, 1, 3, 30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3, y+6, 1, 2, 30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1, y+8, 1, 1, 30);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1, y+6, 1, 2, 6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2, y+7, 1, 3, 6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2, y+10, 1, 3, 0);    
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3, y+11, 1, 7, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4, y+17, 1, 7, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5, y+22, 1, 7, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6, y+28, 1, 5, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7, y+35, 1, 5, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8, y+38, 1, 5, 0);                                                                                
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6, y+32, 1, 2, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7, y+33, 2, 2, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8, y+31, 5, 2, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9, y+30, 3, 1, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9, y+33, 2, 1, 29);              
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+42, 4, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+41, 3, 1, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+40, 3, 1, 29);     
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+40, 2, 2, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+42, 3, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+39, 1, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+37, 1, 3, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+37, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+38, 1, 2, 25);            
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+36, 1, 1, 30);                                                
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+36, 1, 1, 0);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+36, 1, 1, 30);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+36, 1, 1, 0);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+36, 1, 1, 30);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+36, 1, 1, 0);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+36, 1, 1, 30);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+36, 1, 1, 0);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+36, 1, 1, 30);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+36, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+36, 1, 1, 30);                                                                                                                     
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+33, 1, 3, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+33, 3, 3, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+32, 11, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+34, 6, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+33, 1, 3, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+33, 3, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+35, 3, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+33, 2, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+35, 2, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+33, 1, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+34, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+33, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+31, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+31, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+31, 1, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+31, 1, 1, 6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+31, 5, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+31, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+30, 4, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+29, 4, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+28, 4, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+28, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+30, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+29, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+30, 4, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+31, 1, 1, 6);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+31, 5, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+31, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+31, 2, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+28, 1, 4, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+28, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+29, 1, 2, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+29, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+30, 1, 1, 0);                               
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+30, 1, 1, 29);      
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+31, 2, 3, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+33, 1, 1, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+34, 1, 1, 29);                             
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+24, 1, 18, 28);          
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+24, 3, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+41, 3, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+40, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+25, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+25, 2, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+26, 1, 14, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+36, 1, 5, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+35, 1, 6, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+31, 1, 5, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+26, 2, 5, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+32, 1, 3, 6);                                  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+20, 1, 8, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+18, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+17, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+17, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+16, 3, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+17, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+18, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+19, 2, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+17, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+18, 2, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+19, 3, 3, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+20, 2, 3, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+19, 2, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+20, 9, 2, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+21, 1, 6, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+26, 1, 2, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+27, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+28, 2, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+28, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+27, 1, 3, 28);       
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+27, 2, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+22, 1, 5, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+22, 2, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+23, 2, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+22, 3, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+23, 1, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+23, 1, 3, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+26, 1, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+27, 3, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+28, 1, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+29, 4, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+28, 3, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+27, 1, 1, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+20, 1, 8, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+19, 1, 2, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+18, 1, 2, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+17, 2, 2, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+18, 1, 2, 28);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+19, 1, 1, 28);            
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+24, 1, 2, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+23, 3, 4, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+24, 2, 7, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+23, 2, 4, 29);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+25, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+25, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+25, 1, 1, 26);                                     
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+23, 1, 2, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+20, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+14, 1, 7, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+11, 1, 3, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+11, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+9, 1, 2, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+9, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+8, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+7, 2, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+6, 5, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+7, 4, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+8, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+9, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+10, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+11, 1, 1, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+13, 1, 7, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+11, 1, 12, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+10, 1, 14, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+9, 1, 12, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+8, 1, 11, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+7, 2, 11, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+6, 5, 11, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+7, 4, 8, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+8, 1, 6, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+9, 1, 4, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+10, 1, 2, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+15, 4, 2, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+17, 2, 2, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+14, 5, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+15, 1, 1, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+8, 1, 6, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+9, 1, 4, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+10, 1, 2, 25);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+31, 1, 2, 0);        
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+28, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+29, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+30, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+30, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+20, 1, 4, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+21, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+22, 2, 1, 8);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+31, 1, 2, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+21, 1, 5, 26);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+28, 1, 1, 0);  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+29, 1, 1, 0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+22, 1, 1, 27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+22, 2, 1, 28);            
    }  

    public void zeichenReihenfolgeEinheit(int typ, int x, int f,boolean tod) {
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
        if(tod==true) {  //markiere tod
            for(int a=0;a<50;a++) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x+a+308,a+201,4,4,41);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x+307-a+52,201+a,4,4,41);
            }
        }
    }

    public void zeichneKaempferreihenfolge(int typ,int team,int x,boolean tod) {
        switch (team) {
            case 0:
            zeichenReihenfolgeEinheit(typ,x,1,tod);
            break;
            case 1:
            zeichenReihenfolgeEinheit(typ,x,4,tod);
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
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+1,y[aktuellesfeld/5]+1,49,49,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+3,y[aktuellesfeld/5]+3,45,45,8);
    }

    public void auswahlfeld(int feld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+1,y[feld/5]+1,49,49,32);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,8);
    }

    public void loeschemarkierung(int aktuellesfeld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[aktuellesfeld%5]+1,y[aktuellesfeld/5]+1,49,49,8);
    }

    public void zeichnesieg(int anz1,int anz2,int anz3,int anz4,int anz5,int hlkl,int hlgr,int gld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(80,80,400,200,11);
        ZEICHENFENSTER.gibFenster().zeichneText("Verlorene Truppen: ",90,100);;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(95,110,100,50,16);        
        ZEICHENFENSTER.gibFenster().zeichneText("Bogenschützen: ",100,125);
        ZEICHENFENSTER.gibFenster().zeichneText(anz1+"",110,150);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(205,110,100,50,16);     
        ZEICHENFENSTER.gibFenster().zeichneText("Speerkämpfer:",210,125);
        ZEICHENFENSTER.gibFenster().zeichneText(anz2+"",220,150);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(315,110,100,50,16);       
        ZEICHENFENSTER.gibFenster().zeichneText("Schildknappe:",320,125);
        ZEICHENFENSTER.gibFenster().zeichneText(anz3+"",330,150);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(95,170,100,50,16);      
        ZEICHENFENSTER.gibFenster().zeichneText("Ritter:",100,185);
        ZEICHENFENSTER.gibFenster().zeichneText(anz4+"",110,210);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(205,170,100,50,16);    
        ZEICHENFENSTER.gibFenster().zeichneText("Paladin:",210,185);
        ZEICHENFENSTER.gibFenster().zeichneText(anz5+"",220,210);
        ZEICHENFENSTER.gibFenster().zeichneText("Erhaltene Tränke: ",95,240); 
        ZEICHENFENSTER.gibFenster().fuelleRechteck(100,245,110,30,16);
        ZEICHENFENSTER.gibFenster().zeichneText("Kleine Tränke: "+hlkl,105,260);
        ZEICHENFENSTER.gibFenster().zeichneText("Große Tränke: "+hlgr,105,275);
        ZEICHENFENSTER.gibFenster().zeichneText("Erhaltenes Gold: ",250,240);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(255,245,50,20,16);
        ZEICHENFENSTER.gibFenster().zeichneText(gld+"",260,260);
    }

    public void zeichneverloren() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kons("Verloren");
    }

    public void conveyeransicht() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(0,0,800,400,15);
        //weltgr.baum();
        //weltgr.blume1();
        //weltgr.Blume2();
        //weltgr.Blume3();
    }
}
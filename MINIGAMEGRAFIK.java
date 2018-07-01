
public class MINIGAMEGRAFIK
{
    int[] x,y;
    int xypos=20;
    int farbe;
    int zahl;
    int längenverschiebung;  
    public MINIGAMEGRAFIK()
    {
        x=new int[4];
        y=new int[4];
        for(int a=0;a<4;a++) {
            x[a]=xypos;
            y[a]=xypos;
            xypos=xypos+50;
        }
    }

    public void spielfeld() {
        for(int a=0;a<4;a++) {
            for(int b=0;b<4;b++) {
                ZEICHENFENSTER.gibFenster().zeichneRechteck(x[b],y[a],50,50);
            }
        }
    }
   
    public void zeichnekarte(int feld,int wert) {
        switch (wert) {
            case 2:
                farbe=42;
                zahl=2;
                längenverschiebung=0;
                break;
            case 4:
                farbe=43;
                zahl=4;
                längenverschiebung=0;
                break;
            case 8:
                farbe=44;
                zahl=8;
                längenverschiebung=0;
                break;
            case 16:
                farbe=45;
                zahl=16;
                längenverschiebung=2;
                break;
            case 32:
                farbe=46;
                zahl=32;
                längenverschiebung=2;
                break;
            case 64:
                farbe=47;
                zahl=64;
                längenverschiebung=2;
                break;
            case 128:
                farbe=48;
                zahl=128;
                längenverschiebung=6;
                break;
            case 256:
                farbe=49;
                zahl=256;
                längenverschiebung=6;
                break;
            case 512:
                farbe=50;
                zahl=512;
                längenverschiebung=6;
                break;
            case 1024:
                farbe=51;
                zahl=1024;
                längenverschiebung=10;
                break;
            case 2048:
                farbe=52;
                zahl=2048;
                längenverschiebung=10;
                break;
        }
        if(wert!=0) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%4]+1,y[feld/4]+1,49,49,farbe);
            ZEICHENFENSTER.gibFenster().zeichneText(zahl+"",x[feld%4]+20-längenverschiebung,y[feld/4]+30);
        }else if(wert==0) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%4]+1,y[feld/4]+1,49,49,8);
        }
    }
}

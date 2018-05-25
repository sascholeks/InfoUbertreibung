
public class GRAFIKWELT
{
    int x[],y[];
    public GRAFIKWELT()
    {
        x=new int [7];
        y=new int [7];
        int xyp=5;
        for(int a=0;a<7;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+40;
        }
    }
    
    public void zeichnerahmen() {
        for(int a=0;a<7;a++) {
            for(int b=0;b<7;b++) {
                ZEICHENFENSTER.gibFenster().zeichneRechteck(x[a],y[b],40,40);
            }
        }
    }

    public void zeichenspieler(int feld) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+5,y[feld/7]+25,30,10,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+10,y[feld/7]+10,20,20,6);
    }
    
    public void kons(String st) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(275,265,420,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(275,265,420,20);
        ZEICHENFENSTER.gibFenster().zeichneText(st,280,280);
    }
}


public class GRAFIKWELTTEST
{
    int[] x,y;
    public GRAFIKWELTTEST()
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

    public void zeichne (int nr) 
    {
        int x=1;
        int y=1;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
        switch (nr) {
            case 0:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,1);
                break;
            case 1:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,2);
                break;     
            case 2:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,3);
                break;
            case 3:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,4);
                break;
            case 4:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,5);
                break;
            case 5:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,6);
                break;    
            case 6:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,7);
                break;    
            case 7:
                ZEICHENFENSTER.gibFenster().zeichneRechteck(this.x[x]+1,this.y[y]+1,39,39); //da 8 weis ist und nicht von weißem kries unterscheiden
                break;
            case 8:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,9);
                break;
            case 9:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,10);
                break;
            case 10:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,11);
                break;
            case 11:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,12);
                break;
            case 12:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,13);
                break;
            case 13:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,1);
                break;
            case 14:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,2);
                break;
            case 15:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,3);
                break;
            case 16:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,4);
                break;
            case 17:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,5);
                break;
            case 18:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,6);
                break;
            case 19:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,7);
                break;
            case 20:
                ZEICHENFENSTER.gibFenster().zeichneKreis(this.x[x]+20,this.y[y]+20,19);   //da 8 weis ist und nicht von weißem rechteck zu unterscheiden
                break;
            case 21:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,9);
                break;
            case 22:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,10);
                break;
            case 23:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,11);
                break;
            case 24:
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,12);
                break;
            case 25:  //berge
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+5,35,35,12);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+10,25,25,1);
                break;
            case 26:  //startpos  //schloss/hauptstadt
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,18,12);
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,15,1);
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,12,2);
                break;
            case 27:  //zielpos  //miene
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,18,1);
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,10,8);
                break;
            case 28:  //weg
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+3,30,30,2);
                break;
            case 100:  //monster  
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,3,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+10,10,3,5);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+10,10,3,5);
                break;
        }
    }
    
}

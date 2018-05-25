
public class WELTALGO
{
    int[] x;
    int[] y;
    
    int xp=1;
    int yp=1;
    public WELTALGO()
    {
        x=new int[7];
        y=new int[7];
        for(int a=0;a<7;a++) {
            x[a]=xp;
            xp=xp+50;
            y[a]=yp;
            yp=yp+50;
        }
        for(int a=0;a<7;a++) {
            for(int b=0;b<7;b++) {
                ZEICHENFENSTER.gibFenster().zeichneRechteck(x[a],y[b],50,50);
            }
        }
    }

    public void zeichneobj(int sx,int sy,int zx,int zy)       //startx/y zielx/y
    {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[sx]+11,y[sy]+11,30,30,11);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x[zx]+25,y[zy]+25,24,7);
    }
    
    public void setzeWeg(int xpos,int ypos,int farbn) {
        ZEICHENFENSTER.gibFenster().fuelleKreis(x[xpos]+25,y[ypos]+25,15,farbn);
        farbn++;
    }
    
    public void loesche(int  fx,int fy) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[fx]+1,y[fy]+1,48,48,8);
    }
    
    public void testeRand(int r,int xper,int yper) {
        switch (r) {
            case 0:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xper]+3,y[yper]+3,5,44,4);
                break;
            case 1:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xper]+3,y[yper]+3,44,5,4);
                break;
            case 2:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xper]+42,y[yper]+3,5,44,4);
                break;
            case 3:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xper]+3,y[yper]+42,44,5,4);
                break;
        }
    }
    
    public void testebenutzt(int r,int xpas,int ypas) {
        switch(r) {
            case 0:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xpas]+3,y[ypas]+3,5,44,6);
                break;
            case 1:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xpas]+3,y[ypas]+3,44,5,6);
                break;
            case 2:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xpas]+42,y[ypas]+3,5,44,6);
                break;
            case 3:
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xpas]+3,y[ypas]+42,44,5,6);
                break;
        }
    }
    
    public void zeichneGebiet(int xd, int yd,int farbn) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[xd]+1,y[yd]+1,48,48,farbn);
    }
}

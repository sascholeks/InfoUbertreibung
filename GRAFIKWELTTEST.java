
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
            blume1(this.x[x]+3,this.y[y]+25);
            break;
            case 1:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,2);
            break;     
            case 2:

            Blume2(this.x[x]+5,this.y[y]+21);
            break;
            case 3:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,4);
            break;
            case 4:
            blume1(this.x[x]+28,this.y[y]+19);
            break;
            case 5:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,6);
            break;    
            case 6:
            Blume3(this.x[x]+17,this.y[y]+22);
            break;    
            case 7:
            ZEICHENFENSTER.gibFenster().zeichneRechteck(this.x[x]+1,this.y[y]+1,39,39); //da 8 weis ist und nicht von weißem kries unterscheiden
            break;
            case 8:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,9);
            break;
            case 9:
            Blume3(this.x[x]+6,this.y[y]+18);
            break;
            case 10:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,11);
            break;
            case 11:

            Blume2(this.x[x]+12,this.y[y]+23);
            break;
            case 12:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,13);
            break;
            case 13:
            blume1(this.x[x]+0,this.y[y]+0);
            break;
            case 14:

            Blume2(this.x[x]+2,this.y[y]+15);
            break;
            case 15:
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,3);
            break;
            case 16:

            Blume3(this.x[x]+11,this.y[y]+25);
            break;
            case 17:
            blume1(this.x[x]+20,this.y[y]+8);
            break;
            case 18:
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,6);
            break;
            case 19:

            Blume3(this.x[x]+3,this.y[y]+26);
            break;
            case 20:
            blume1(this.x[x]+4,this.y[y]+20);
            break;
            case 21:
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,9);
            break;
            case 22:

            Blume3(this.x[x]+10,this.y[y]+19);
            break;
            case 23:
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,19,11);
            break;
            case 24:
            blume1(this.x[x]+20,this.y[y]+16);
            break;
            case 25:  //berge
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+2,2,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+3,4,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+4,5,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+5,7,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+6,this.y[y]+6,10,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+7,11,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+7,3,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+7,1,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+8,12,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+8,1,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+9,13,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+10,13,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+11,16,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+12,22,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+13,29,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+13,4,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+13,6,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+14,32,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+14,7,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+14,7,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+15,32,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+16,34,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+17,34,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+18,36,1,24);

            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+39,39,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+38,37,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+37,36,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+36,34,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+35,34,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+34,32,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+33,31,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+33,5,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+22,this.y[y]+33,8,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+6,this.y[y]+32,29,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+6,this.y[y]+32,12,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+22,this.y[y]+32,13,1,24);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+31,28,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+30,27,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+29,25,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+29,25,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+28,24,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+27,22,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+26,20,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+25,19,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+24,18,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+23,17,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+22,15,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+21,15,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+20,14,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+13,this.y[y]+19,13,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+18,12,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+13,this.y[y]+17,10,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+15,this.y[y]+17,1,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+21,this.y[y]+17,1,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+15,this.y[y]+16,9,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+15,this.y[y]+16,2,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+21,this.y[y]+16,1,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+16,this.y[y]+15,8,1,23);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+16,this.y[y]+15,4,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+18,this.y[y]+15,4,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+17,this.y[y]+14,7,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+13,5,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+21,this.y[y]+12,3,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+22,this.y[y]+11,2,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+22,this.y[y]+10,2,1,22);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+23,this.y[y]+9,1,1,22);
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

    public void blume1(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+0,2,1,18);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+1,5,1,18);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+0,y+2,6,1,18);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+0,y+3,5,1,18);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+4,1,1,17);

        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+4,2,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+4,1,7,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+0,y+8,2,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+8,1,2,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+10,3,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+9,2,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+8,2,1,17);
    }  

    public void Blume2(int x,int y){
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y,1,3,21);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+1,1,3,21);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y,1,3,21);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+4,1,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+4,1,5,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+5,1,6,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+7,1,4,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+4,1,9,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+6,1,5,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+4,1,6,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+5,1,3,17);
    }

    public void Blume3(int x,int y){
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+2,1,1,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+1,1,4,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y,1,4,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+5,1,4,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y,1,4,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+5,1,1,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+8,1,4,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+1,1,3,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+1,1,1,19);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+3,1,1,19);

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
    }

    public void Stein(int x, int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9,y,5,1,37);    //schwarzgrau
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+1,7,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+2,11,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+3,13,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+4,15,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+5,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+6,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+7,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+8,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+9,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+10,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+11,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+12,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+4,y+13,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+14,18,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+15,19,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+16,22,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+17,23,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+18,24,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+19,24,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+20,24,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+21,25,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+22,24,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+22,22,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+23,20,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+24,18,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1,y+25,16,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+26,7,1,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+27,5,1,37);

        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+4,2,2,37);     //dunkelgrau
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+5,3,2,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6,y+6,9,1,37);
    }
}


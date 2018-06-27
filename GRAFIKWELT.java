
import java.util.Timer;
import java.util.TimerTask;
public class GRAFIKWELT
{
    int x[],y[];
    String str2="",str3="",str4="";
    String sh1,sh2,sh3;
    int i=0;
    int hlp1=0;
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

    public void textfeld(String text) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(320,20,200,20,7);
    }

    public void kons(String st) { 
        if(i>=1) {   
            kons2(str2);
        }
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,265,400,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,265,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(st,295,280); 
        if(i==0)  {
            i=1; 
        } 
        str2=st;
    }
    
    public void cheat(String cheat) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,165,400,20,4);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,165,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(cheat,295,180); 
    }

    public void kons2(String str2) {  
        if(i>=2) {       
            kons3(str3);
        }
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,235,400,20,33);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,235,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(str2,295,250);
        if(i==1)  {
            i=2; 
        } 
        str3=str2;
    }

    public void kons3(String str3) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,205,400,20,34);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,205,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(str3,295,220);
        str4 = str3; //Prinzip
        i=3; //aus Prinzip :)
    }

    public void loeschekons() {
        for(int a=0;a<3;a++) {
            kons("");
        }
        i=0;
    }

    public void weltteil(int x, int y,int nr) {
        switch (nr) {
            case 0:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+3,this.y[y]+25);
            break;
            case 1:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+32,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+31,this.y[y]+16,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+34,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+33,this.y[y]+16,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+33,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+4,this.y[y]+33,1,1,17);
            break;     
            case 2:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume2(this.x[x]+5,this.y[y]+21);
            busch(this.x[x]+13,this.y[y]+7);
            break;
            case 3:                         
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);       //wald
            baum(this.x[x]-1,this.y[y]+1);
            baum(this.x[x]+20,this.y[y]+7);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+18,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+17,this.y[y]+33,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+19,this.y[y]+33,1,1,17);
            break;
            case 4:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+28,this.y[y]+19);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+24,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+23,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+24,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+23,1,1,17);
            break;
            case 5:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);   //wald
            baum(this.x[x]+2,this.y[y]+9);
            break;    
            case 6:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,39);  //wasser
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+16,this.y[y]+17,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+18,this.y[y]+16,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+15,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+23,this.y[y]+16,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+25,this.y[y]+17,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+16,this.y[y]+20,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+18,this.y[y]+19,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+18,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+23,this.y[y]+19,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+25,this.y[y]+20,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+17,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+16,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+15,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+16,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+17,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+25,this.y[y]+20,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+20,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+19,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+18,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+19,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+20,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+28,this.y[y]+39,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+30,this.y[y]+38,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+32,this.y[y]+37,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+35,this.y[y]+38,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+37,this.y[y]+39,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+17,this.y[y]+39,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+19,this.y[y]+38,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+21,this.y[y]+37,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+24,this.y[y]+38,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+26,this.y[y]+39,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+28,this.y[y]+3,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+30,this.y[y]+2,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+32,this.y[y]+1,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+35,this.y[y]+2,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+37,this.y[y]+3,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+17,this.y[y]+3,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+19,this.y[y]+2,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+21,this.y[y]+1,3,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+24,this.y[y]+2,2,1,1);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+26,this.y[y]+3,2,1,1);
            break;    
            case 7:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            busch(this.x[x]+6,this.y[y]+20);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+28,this.y[y]+18,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+27,this.y[y]+17,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+30,this.y[y]+20,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+29,this.y[y]+19,1,1,17);
            break;
            case 8:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+26,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+25,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+26,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+25,1,1,17);
            break;
            case 9:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume3(this.x[x]+6,this.y[y]+18);
            busch(this.x[x]+18,this.y[y]+30);
            break;
            case 10:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+2,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+19,this.y[y]+1,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+20,this.y[y]+2,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+19,this.y[y]+1,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+32,this.y[y]+22,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+31,this.y[y]+21,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+34,this.y[y]+22,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+33,this.y[y]+21,1,1,17);
            break;
            case 11:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);   //wald
            baum(this.x[x]+16,this.y[y]+3);
            baum(this.x[x],this.y[y]+8);
            busch(this.x[x]+18,this.y[y]+30);
            break;
            case 12:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+33,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+34,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+13,this.y[y]+33,1,1,17);
            break;
            case 13:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+0,this.y[y]+0);
            break;
            case 14:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume2(this.x[x]+2,this.y[y]+15);
            break;
            case 15:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+16,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+16,1,1,17);
            break;
            case 16:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume3(this.x[x]+11,this.y[y]+25);
            break;
            case 17:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+20,this.y[y]+8);
            break;
            case 18:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+6,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+6,this.y[y]+5,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+8,this.y[y]+6,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+7,this.y[y]+5,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+26,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+25,this.y[y]+16,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+26,this.y[y]+17,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+25,this.y[y]+16,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+29,this.y[y]+35,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+28,this.y[y]+34,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+30,this.y[y]+35,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+29,this.y[y]+34,1,1,17);
            break;
            case 19:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume3(this.x[x]+3,this.y[y]+26);
            break;
            case 20:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+4,this.y[y]+20);
            break;
            case 21:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+12,this.y[y]+18);
            break;
            case 22:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume3(this.x[x]+10,this.y[y]+19);
            break;
            case 23:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            Blume2(this.x[x]+5,this.y[y]+4);
            Blume3(this.x[x]+26,this.y[y]+14);
            break;
            case 24:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            blume1(this.x[x]+20,this.y[y]+16);
            break;
            case 25:  //berge
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
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
            case 26:  //hauptstadt
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,18,12);
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,15,1);
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,12,2);
            break;
            case 27:    //kaserne
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,18,1);
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,10,8);
            break;
            case 28:  //links oben
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,17,12,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+28,this.y[y]+24,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+27,this.y[y]+23,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+30,this.y[y]+24,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+29,this.y[y]+23,1,1,17);
            break;
            case 29:  //links rechts
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,39,12,31);
            break;
            case 30:  //links unten
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,19,12,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
            break;
            case 31:  //oben links
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,25,12,31);
            break;
            case 32:  //oben rechts
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
            break;
            case 33:  //oben unten  
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,39,31);
            break;
            case 34:  //rechts links
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,39,12,31);
            break;
            case 35:  //rechts oben
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,23,31);
            break;
            case 36:  //rechts unten
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
            break;
            case 37:  //unten links
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,25,12,31);
            break;
            case 38:  //unten oben
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,39,31);
            break;
            case 39:  //unten rechts
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+10,this.y[y]+4,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+9,this.y[y]+3,1,1,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+4,1,3,17);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+11,this.y[y]+3,1,1,17);
            break;
            case 40:   //dungeon
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            dungeon(this.x[x]+2,this.y[y]+6);
            break;
            case 42:   //hafen
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+5,this.y[y]+5,30,30,4);
            break;
            case 100:  //monster  
            ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,3,4);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+10,10,3,5);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+20,10,3,5);
            break;
            case 101:  //monsterzerstörung
            ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+2,this.y[y]+2,35,35,22);
        }
    }
    
    public void zeichneufer(int feld,int richtung) {
        switch(richtung) {
            case 0:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+1,y[feld/7]+1,1,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+2,y[feld/7]+2,1,37,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+3,y[feld/7]+5,1,8,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+3,y[feld/7]+25,1,13,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+4,y[feld/7]+29,1,6,15);
            break;
            case 1:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+1,y[feld/7]+1,39,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+2,y[feld/7]+2,37,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+17,y[feld/7]+3,17,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+3,y[feld/7]+1,4,3,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+21,y[feld/7]+4,11,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+25,y[feld/7]+5,7,1,15);
            break;
            case 2:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+39,y[feld/7]+1,1,39,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+38,y[feld/7]+2,1,37,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+37,y[feld/7]+2,1,4,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+37,y[feld/7]+14,1,12,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+36,y[feld/7]+18,1,5,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+37,y[feld/7]+31,1,4,15);
            break;
            case 3:
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+1,y[feld/7]+39,39,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+2,y[feld/7]+38,37,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+3,y[feld/7]+37,6,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+13,y[feld/7]+37,14,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+30,y[feld/7]+37,4,1,15);
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+16,y[feld/7]+36,8,1,15);
        }
    }

    public void loescheansicht() {
        ZEICHENFENSTER.gibFenster().loescheAlles();
    }  

    public void zeichnespieler(int feld) {
        Held(x[feld%7]-5,y[feld/7]-10);
    }

    public void zeichneinventar(int anz0,int anz1,int anz2,int anz3,int anz4) {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        ZEICHENFENSTER.gibFenster().zeichneRechteck(40,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(40,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz0+"",42,102);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(41,41,49,49,1);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(45,45,5,40,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(45,50,20,5,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(45,80,20,5,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(65,45,5,15,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(65,65,5,15,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(44,65,45,3,3);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(86,61,3,10,2);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(90,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(90,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz1+"",92,102);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(91,41,49,49,1);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(95,63,40,4,2);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(127,59,2,10,2);    
        ZEICHENFENSTER.gibFenster().zeichneRechteck(140,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(140,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz2+"",142,102);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(141,41,49,49,1);
        ZEICHENFENSTER.gibFenster().fuelleKreis(166,65,20,2);
        ZEICHENFENSTER.gibFenster().fuelleKreis(166,65,5,1);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(190,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(190,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz3+"",192,102);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(240,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(240,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz4+"",242,102); 
    }
    
    public void boot(int feld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[feld%7]+9,this.y[feld/7]+30,25,8,40);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(this.x[feld%7]+9,this.y[feld/7]+30,25,8);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[feld%7]+5,this.y[feld/7]+25,33,6,40);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(this.x[feld%7]+5,this.y[feld/7]+25,33,6);
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
    
    public void busch(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3,y+7,5,2,35);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+3,y+3,4,17);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+7,y+2,5,17);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+6,y+2,5,17);
    }
    
    public void baum(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10,y+10,5,20,35);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+8,y+6,5,17);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+12,y+5,6,17);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+14,y+8,6,17);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+11,y+8,7,17);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+10,2,2,4);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13,y+3,2,2,4);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8,y+8,2,2,4);    
    }
    
    public void dungeon(int x ,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+5,7,25,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5,y+10,25,20,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30,y+5,7,25,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14,y+13,9,17,7);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15,y+14,7,16,0);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+5,7,3,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30,y+5,7,3,36);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2,y+18,3,3,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31,y+18,3,3,37);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7,y+7,5,5,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17,y+7,5,5,27);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26,y+7,4,5,27);
    }

    public void kordinatenanzeige(String kord) {  
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,10,54,14,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,10,54,14);
        ZEICHENFENSTER.gibFenster().zeichneText(kord,292,22);
    }
    
    public void ortsanzeige(String kord,String name) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(360,10,134,14,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(360,10,134,14);
        ZEICHENFENSTER.gibFenster().zeichneText(name+":  "+kord,362,22);
    }
    
    public void loescheort() {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(359,9,137,17,8);
    }

    public void questanzeige(String kords) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,28,150,14,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,28,150,14);
        ZEICHENFENSTER.gibFenster().zeichneText(kords,292,40);
    }

    public void konsz(String st) { 
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,265,400,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,265,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(st,295,280); 
    }

    public void konsz2(String str2) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,235,400,20,33);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,235,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(str2,295,250);
    }

    public void konsz3(String str3) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(290,205,400,20,34);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,205,400,20);
        ZEICHENFENSTER.gibFenster().zeichneText(str3,295,220);
    }
    
    public void Held(int x, int y)
    {
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+0, y+4, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+1, y+3, 12, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+2, y+2, 3, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+3, y+4, 10, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6, y+5, 5, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7, y+6, 4, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6, y+7, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8, y+0, 2, 3, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+1, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+2, 3, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+1, 5, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+0, 4, 1, 28);                     
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9, y+7, 1, 2, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+10, 3, 3, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+8, 4, 2, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+6, y+9, 4, 2, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+7, y+11, 4, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+8, y+12, 2, 2, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9, y+14, 1, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+13, 5, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+12, 1, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+12, 4, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+11, 4, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+10, 2, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+10, 1, 1, 26);           
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+5, y+10, 1, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+8, 1, 1, 27);                       
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+14, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+15, 3, 4, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+9, y+16, 5, 2, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+16, 1, 2, 6);     
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+19, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+20, 3, 4, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+10, y+21, 5, 2, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+21, 1, 2, 6);      
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+24, 1, 1, 0);           
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+25, 3, 4, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+11, y+26, 5, 2, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+26, 1, 2, 6);      
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+29, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+30, 3, 4, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12, y+31, 5, 2, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+34, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+14, y+35, 3, 4, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+36, 5, 2, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+15, y+36, 1, 2, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+40, 1, 2, 0);           
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+13, y+30, 3, 3, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+30, 1, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+33, 1, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+31, 2, 3, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+32, 2, 3, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+33, 1, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+34, 3, 2, 29);         
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+45, 4, 1, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+44, 3, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+43, 3, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+42, 1, 1, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+40, 1, 3, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+40, 1, 3, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+41, 1, 2, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+43, 3, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+44, 3, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+45, 3, 1, 25);       
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+39, 1, 1, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+39, 1, 1, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+39, 1, 1, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+39, 1, 1, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+39, 1, 1, 30);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+39, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+39, 1, 1, 30);          
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+36, 13, 3, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+36, 1, 3, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+36, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+36, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+36, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+38, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+38, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+38, 1, 1, 6);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+37, 1, 2, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+36, 2, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+35, 7, 1, 28);    
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+34, 1, 2, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+33, 2, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+32, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+31, 5, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+32, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+32, 4, 1, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+23, y+33, 3, 1, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+34, 2, 1, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+34, 6, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+34, 2, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+28, y+33, 3, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+33, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+34, y+32, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+35, y+31, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+36, y+31, 1, 4, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+35, y+32, 1, 2, 25);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+37, y+32, 4, 3, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+39, y+31, 1, 1, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+40, y+30, 1, 2, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+41, y+34, 1, 1, 29);     
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+22, 1, 9, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+20, 1, 2, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+19, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+22, 5, 9, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+24, 2, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+25, 1, 5, 8);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+29, 1, 8, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+16, y+30, 1, 1, 8);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+30, 1, 5, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+17, y+31, 1, 1, 28); 
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+18, y+31, 2, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+31, 1, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+24, y+33, 1, 3, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+34, 1, 3, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+20, y+20, 14, 4, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+20, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+20, 1, 1, 0); 
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+22, 3, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+23, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+34, y+21, 1, 3, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+16, 3, 3, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+15, 1, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+31, y+17, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+18, 12, 2, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+21, y+16, 3, 2, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+15, 1, 1, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+22, y+17, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+35, y+25, 1, 6, 27);      
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+32, 3, 1, 28);       
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+31, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+30, 3, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+29, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+25, y+25, 1, 4, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+26, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+24, 9, 2, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+24, 1, 2, 8);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+24, 1, 2, 8);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+34, y+26, 1, 5, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+30, 1, 1, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+32, y+30, 1, 3, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+30, 2, 4, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+30, y+31, 2, 1, 26);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+26, y+27, 1, 2, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+27, y+26, 7, 4, 29);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+29, y+28, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+33, y+28, 1, 1, 0);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+19, y+37, 1, 3, 28);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+34, y+33, 1, 3, 27);
           ZEICHENFENSTER.gibFenster().fuelleRechteck(x+35, y+34, 1, 3, 27);
           
           
    }
}


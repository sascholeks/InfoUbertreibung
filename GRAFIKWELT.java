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

    public void textfeld(String text) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(320,20,200,20,7);
    }

    public void kons(String st) {   
        ZEICHENFENSTER.gibFenster().fuelleRechteck(275,265,420,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(275,265,420,20);
        ZEICHENFENSTER.gibFenster().zeichneText(st,280,280);
    }

    public void weltteil(int x, int y,int nr) {
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
                Blume3(this.x[x]+17,this.y[y]+23);
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
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+1,39,39,12);
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
            case 28:  //links oben
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,17,12,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
                break;
            case 29:  //links rechts
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,39,12,31);
                break;
            case 30:  //links unten
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,19,12,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
                break;
            case 31:  //oben links
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,25,12,31);
                break;
            case 32:  //oben rechts
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,25,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
                break;
            case 33:  //oben unten
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,39,31);
                break;
            case 34:  //rechts links
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,39,12,31);
                break;
            case 35:  //rechts oben
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,23,31);
                break;
            case 36:  //rechts unten
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
                break;
            case 37:  //unten links
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+1,this.y[y]+14,25,12,31);
                break;
            case 38:  //unten oben
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+1,12,39,31);
                break;
            case 39:  //unten rechts
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,12,26,31);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+14,this.y[y]+14,26,12,31);
                break;
            case 100:  //monster  
                ZEICHENFENSTER.gibFenster().fuelleKreis(this.x[x]+20,this.y[y]+20,3,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+3,this.y[y]+10,10,3,5);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(this.x[x]+12,this.y[y]+10,10,3,5);
                break;
        }
    }

    public void loescheansicht() {
        for(int a=0;a<7;a++) {
            for(int b=0;b<7;b++) {
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[b]+1,y[a]+1,39,39,8);
            }
        }
    }  

    public void zeichnespieler(int feld) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+5,y[feld/7]+25,30,10,1);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%7]+10,y[feld/7]+10,20,20,6);
    }

    public void zeichneinventar(int anz0,int anz1,int anz2,int anz3,int anz4,int anz5,int anz6,int anz7,int anz8,int anz9,int anz10,int anz11,int anz12,int anz13,int anz14,int aus0,int aus1,int aus2,int aus3,int aus4) {
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

        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(290,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz5+"",292,102);

        ZEICHENFENSTER.gibFenster().zeichneRechteck(340,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(340,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz6+"",342,102);

        ZEICHENFENSTER.gibFenster().zeichneRechteck(390,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(390,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz7+"",392,102);

        ZEICHENFENSTER.gibFenster().zeichneRechteck(440,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(440,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz8+"",442,102);

        ZEICHENFENSTER.gibFenster().zeichneRechteck(490,40,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(490,90,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz9+"",492,102);

        ZEICHENFENSTER.gibFenster().zeichneRechteck(75,140,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(125,140,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(175,140,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(225,140,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(275,140,50,50);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(75,190,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz10+"",77,202);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(125,190,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz11+"",127,202);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(175,190,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz12+"",177,202);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(225,190,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz13+"",227,202);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(275,190,50,14);
        ZEICHENFENSTER.gibFenster().zeichneText(anz14+"",277,202);    
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
}


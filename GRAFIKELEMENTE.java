

public class GRAFIKELEMENTE
{
    int[] x,y;    //kordinaten der einzelnen [felder](geteilt-/=y & %=x)
    
    public GRAFIKELEMENTE()
    {
        x=new int [5];
        y=new int [5];
        int xyp=20;              //anfangskordinaten 
        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }
    }
    
    public void spielfeld() {
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
        for(int a=0;a<6;a++) {
            ZEICHENFENSTER.gibFenster().zeichneRechteck(305+c,197,60,60);
            c=c+60;
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
    
    public void zeichneaktionswahl() {
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,70,13);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,100,65,14);
        ZEICHENFENSTER.gibFenster().fuelleKreis(450,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,50,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(550,100,20,6);
        ZEICHENFENSTER.gibFenster().fuelleKreis(500,150,20,6);
    }
    
    public void anzahlreihenfolge(int reihe,int anz) {   
        if(anz>999 && anz<10000) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*reihe,241,29,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe,241,29,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe,252);
        }else if(anz>99 && anz<1000) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*reihe,241,22,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe,241,22,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe,252);
        }else if(anz>9 && anz<100) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*reihe,241,15,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe,241,15,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe,252);
        }else if(anz>0 && anz<10) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(308+60*reihe,241,8,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(308+60*reihe,241,8,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",309+60*reihe,252);
        }
        
    }
    
    public void anzahl(int feld,int anz) {
        if(anz>999 && anz<10000) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+35,29,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(x[feld%5]+3,y[feld/5]+35,29,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",x[feld%5]+4,y[feld/5]+46);
        }else if(anz>99 && anz<1000) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+35,22,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(x[feld%5]+3,y[feld/5]+35,22,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",x[feld%5]+4,y[feld/5]+46);
        }else if(anz>9 &&anz<100) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+35,15,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(x[feld%5]+3,y[feld/5]+35,15,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",x[feld%5]+4,y[feld/5]+46);
        }else if(anz>0 && anz<10) {
            ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+35,8,12,11);               
            ZEICHENFENSTER.gibFenster().zeichneRechteck(x[feld%5]+3,y[feld/5]+35,8,12);
            ZEICHENFENSTER.gibFenster().zeichneText(anz+"",x[feld%5]+4,y[feld/5]+46);
        }
    }
     
    public void zeichneinfeld(int kaempferID,int feld,int anz) {
        switch(kaempferID) {
            case 0:                //bogenschütze
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,1);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+4,5,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+9,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+39,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+4,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+24,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+24,45,3,3);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+45,y[feld/5]+21,3,10,2);
                anzahl(feld,anz);
                break;
            case 1:                //speerkämpfer
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,1);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+20,40,4,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+35,y[feld/5]+18,2,10,2);
                anzahl(feld,anz);
                break;
            case 2:                 //schildknappe
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,1);
                ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,15,2);
                ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,3,1);
                anzahl(feld,anz);
                break;
            case 3:                 //ritter
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,1);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,5,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+17,y[feld/5]+23,15,3,2);
                anzahl(feld,anz);
                break;
            case 4:              //paladin
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,1);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,10,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+23,45,10,2);
                anzahl(feld,anz);
                break;
            case 5:                //bogenschütze
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+4,5,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+9,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+39,20,5,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+4,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+24,y[feld/5]+24,5,15,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+24,45,3,3);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+45,y[feld/5]+21,3,10,2);
                anzahl(feld,anz);
                break;
            case 6:                //speerkämpfer
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+4,y[feld/5]+20,40,4,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+35,y[feld/5]+18,2,10,2);
                anzahl(feld,anz);
                break;
            case 7:                 //schildknappe
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,4);
                ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,15,2);
                ZEICHENFENSTER.gibFenster().fuelleKreis(x[feld%5]+25,y[feld/5]+25,3,4);
                anzahl(feld,anz);
                break;
            case 8:                 //ritter
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,5,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+17,y[feld/5]+23,15,3,2);
                anzahl(feld,anz);
                break;
            case 9:              //paladin
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+3,45,45,4);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+23,y[feld/5]+3,10,40,2);
                ZEICHENFENSTER.gibFenster().fuelleRechteck(x[feld%5]+3,y[feld/5]+23,45,10,2);
                anzahl(feld,anz);
                break;           
        }
    }
    
    
    public void zeichneKaempferreihenfolge(int typ,int team,int x) {
        switch (team) {
            case 1:
                switch(typ) {
                    case 0:                //bogenschütze
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,1);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,210,5,40,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,210,20,5,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,250,20,5,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,215,5,15,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,235,5,15,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,231,50,3,3);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(360+60*x,228,3,10,2);
                        break;
                    case 1:                //speerkämpfer
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,1);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(310+60*x,220,40,4,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(342+60*x,217,2,10,2);
                        break;
                    case 2:                 //schildknappe
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,1);
                        ZEICHENFENSTER.gibFenster().fuelleKreis(336+60*x,228,20,2);
                        ZEICHENFENSTER.gibFenster().fuelleKreis(336+60*x,228,5,1);
                        break;
                    case 3:                 //ritter
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,1);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,205,5,45,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(327+60*x,240,15,3,2);
                        break;
                    case 4:              //paladin
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,1);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(310+60*x,225,50,10,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(330+60*x,205,10,50,2);
                        break;
                }
                break;
            case 2:
                switch(typ) {
                    case 0:                           //bogenschütze
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,4);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,210,5,40,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,210,20,5,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,250,20,5,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,215,5,15,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,235,5,15,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(312+60*x,231,50,3,3);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(360+60*x,228,3,10,2);
                        break;
                    case 1:                                   //speerkämpfer
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,4);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(310+60*x,220,40,4,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(342+60*x,217,2,10,2);
                        break;
                    case 2:                               //schildknappe
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,4);
                        ZEICHENFENSTER.gibFenster().fuelleKreis(336+60*x,228,20,2);
                        ZEICHENFENSTER.gibFenster().fuelleKreis(336+60*x,228,5,4);
                        break;
                    case 3:                        //ritter
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,4);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(332+60*x,205,5,45,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(327+60*x,240,15,3,2);
                        break;
                    case 4:                       //paladin
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(306+60*x,198,59,59,4);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(310+60*x,225,50,10,2);
                        ZEICHENFENSTER.gibFenster().fuelleRechteck(330+60*x,205,10,50,2);
                        break;
                }
                break;
        }
    }
}




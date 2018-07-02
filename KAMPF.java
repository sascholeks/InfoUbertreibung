import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
public class KAMPF {
    Random r;    
    GRAFIKELEMENTE grafik;
    KAEMPFER kaempfer;
    SOUNDSCHWERTSCHLAG schwertkampf;
    SOUNDARROW arrow;
    ALGORITHM alg;
    Timer t1,t2,t3;
    OBJBILDSCHIRM obj;
    SOUNDMUSIKkam musik;
    int[] welt,reihenfolge,kepos,verlorenanz; 
    double[] leben,startlf;
    boolean[] tod;
    int hlkl,hlgr,hpgen,hlp,hpz,aktionen,xpos;
    double schwerfaktor;
    boolean ton,bewegt,gekaempft,sieg,verloren,ug;
    int Orderpos;
    int anz;

    public KAMPF() {
        musik=new SOUNDMUSIKkam();
        schwertkampf=new SOUNDSCHWERTSCHLAG();
        arrow=new SOUNDARROW();
        r=new Random();
        grafik=new GRAFIKELEMENTE();
        kaempfer=new KAEMPFER();
        welt=new int[25];
        leben=new double[12];
        reihenfolge=new int[10];
        kepos=new int[10];
        startlf=new double[10];
        tod=new boolean[10];
        verlorenanz=new int[10];        //eig nur 5 benötigt
        aktionen=0;
        bewegt=false;
        gekaempft=false;
        verloren=false;
        sieg=false;
        hlp=0;
        obj = new OBJBILDSCHIRM();

        t1 = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    decideOrder();
                    t1.stop();
                }    
            });

        t2 = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    decideOrder();
                    beendezug();
                    t2.stop();
                }    
            });

        t3 = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    complDecide();
                    t3.stop();
                }    
            });

    }


    public void kampf(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr,double swer,boolean tone) {
        for(int a=0;a<25;a++) {
            welt[a]=10;
        }
        for(int a=0;a<10;a++) {
            reihenfolge[a]=10;
            kepos[a]=25;
            tod[a]=false;
            verlorenanz[a]=0;
        }
        sieg=false;
        verloren=false;
        gekaempft=false;
        aktionen=0;
        hlp=0;
        leben[0]=ausanz0*CONFIG.HP0;
        leben[1]=ausanz1*CONFIG.HP1;
        leben[2]=ausanz2*CONFIG.HP2;
        leben[3]=ausanz3*CONFIG.HP3;
        leben[4]=ausanz4*CONFIG.HP4;
        leben[5]=geganz0*CONFIG.HP0;
        leben[6]=geganz1*CONFIG.HP1;
        leben[7]=geganz2*CONFIG.HP2;
        leben[8]=geganz3*CONFIG.HP3;
        leben[9]=geganz4*CONFIG.HP4;
        leben[11]=0;  //Hindernis
        ug=false;
        startlf[0]=leben[0];
        startlf[1]=leben[1];
        startlf[2]=leben[2];
        startlf[3]=leben[3];
        startlf[4]=leben[4];
        startlf[5]=leben[5];
        startlf[6]=leben[6];
        startlf[7]=leben[7];
        startlf[8]=leben[8];
        startlf[9]=leben[9];
        hlkl=heiltrkl;
        hlgr=heiltrgr;
        schwerfaktor=swer;
        ton=tone;      
        ZEICHENFENSTER.gibFenster().loescheAlles();
        generierung();
        for(int a=0;a<10;a++) {
            if(leben[a]==0) {
                tod[a]=true;
                welt[a]=10;
                kepos[a]=25;
            }
        }     
        zeichneansicht();
        if(ton==true) {
            musik.play();
        }
    }

    public void kaempfen(int feld) {
        errechnexpos();
        if(aktionen<2) {
            if(gekaempft==false) {
                if(welt[feld]<10) {
                    if(reihenfolge[0]/5!=welt[feld]/5) { //selbes Team
                        if(kaempfer.name(reihenfolge[0]%5)=="Bogenschütze") {
                            if(kepos[reihenfolge[0]]!=feld-1 || kepos[reihenfolge[0]]!=feld-5 || kepos[reihenfolge[0]]!=feld+1 || kepos[reihenfolge[0]]!=feld+5 ) {
                                if((xpos==0 && feld%5==5) || (xpos==5 && feld%5==0)) {
                                    grafik.kons("Nicht erreichbar");
                                }else {
                                    arrow.play();
                                    gekaempft=true;
                                    leben[welt[feld]]=leben[welt[feld]]-kaempfer.dmg(reihenfolge[0]%5)*((int)leben[reihenfolge[0]]/kaempfer.leben(reihenfolge[0]%5));
                                    if(leben[welt[feld]]<=0) {  //kontrolle tod
                                        tod[welt[feld]]=true;
                                        welt[feld]=10;
                                        leben[welt[feld]]=0;  
                                    }
                                    ug=false;
                                    zeichneansicht();
                                    grafik.kons(kaempfer.name(welt[feld]%5)+" hat "+kaempfer.dmg(reihenfolge[0]%5)*leben[reihenfolge[0]]+" Leben verloren");
                                }
                            }else {
                                grafik.kons("Nicht erreichbar");
                            }
                        }else if(kaempfer.name(reihenfolge[0]%5)=="Speerkämpfer") {
                            if((xpos==0 && feld%5==4) || (xpos==4 && feld%5==0)) {
                                grafik.kons("Nicht in Reichweite");
                            }else {
                                if(kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]+5==feld) {
                                    arrow.play();
                                    gekaempft=true;
                                    leben[welt[feld]]=leben[welt[feld]]-kaempfer.dmg(reihenfolge[0]%5)*((int)leben[reihenfolge[0]]/kaempfer.leben(reihenfolge[0]%5));
                                    if(leben[welt[feld]]<=0) {  //kontrolle tod
                                        tod[welt[feld]]=true;
                                        welt[feld]=10;
                                        leben[welt[feld]]=0;
                                    }
                                    ug=false;
                                    zeichneansicht();
                                }else {
                                    grafik.kons("Nicht in Reichweite");
                                }
                            }
                        }else {  // Nahkämpfer
                            if((xpos==0 && feld%5==4) || (xpos==5 && feld%4==0)) {
                                grafik.kons("nicht in Reichweite");
                            }else {
                                if(kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]+5==feld) {
                                    gekaempft=true;
                                    leben[welt[feld]]=leben[welt[feld]]-kaempfer.dmg(reihenfolge[0]%5)*((int)leben[reihenfolge[0]]/kaempfer.leben(reihenfolge[0]%5));
                                    schwertkampf.play();
                                    if(leben[welt[feld]]<=0) {  //kontrolle tod
                                        tod[welt[feld]]=true;
                                        welt[feld]=10;
                                        leben[welt[feld]]=0;
                                    }
                                    if(kaempfer.name(welt[feld]%5)!="Speerkämpfer" || kaempfer.name(reihenfolge[0]%5)!="Bogenschütze") {
                                        leben[reihenfolge[0]]=leben[reihenfolge[0]]-kaempfer.dmg(welt[feld]%5)*((int)leben[welt[feld]]/kaempfer.leben(welt[feld]%5));  //gegenangriff
                                        if(leben[reihenfolge[0]]<=0) {  //kontrolle tod
                                            tod[reihenfolge[0]]=true;
                                            welt[kepos[reihenfolge[0]]]=10;
                                            leben[reihenfolge[0]]=0;
                                        }
                                    }
                                    ug=false;
                                    zeichneansicht();
                                }else {
                                    grafik.kons("nicht in Reichweite");
                                    ug=true;
                                }
                            }
                        }   
                    }else {
                        grafik.kons("Kämpfer aus deinem Team");
                        ug=true;
                    }
                }else {
                    grafik.kons("Feld nicht besetzt");
                    ug=true;
                }
            }else {
                grafik.kons("Bereits gekämpft");
                ug=true;
            }
        }else {
            grafik.kons("Maximale Aktionen bereits gemacht");
            ug=true;
        }
        kontrollesieg();
    }

    public void bewege(int feld) {
        if(aktionen<2) {
            if(bewegt==false) {
                if(gekaempft==false) {
                    if(welt[feld]==10) {
                        if(feld==kepos[reihenfolge[0]]-1 || feld==kepos[reihenfolge[0]]-5 || feld==kepos[reihenfolge[0]]+1 || feld==kepos[reihenfolge[0]]+5) {
                            welt[feld]=reihenfolge[0];
                            welt[kepos[reihenfolge[0]]]=10;
                            kepos[reihenfolge[0]]=feld;
                            zeichneansicht();
                            grafik.kons(kaempfer.name(reihenfolge[0]%5)+" bewegt");
                            hlp++;
                            if(hlp==2) {
                                bewegt=true;
                            }
                        }else {
                            grafik.kons("Nicht in Reichweite");
                        }
                    }else {
                        grafik.kons("Feld besetzt");
                    } 
                }else {
                    grafik.kons("Nach Kampf kann nicht gelaufen werden");
                }
            }else {
                grafik.kons("In dieser Runde schon bewegt");
            }
        }else {
            grafik.kons("Maximale Aktionen gemacht");
        }
    }

    public void heile(int gr) {
        if(tod[reihenfolge[0]]==false){
            if(aktionen<2) {
                switch(gr) {
                    case 0:
                    if(leben[reihenfolge[0]]+300<=startlf[reihenfolge[0]]) {
                        if(hlkl>=1) {
                            hlkl--;
                            leben[reihenfolge[0]]=leben[reihenfolge[0]]+300;
                            zeichneansicht();
                            grafik.kons(kaempfer.name(reihenfolge[0]%5)+" hat jetzt "+leben[reihenfolge[0]]+" Leben");
                            aktionen++;
                        }else {
                            grafik.kons("Nicht genug Heiltränke");
                        }
                    }else {
                        grafik.kons("Nicht genug Leben verloren");
                    }
                    break;
                    case 1:
                    if(leben[reihenfolge[0]]+600<=startlf[reihenfolge[0]]) {
                        if(hlgr>=1) {
                            hlgr--;
                            leben[reihenfolge[0]]=leben[reihenfolge[0]]+600;
                            zeichneansicht();
                            grafik.kons(kaempfer.name(reihenfolge[0]%5)+" hat jetzt "+leben[reihenfolge[0]]+" Leben");
                            aktionen++;
                        }else {
                            grafik.kons("Nicht genug Heiltränke");
                        }
                    }else {
                        grafik.kons("Nicht genug Leben verloren");
                    }
                    break;
                }
            }else {
                grafik.kons("Maximale Aktionen gemacht");
            }
        }
    }

    public void beendezug() {
        hpz=reihenfolge[0];
        for(int a=0;a<9;a++) {
            reihenfolge[a]=reihenfolge[a+1];
        }
        reihenfolge[9]=hpz;
        zeichneansicht();
        hlp=0;
        bewegt=false;
        aktionen=0;
        gekaempft=false;
        ug=false;
        if(tod[reihenfolge[0]]==true) {
            grafik.kons(kaempfer.name(reihenfolge[0]%5)+" ist tod");
            ZEICHENFENSTER.gibFenster().warte(1000);
            beendezug();
        }
        if(reihenfolge[0]>=5 && reihenfolge[0]<10) {
            t3.start();
        }
        kontrollesieg();
    }

    public void generierung() {
        for(int a=0;a<5;a++) {      //feldbesetzung
            do {                            //team 1
                hpgen=r.nextInt(5);
            }while(welt[hpgen*5]!=10);  //wird wiederholt wenn Feld !=10/ besetzt ist 
            welt[hpgen*5]=a;
            kepos[a]=hpgen*5;
            do {                            //team 2
                hpgen=r.nextInt(5);
            }while(welt[hpgen*5+4]!=10);
            welt[hpgen*5+4]=a+5;
            kepos[a+5]=hpgen*5+4;
        }
        switch(r.nextInt(4)) {  //hindernisgenerierung
            case 0:     //kein hindernis
            break;
            case 1:
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            break;
            case 2:
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            break;
            case 3:
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            do {
                hpgen=r.nextInt(3)+1+r.nextInt(5)*5;
            }while(welt[hpgen]!=10);
            welt[hpgen]=11;
            break;
        }
        hpgen=r.nextInt(2);
        if(hpgen==0) {          //reihenfolge
            for(int a=0;a<5;a++) {  //team 1
                do {
                    hpgen=r.nextInt(5);
                }while(reihenfolge[hpgen]!=10);
                reihenfolge[hpgen]=a;
            }
            for(int a=5;a<10;a++) {  //team 2
                do {
                    hpgen=r.nextInt(5);
                }while(reihenfolge[hpgen+5]!=10);
                reihenfolge[hpgen+5]=a;
            }
        }else if(hpgen==1) {
            for(int a=5;a<10;a++) {  //team 1
                do {
                    hpgen=r.nextInt(5);
                }while(reihenfolge[hpgen]!=10);
                reihenfolge[hpgen]=a;
            }
            for(int a=0;a<5;a++) {  //team 1
                do {
                    hpgen=r.nextInt(5);
                }while(reihenfolge[hpgen+5]!=10);
                reihenfolge[hpgen+5]=a;
            }
        }
    }

    public void zeichneansicht() {
        grafik.spielfeld();
        for(int a=0;a<6;a++) {              //in reihenfolge
            grafik.zeichneKaempferreihenfolge(reihenfolge[a]%5,reihenfolge[a]/5,a,tod[reihenfolge[a]]);
            if(tod[reihenfolge[a]]==false) {
                grafik.anzahlreihenfolge(a,(int)leben[reihenfolge[a]]/(kaempfer.leben(reihenfolge[a]%5)));
            }

        }
        grafik.kons("Kämpfer: "+kaempfer.name(reihenfolge[0]%5)+" Team "+(reihenfolge[0]/5+1));
        if(tod[reihenfolge[0]]==false) {
            grafik.markiereaktuell(kepos[reihenfolge[0]]);
        }
        for(int a=0;a<25;a++) {             //in feld
            if(welt[a]<10) {
                if(tod[welt[a]]==false) {
                    grafik.zeichneinfeld(welt[a],a,(int)leben[welt[a]]/(kaempfer.leben(welt[a]%5)));
                }
            }else if(welt[a]==11) {
                grafik.zeichneinfeld(11,a,0);
            }
        }
        grafik.zeichneaktionswahl();       
    }

    public void kontrollesieg() {
        musik.stop();
        if(tod[0]==true && tod[1]==true && tod[2]==true && tod[3]==true && tod[4]==true) {
            grafik.kons("Verloren");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            grafik.zeichneverloren();
            verloren=true;
        }else if(tod[5]==true && tod[6]==true && tod[7]==true && tod[8]==true && tod[9]==true) {
            grafik.kons("Sieg");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            grafik.zeichnesieg((int)((leben[0]-startlf[0])/kaempfer.leben(0)),(int)(leben[1]-startlf[1])/kaempfer.leben(1),(int)(leben[2]-startlf[2])/kaempfer.leben(2),(int)(leben[3]-startlf[3])/kaempfer.leben(3),(int)(leben[4]-startlf[4])/kaempfer.leben(4),(int)(r.nextInt(5)*schwerfaktor),(int)(r.nextInt(4)*schwerfaktor),(int)(r.nextInt(5000)*schwerfaktor));
            sieg=true;
            grafik.kons("Klicken und Taste drücken um Fortzufahren");
            for(int a=0;a<5;a++) {
                verlorenanz[a]=(int)(leben[a]-startlf[a])/kaempfer.leben(a);
            }
        }
    }

    public int getOrderPos() {
        alg = new ALGORITHM(welt,getanz(),reihenfolge);
        Orderpos = alg.getOrderPos(); 
        return Orderpos;
    }

    public int getAction() {
        alg = new ALGORITHM(welt,getanz(),reihenfolge);
        alg.decide();
        return alg.getActionType();
    }

    public void complDecide() {
        decideOrder();
        if(getAction()==1) {
            t1.start();
            if(getAction()==1) {
                t2.start();
            } else {
                beendezug();
            }
        } else {
            beendezug();
        }
    }

    public int[] getanz() {
        int[] anz = new int[25];
        for(int i=0;i<25;i++) {
            anz[i] = (int)(leben[welt[i]]/(kaempfer.leben(welt[i]%5))); 
        }
        return anz;
    }

    public int getPos() {
        int pos = 0;
        for(int i=0;i<25;i++) {
            if(reihenfolge[0] == welt[i]) { 
                pos = i;
            }
        }
        return pos;
    }

    public void errechnexpos() {
        xpos=kepos[reihenfolge[0]]%5;
    }

    public void dev() {
        kampf(2000,1,1,1,1,10,1,0,1,1,1,1,2.1,true);
    }

    public int getActionPos() {
        return alg.getActionPos();
    }

    public void action(int action) {
        switch(action) {
            case 1:     //move
            bewege(getActionPos());
            break;
            case 0:     //attack    
            kaempfen(getActionPos());
            break;
            case 2:     //stop
            beendezug();
            break;
            default:   //heilen etc. fehlt;
            //grafik.kons("AI Action Error!");
        }
    }

    public void decideOrder() {
        int pos=-1;
        alg = new ALGORITHM(welt,getanz(),reihenfolge);
        alg.updateOrder(reihenfolge);
        for(int i=0;i<25;i++) {
            if(welt[i]==reihenfolge[0]) {
                if(reihenfolge[0]>=5 && reihenfolge[0] <10) { //muss zu >=5 und <10
                    pos = i;
                } else {
                    //grafik.kons("Error: Die KI ist nicht am Zug!");
                    pos = -2;
                }
            }
        }
        Orderpos = alg.getOrderPos();
        if(pos!=-1 && pos!=-2) {
            alg.decide();
            action(alg.getActionType());
        } else if(pos == -2) {
            //grafik.kons("Error: Die KI ist nicht am Zug!");
        }else {
            beendezug();
        }
    }
}


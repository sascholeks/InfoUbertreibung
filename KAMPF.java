import java.util.Random;
public class KAMPF
{
    static KAMPF statKampf;
    GRAFIKELEMENTE grafik;
    Random r;
    KAEMPFER[] kaempfer;
    ALGORITHM alg;
    SOUNDSCHWERTSCHLAG schwertkampf;
    SOUNDARROW arrow;
    //SOUNDMUSIKkam musik;
    
    int[] leben,dmg,welt,reihenfolge,kepos,team,x,y,anz,startanz;  //im index steht die kaempferID  //indes in welt gibt feld an
    boolean[] tod;
    int aktionen,feld,bewhelp=0,feldhind,helphind,helphind2,hlkl,hlgr,aanz1,aanz2,aanz3,aanz4,aanz5,posx,posy;
    double schwer;
    boolean geheilt=false,gekaempft=false,bewegt=false,konlinks,konrechts,ug=false,sieg,verloren,ton=true;   //ug=ungültig (bei bewegung(int feld))
    int Orderpos;
    public KAMPF(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr,double swer,boolean tone)
    {
        statKampf = this;
        ton=tone;
        grafik=new GRAFIKELEMENTE();
        schwertkampf=new SOUNDSCHWERTSCHLAG();
        arrow=new SOUNDARROW();
        //musik=new SOUNDMUSIKkam();
        r=new Random();
        x=new int [5];
        y=new int [5];
        int xyp=20;              //anfangskordinaten 
        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }
        schwer=swer;
        reihenfolge=new int[10];    //index ID der Kaempfer
        kepos=new int[10];          //gibt an wo der kämpfer mit der[ID] steht
        leben=new int[10];
        dmg=new int[10];
        tod=new boolean[10];
        for(int a=0;a<10;a++) {
            tod[a]=false;
        }
        welt=new int[25];          //wenn welt[x]=11, dann ist feld frei
        for(int a=0;a<25;a++) {
            welt[a]=10;
        }
        team=new int[10];         //erg=team von [kaempferID]
        for(int a=0;a<5;a++) {
            team[a]=1;
            team[a+5]=2;
        }

        anz=new int[12];      //eintrafen der anzahl, aufrufbar mit [kaempferID]
        anz[0]=ausanz0;
        anz[1]=ausanz1;
        anz[2]=ausanz2;
        anz[3]=ausanz3;
        anz[4]=ausanz4;
        anz[5]=geganz0;
        anz[6]=geganz1;
        anz[7]=geganz2;
        anz[8]=geganz3;
        anz[9]=geganz4;
        anz[11]=0;           //für hindernisse(wird bei kampfeigabe gebraucht)
        startanz=new int[10];
        for(int a=0;a<10;a++) {
            startanz[a]=anz[0];
        }
        kaempfer=new KAEMPFER[10];
        for(int a=0;a<10;a++) {
            kaempfer[a]=new KAEMPFER(a%5);          //erhält rest zw. 0 und 4                                   //hat einfluss auf name
            leben[a]=kaempfer[a].leben*anz[a];
            dmg[a]=kaempfer[a].dmg*anz[a];
        }

        hlkl=heiltrkl;
        hlgr=heiltrgr;
        ZEICHENFENSTER.gibFenster().loescheAlles();
        zreihenfolge();
        startpos();
        grafik.spielfeld();
        grafik.markiereaktuell(kepos[reihenfolge[0]]);

        for(int a=0;a<6;a++) {           //zeichne Bilder in Reiehnfolge
            grafik.zeichneKaempferreihenfolge(reihenfolge[a]%5,team[reihenfolge[a]],a);                         //hat einfluss auf reiehenfolg
            grafik.anzahlreihenfolge(a,anz[reihenfolge[a]]);
        }
        for(int a=0;a<10;a++) {         //zeichne in spielfeld
            grafik.zeichneinfeld(a,kepos[a],anz[a]);                                                           //hat einfluss auf feld
        } 
        grafik.kons("Kämpfer: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+"  (Kämepfer "+reihenfolge[0]+")");
        hindernisse();
        aanz1=anz[0];
        aanz2=anz[1];
        aanz3=anz[2];
        aanz4=anz[3];
        aanz5=anz[4];
        sieg=false;
        verloren=false;
        if(ton==true) {
            //musik.play();
        }

        if(reihenfolge[0]>=5 && reihenfolge[0] <10) {
            complDecide();
        }
    }
    
    public void kaempfen(int feld,boolean AI) {
        if(aktionen!=2 && gekaempft==false) {                   //kontolle bereits gekämpft und aktionen gemacht
            if(welt[feld]!=10 && welt[feld]!=11) {              //kontrolle gegner auf feld
                if(team[welt[feld]]!=team[reihenfolge[0]]) {    //kontolle selbes team
                    if(kaempfer[reihenfolge[0]].name=="Bogenschütze") {                 //kontolle kaempferart
                        arrow.play();
                        if(dmg[reihenfolge[0]]>=0) {
                            leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        }
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");   
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
                        ug=false;
                        if(leben[welt[feld]]<=0) {              //kontolle tod
                            anz[welt[feld]]=0;
                            grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" ist tod");
                            tod[welt[feld]]=true;
                            welt[feld]=10;
                            zeichnereihenfolge();
                            grafik.loeschemarkierung(feld);
                            kontrollesieg();   
                        }
                        gekaempft=true;
                    }else if(kaempfer[reihenfolge[0]].name=="Speerkaempfer" && (kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]-2==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]+2==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]-10==feld || kepos[reihenfolge[0]]+5==feld || kepos[reihenfolge[0]]+10==feld || kepos[reihenfolge[0]]-6==feld || kepos[reihenfolge[0]]-4==feld || kepos[reihenfolge[0]]+4==feld || kepos[reihenfolge[0]]+6==feld)) {  
                        arrow.play();
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");    
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;                      
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
                        ug=false;
                        if(leben[welt[feld]]<=0) {              //kontolle tod
                            anz[welt[feld]]=0;
                            grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" ist tod");
                            tod[welt[feld]]=true;
                            welt[feld]=10;
                            zeichnereihenfolge();
                            grafik.loeschemarkierung(feld);
                            kontrollesieg();
                        }
                        gekaempft=true;

                    }else if(kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]+5==feld) {    //Nahkämperangriff
                        schwertkampf.play();
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");   
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;        
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
                        ug=false;
                        if(kaempfer[welt[feld]].name!="Bogenschütze" && kaempfer[welt[feld]].name!="Speerkämpfer") {            //gegenangriff
                            schwertkampf.playgeg();
                            grafik.kons("Gegenattacke");
                            try {                                                                         
                                Thread.sleep(500);                 
                            } catch(InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            } 
                            leben[reihenfolge[0]]=leben[reihenfolge[0]]-dmg[welt[feld]];
                            anz[reihenfolge[0]]=(int)(leben[reihenfolge[0]]/kaempfer[reihenfolge[0]].leben);
                            grafik.anzahl(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                            grafik.anzahlreihenfolge(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                        }
                        
                        if(leben[reihenfolge[0]]<=0) {
                            anz[welt[kepos[reihenfolge[0]]]]=0;
                            grafik.kons("Der verbündete "+kaempfer[welt[feld]].name+" ist tod");
                            tod[welt[feld]]=true;
                            welt[kepos[reihenfolge[0]]]=10;
                            zeichnereihenfolge();
                            grafik.loeschemarkierung(kepos[reihenfolge[0]]);
                            kontrollesieg();
                        }
                        
                        if(leben[welt[feld]]<=0) {              //kontolle tod
                            anz[welt[feld]]=0;
                            grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" ist tod");
                            tod[welt[feld]]=true;
                            welt[feld]=10;
                            zeichnereihenfolge();
                            grafik.loeschemarkierung(feld);
                            kontrollesieg();
                        }
                        gekaempft=true;

                    }else if(kepos[reihenfolge[0]]-1==feld && kepos[reihenfolge[0]]+1==feld && kepos[reihenfolge[0]]-5==feld && kepos[reihenfolge[0]]+5==feld){
                        grafik.kons("für "+kaempfer[reihenfolge[0]].name+" unerreichbar");
                        ug=true;
                    }else {
                        grafik.kons("Unerreichbar");
                        ug=true;
                    }
                }else if (team[welt[feld]]==team[reihenfolge[0]]) {
                    grafik.kons("Du kannst keine Kämpfer aus deinem Team angreifen");
                    ug=true;
                }
            }else {
                grafik.kons("Kein Gegner gefunden");
                ug=true;
            }
        }else if(gekaempft==true) {
            if(!AI) {
                grafik.kons("In dieser Runde bereits gekämpft"); 
                grafik.loeschemarkierung(feld);
                grafik.zeichneinfeld(welt[feld],feld,anz[welt[feld]]);
            }
            ug=false;
        }else if(aktionen==2) {
            if(!AI) {
                grafik.kons("Max. Aktionen bereits ausgeführt!");
            }
            ug=false;
        }       
    }
    
    public void bewegen(int feld, boolean AI) {
        if(aktionen!=2 && bewegt==false && welt[feld]==10 && gekaempft==false) {
            if(kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]+5==feld) {
                grafik.loeschemarkierung(kepos[reihenfolge[0]]);
                welt[kepos[reihenfolge[0]]]=10;
                welt[feld]=reihenfolge[0];
                kepos[reihenfolge[0]]=feld;
                grafik.markiereaktuell(kepos[reihenfolge[0]]);
                grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                bewhelp++;
                if(bewhelp==2) {
                    bewhelp=0;
                    bewegt=true;
                    aktionen++;
                }
            }else {
                grafik.kons("Feld nicht in Reichweite");
                grafik.zeichneinfeld(welt[feld],feld,anz[welt[feld]]);
            }
        }else if(aktionen==2) {
            if(!AI) {
                grafik.kons("Max. Aktionen bereits ausgeführt");
            }
        }else if(bewegt==true) {
            if(!AI) {
                grafik.kons("In dieser Runde hast du  dich bereits 2 mal bewegt");
                grafik.zeichneinfeld(welt[feld],feld,anz[welt[feld]]);
            }
        }else if(welt[feld]!=10) {
            grafik.kons("Feld ist nicht frei");
            grafik.zeichneinfeld(welt[feld],feld,anz[welt[feld]]);
        }else if(gekaempft==true) {
            if(!AI) {
                grafik.kons("Nach dem Kampf kannst du nicht laufen");
            }
        }
    }
    
    public void heilen(int gr) {
        if(aktionen!=2 && geheilt==false && team[reihenfolge[0]]==1) {
            if(gr==0) {
                int helpberechnung=leben[reihenfolge[0]]+100;
                anz[reihenfolge[0]]=(int)helpberechnung/kaempfer[reihenfolge[0]].leben;
                if(startanz[reihenfolge[0]]>=anz[reihenfolge[0]]) {
                    if(hlkl>=1) {
                        geheilt=true;
                        hlkl--;
                        leben[reihenfolge[0]]=leben[reihenfolge[0]]+100;
                        anz[reihenfolge[0]]=(int)(leben[reihenfolge[0]]/kaempfer[reihenfolge[0]].leben);
                        grafik.anzahl(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                        grafik.anzahlreihenfolge(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                        grafik.kons("kleiner Heiltrank genommen");
                    }else {
                        grafik.kons("Nicht genügend kleine Tränke");
                    }
                }else {
                    grafik.kons("nicht genug Leben verloren");
                }
            }else if(gr==1) {
                int helpberechnung=leben[reihenfolge[0]]+300;
                anz[reihenfolge[0]]=(int)helpberechnung/kaempfer[reihenfolge[0]].leben;
                if(startanz[reihenfolge[0]]>=anz[reihenfolge[0]]) {
                    if(hlgr>=1) {
                        geheilt=true;
                        hlgr--;
                        leben[reihenfolge[0]]=leben[reihenfolge[0]]+400;
                        anz[reihenfolge[0]]=(int)(leben[reihenfolge[0]]/kaempfer[reihenfolge[0]].leben);
                        grafik.anzahl(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                        grafik.anzahlreihenfolge(kepos[reihenfolge[0]],anz[reihenfolge[0]]);
                        grafik.kons("großer Heiltrank genommen");
                    }else{
                        grafik.kons("Nicht genügend große Heiltränke");
                    } 
                }else {
                    grafik.kons("nicht gen Leben verloren");
                }
            }
        }
        else if(team[reihenfolge[0]]==2){
            grafik.kons("Gegner kann aus Technischen Gründen keine Tränke nehmen");              //zeile evtl. löschen
        } else if(geheilt==true) {
            grafik.kons("In dieser Runde bereits geheilt");
        }else if(aktionen==2) {
            grafik.kons("Max. Aktionen bereits gemacht");
        }
    }
    
    public void hindernisse() {
        helphind=r.nextInt(3); 
        for(int a=0;a<=helphind;a++) {
            feldhind=r.nextInt(3);
            helphind2=r.nextInt(5);
            feldhind=feldhind+helphind2*5+1;
            grafik.zeichnehindernis(feldhind);
            welt[feldhind]=11; 
        }
    }

    public static KAMPF createKampf(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr,double swer,boolean tone) 
    {
        if(statKampf==null) {
            statKampf = new KAMPF(ausanz0, ausanz1,ausanz2, ausanz3, ausanz4, geganz0, geganz1, geganz2, geganz3, geganz4, heiltrkl, heiltrgr, swer, tone);
        }
        return statKampf;
    }

    public static KAMPF getKampf() {
        return statKampf;
    }

    public void decideOrder() {
        int pos=-1;
        alg = new ALGORITHM(welt,anz,reihenfolge);
        alg.updateOrder(reihenfolge);
        for(int i=0;i<25;i++) {
            if(welt[i]==reihenfolge[0]) {
                if(reihenfolge[0]>=5 && reihenfolge[0] <10) { //muss zu >=4 und <10
                    pos = i;
                } else {
                    grafik.kons("Error: Die KI ist nicht am Zug!");
                    pos = -2;
                }
            }
        }
        Orderpos = alg.getOrderPos();
        if(pos!=-1 && pos!=-2) {
            alg.decide();
            action(alg.getActionType());
        } else if(pos == -2) {
            grafik.kons("Error: Die KI ist nicht am Zug!");
        }else {
            grafik.kons("Error: KI decide error!");
        }
    }

    public int getActionPos() {
        return alg.getActionPos();
    }

    public void action(int action) {
        switch(action) {
            case 1:     //move
            bewegen(getActionPos(),true);
            break;
            case 0:     //attack    
            kaempfen(getActionPos(),true);
            break;
            case 2:     //stop
            beendez();
            break;
            default:   //heilen etc. fehlt;
            //grafik.kons("AI Action Error!");
        }
    }
    
    public void beendez() {
        grafik.loeschemarkierung(kepos[reihenfolge[0]]);                                                       
        if(tod[reihenfolge[0]]==false) {                                                                             //markiere (wegen löschen weg)
            grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);
        }
        int zhelp=reihenfolge[0];                                                                                  //aktualisiere reihenfolge
        for(int a=0;a<9;a++) {
            reihenfolge[a]=reihenfolge[a+1];
        }
        reihenfolge[9]=zhelp; 
        zeichnereihenfolge();
        if(tod[reihenfolge[0]]==true) {
            grafik.kons(kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+" ist Tod");
            beendez();
        }
        grafik.kons("Kämpfer: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]);
        grafik.markiereaktuell(kepos[reihenfolge[0]]);
        grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);
        grafik.zeichneaktionswahl();
        geheilt=false;      //kontollen zurücksetzen
        gekaempft=false;
        bewegt=false;
        ug=false;
        bewhelp=0;
        aktionen=0;
        posx=kepos[reihenfolge[0]]%5;
        posy=kepos[reihenfolge[0]]/5;
        if(reihenfolge[0]>5 && reihenfolge[0]<10) {
            grafik.kons("Bestätige mit \"Zug beenden\" um fortzufahren!");
        }
    }
    
    public void zeichnereihenfolge() {
        for(int a=0;a<6;a++) {
            grafik.zeichneKaempferreihenfolge(reihenfolge[a]%5,team[reihenfolge[a]],a);
            if(tod[reihenfolge[a]]==true) {
                grafik.markieretot(a);
            }
            grafik.anzahlreihenfolge(a,anz[reihenfolge[a]]);
        }
    }
    
    public void zreihenfolge() {
        int help1=r.nextInt(2);                                  //Zugreihenfolge wird gewählt
        if(help1==0) {      //team blau als erstes
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5);
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;
            }
            for(int a=5;a<10;a++) {
                do {
                    help1=r.nextInt(5)+5;
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;
            }
        }
        else if(help1==1) {            //team rot als erstes
            for(int a=5;a<10;a++) {
                do {
                    help1=r.nextInt(5);
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;  
            } 
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5)+5;
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;
            }
        }
        grafik.kons("Kämpfer: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]);
    }
    
    public void startpos() {
        int helppos1;
        for(int a=0;a<5;a++) {                     //startposition der kaempfer wird generiert
            do {
                helppos1=r.nextInt(5)*5;
            }while(welt[helppos1]!=10);
            welt[helppos1]=a;
            kepos[a]=helppos1;
        }
        for(int b=0;b<5;b++) {
            do {
                helppos1=r.nextInt(5)*5+4;
            }while(welt[helppos1]!=10);
            welt[helppos1]=b+5;
            kepos[b+5]=helppos1;
        }
    }
    
    public void kontrollesieg() {
        //musik.stop();
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
            grafik.zeichnesieg(aanz1-anz[0],aanz2-anz[1],aanz3-anz[2],aanz4-anz[3],aanz5-anz[4],(int)(r.nextInt(5)*schwer),(int)(r.nextInt(4)*schwer),(int)(r.nextInt(5000)*schwer));
            sieg=true;
            grafik.kons("Klicken und Taste drücken um Fortzufahren");
        }
    }

    public int getOrderPos() {
        alg = new ALGORITHM(welt,anz,reihenfolge);
        Orderpos = alg.getOrderPos(); 
        return Orderpos;
    }

    public int getAction() {
        alg = new ALGORITHM(welt,anz,reihenfolge);
        alg.decide();
        return alg.getActionType();
    }

    public void complDecide() {
        decideOrder();
        if(getAction()==1) {
            decideOrder(); 
            if(getAction()==1) {
                decideOrder(); 
                beendez();
            } else {
                beendez();
            }
        } else {
            beendez();
        }
    }
    
    public boolean pruefeSieg() {
        boolean win=true;
        for(int i=0;i<5;i++) {
            if(tod[i]==true && win==true) {
                win=true;
            } else {
                win=false;
            }
        }
        return win;
    }

}







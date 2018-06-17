import java.util.Random;

public class KAMPF
{
    GRAFIKELEMENTE grafik;
    Random r;
    KAEMPFER[] kaempfer;
    ALGORITHM alg;
    SOUNDSCHWERTSCHLAG schwertkampf;
    SOUNDARROW arrow;
    SOUNDMUSIKkam musik;

    int[] leben,dmg,welt,reihenfolge,kepos,team,x,y,anz,startanz;  //im index steht die kaempferID  //indes in welt gibt feld an
    boolean[] tod;
    int aktionen,feld,bewhelp=0,feldhind,helphind,helphind2,hlkl,hlgr,aanz1,aanz2,aanz3,aanz4,aanz5,posx,posy;
    double schwer;
    boolean geheilt=false,gekaempft=false,bewegt=false,konlinks,konrechts,ug=false,sieg,verloren;   //=ungültig (bei bewegung(int feld))
    public KAMPF(int ausanz0,int ausanz1,int ausanz2,int ausanz3,int ausanz4,int geganz0,int geganz1,int geganz2,int geganz3,int geganz4,int heiltrkl,int heiltrgr,double swer)                                     
    {
        grafik=new GRAFIKELEMENTE();
        schwertkampf=new SOUNDSCHWERTSCHLAG();
        arrow=new SOUNDARROW();
        musik=new SOUNDMUSIKkam();
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
        zeichnespielfeld();
        grafik.spielfeld();
        grafik.markiereaktuell(kepos[reihenfolge[0]]);

        for(int a=0;a<6;a++) {           //zeichne Bilder in Reiehnfolge
            grafik.zeichneKaempferreihenfolge(reihenfolge[a]%5,team[reihenfolge[a]],a);                         //hat einfluss auf reiehenfolg
            grafik.anzahlreihenfolge(a,anz[reihenfolge[a]]);
        }
        for(int a=0;a<10;a++) {         //zeichne in spielfeld
            grafik.zeichneinfeld(a,kepos[a],anz[a]);                                                           //hat einfluss auf feld
        } 
        grafik.kons("an der Reihe: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+"  (Kämepfer "+reihenfolge[0]+")");
        hindernisse();
        aanz1=anz[0];
        aanz2=anz[1];
        aanz3=anz[2];
        aanz4=anz[3];
        aanz5=anz[4];
        sieg=false;
        verloren=false;
        musik.play();
    }

    public void zeichnespielfeld() {
    }

    public void kaempfen(int feld) {
        if(aktionen!=2 && gekaempft==false) {                   //kontolle bereits gekämpft und aktionen gemacht
            if(welt[feld]!=10 && welt[feld]!=11) {              //kontrolle gegner auf feld
                if(team[welt[feld]]!=team[reihenfolge[0]]) {    //kontolle selbes team
                    if(kaempfer[reihenfolge[0]].name=="Bogenschütze") {                 //kontolle kaempferart
                        arrow.play();
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");  
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
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
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
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
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
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
            grafik.kons("In dieser Runde bereits gekämpft");
            ug=false;
        }else if(aktionen==2) {
            grafik.kons("Max. Aktionen bereits gemacht");
            ug=false;
        }       
    }

    public void bewegen(int feld) {
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
            }
        }else if(aktionen==2) {
            grafik.kons("Max. Aktionen bereits ausgeführt");
        }else if(bewegt==true) {
            grafik.kons("In dieser Runde hast du  dich bereits 2 mal bewegt");
        }else if(welt[feld]!=10) {
            grafik.kons("Feld ist nicht frei");
        }else if(gekaempft==true) {
            grafik.kons("Nach dem Kampf kannst du nicht laufen");
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
                    grafik.kons("nicht gen Leben verloren");
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

    public void zeichnereihenfolge() {
        for(int a=0;a<6;a++) {
            grafik.zeichneKaempferreihenfolge(reihenfolge[a]%5,team[reihenfolge[a]],a);
            if(tod[reihenfolge[a]]==true) {
                grafik.markieretot(a);
            }
            grafik.anzahlreihenfolge(a,anz[reihenfolge[a]]);
        }
    }

    public void beendez() {
        grafik.loeschemarkierung(kepos[reihenfolge[0]]);                                                       
        if(tod[reihenfolge[0]]==false) {                                                                             //markiere (wegen löschen weg
            grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);
        }
        int zhelp=reihenfolge[0];                                                                                  //aktualisiere riehenfolge
        for(int a=0;a<9;a++) {
            reihenfolge[a]=reihenfolge[a+1];
        }
        zeichnereihenfolge();
        reihenfolge[9]=zhelp;   
        if(tod[reihenfolge[0]]==true) {
            grafik.kons(kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+" ist Tod");
            beendez();
        }
        grafik.kons("an der Reihe: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+"  (Kämepfer "+reihenfolge[0]+")");
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
    }

    public void zreihenfolge() {
        int help1=r.nextInt(2);                                  //Zreihenfolge wird gewählt
        if(help1==0) {      //team blau als erstes
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5);
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;
            }
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5+5);
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a+5;
            }
        }
        else if(help1==1) {            //team rot als erstes
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5);
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a+5;
            }
            for(int a=0;a<5;a++) {
                do {
                    help1=r.nextInt(5)+5;
                }while(reihenfolge[help1]>0);
                reihenfolge[help1]=a;
            }
        } 
        grafik.kons("an der Reihe: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+"  (Kamepfer "+reihenfolge[0]+")");
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
            grafik.zeichnesieg(aanz1-anz[0],aanz2-anz[1],aanz3-anz[2],aanz4-anz[3],aanz5-anz[4],(int)(r.nextInt(5)*schwer),(int)(r.nextInt(4)*schwer),(int)(r.nextInt(5000)*schwer));
            sieg=true;
            grafik.kons("Klicken und Taste drücken um Fortzufahren");
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

    public void decide(int pos) {
        alg = new ALGORITHM(welt,anz,reihenfolge);
        alg.decide();
    }

}
//          try {
//              Thread.sleep(1000);                 
//          } catch(InterruptedException ex) {
//              Thread.currentThread().interrupt();
//          } 
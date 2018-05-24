import java.util.Random;

public class DEV
{
    GEGNERINVENTAR invgeg;
    INVENTAR inv;
    GRAFIKELEMENTE grafik;
    Random r;
    KAEMPFER[] kaempfer;
    ALGORITHM alg;
    SOUNDSCHWERTSCHLAG schwertkampf;

    int[] leben,dmg,welt,reihenfolge,kepos,team,x,y,anz;  //im index steht die kaempferID  //indes in welt gibt feld an
    boolean[] tod;
    int aktionen,feld,bewhelp=0,feldhind,helphind,helphind2;
    boolean geheilt=false,gekaempft=false,bewegt=false;
    public DEV()
    {
        inv=new INVENTAR();
        invgeg=new GEGNERINVENTAR();
        grafik=new GRAFIKELEMENTE();
        schwertkampf=new SOUNDSCHWERTSCHLAG();
        r=new Random();

        grafik.setTitle("Developer Mode");
        
        inv.fuellestandart();                                         //nur zu testzwecken später löschen

        x=new int [5];
        y=new int [5];
        int xyp=20;              //anfangskordinaten 
        for(int a=0;a<5;a++) {
            x[a]=xyp;
            y[a]=xyp;
            xyp=xyp+50;
        }

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

        anz=new int[10];      //eintrafen der anzahl, aufrufbar mit [kaempferID]
        anz[0]=inv.ausanz[0];
        anz[1]=inv.ausanz[1];
        anz[2]=inv.ausanz[2];
        anz[3]=inv.ausanz[3];
        anz[4]=inv.ausanz[4];
        anz[5]=invgeg.anz0;
        anz[6]=invgeg.anz1;
        anz[7]=invgeg.anz2;
        anz[8]=invgeg.anz3;
        anz[9]=invgeg.anz4;

        kaempfer=new KAEMPFER[10];
        for(int a=0;a<10;a++) {
            kaempfer[a]=new KAEMPFER(a%5);          //erhält rest zw. 0 und 4                                   //hat einfluss auf name
            leben[a]=kaempfer[a].leben*anz[a];
            dmg[a]=kaempfer[a].dmg*anz[a];
        }

        ZEICHENFENSTER.gibFenster().loescheAlles();
        zugreihenfolge();
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
        /**hindernisse(); **/
    }

    public void zeichnespielfeld() {
    }

    public void kaempfen(int feld) {
        if(aktionen!=2 && gekaempft==false) {                   //kontolle bereits gekämpft und aktionen gemacht
            if(welt[feld]!=10) {                                //kontrolle gegner auf feld
                if(team[welt[feld]]!=team[reihenfolge[0]]) {    //kontolle selbes team
                    if(kaempfer[reihenfolge[0]].name=="Bogenschütze") {                 //kontolle kaempferart
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");  
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
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
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");  
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;                      
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
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
                    }else if(kepos[reihenfolge[0]]-1==feld || kepos[reihenfolge[0]]+1==feld || kepos[reihenfolge[0]]-5==feld || kepos[reihenfolge[0]]+5==feld) {  //nahkämperangriff
                        schwertkampf.play();
                        leben[welt[feld]]=leben[welt[feld]]-dmg[reihenfolge[0]];
                        grafik.kons("Der feindliche "+kaempfer[welt[feld]].name+" hat "+dmg[reihenfolge[0]]+" Schaden erlitten");  
                        grafik.kons("Er hat jetzt noch "+leben[welt[feld]]);   
                        anz[welt[feld]]=(int)leben[welt[feld]]/kaempfer[welt[feld]].leben;        
                        dmg[welt[feld]]=kaempfer[welt[feld]].dmg*anz[welt[feld]];
                        grafik.anzahl(kepos[welt[feld]],anz[welt[feld]]);
                        grafik.anzahlreihenfolge(reihenfolge[welt[feld]],anz[welt[feld]]);
                        if(kaempfer[welt[feld]].name!="Bogenschütze" && kaempfer[welt[feld]].name!="Speerkämpfer") {                       //gegenangriff
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
                    }else {
                        grafik.kons("Unerreichbar");
                    }
                }else if (team[welt[feld]]==team[reihenfolge[0]]) {
                    grafik.kons("Du kannst keine Kämpfer aus deinem Team angreifen");
                }
            }else {
                grafik.kons("Kein Gegner gefunden");
            }
        }else if(gekaempft==true) {
            grafik.kons("In dieser Runde bereits gekämpft");
        }else if(aktionen==2) {
            grafik.kons("Max. Aktionen bereits gemacht");
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
                }
            }else {
                grafik.kons("Feld nicht in Reichweite");
            }
        }else if(welt[feld]!=10) {
            grafik.kons("Feld ist nicht frei");
        }else if(bewegt==true) {
            grafik.kons("In dieser Runde hast du  dich bereits 2 mal bewegt");
        }else if(aktionen==2) {
            grafik.kons("Max. Aktionen bereits ausgeführt");
        }else if(gekaempft==true) {
            grafik.kons("Nach dem Kampf kannst du nicht laufen");
        }
    }

    public void heilen(int gr) {
        if(aktionen!=2 && geheilt==false && team[reihenfolge[0]]==1) {
            if(gr==0) {
                if(inv.heiltrankkl>=1) {
                    geheilt=true;
                    inv.benutzeheiltrank(0);
                    grafik.kons("kleiner Heiltrank genommen");
                }else {
                    grafik.kons("Nicht genügend kleine Tränke");
                }
            }else if(gr==1) {
                if(inv.heiltrankgr>=1) {
                    geheilt=true;
                    inv.benutzeheiltrank(1);
                    grafik.kons("großer Heiltrank genommen");
                }else{
                    grafik.kons("Nicht genügend große Heiltränke");
                } 
            }else if(gr>1){
                grafik.kons("ungültige Trankgröße");
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
                grafik.markieretod(a);
            }
            grafik.anzahlreihenfolge(a,anz[reihenfolge[a]]);
        }
    }

    public void beendezug() {
        grafik.loeschemarkierung(kepos[reihenfolge[0]]);                                                       
        if(tod[reihenfolge[0]]==false) {                                                                             //markiere (wegen löschen weg
            grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);
        }
        int zughelp=reihenfolge[0];                                                                                  //aktualisiere riehenfolge
        for(int a=0;a<9;a++) {
            reihenfolge[a]=reihenfolge[a+1];
        }
        zeichnereihenfolge();
        reihenfolge[9]=zughelp;   
        if(tod[reihenfolge[0]]==true) {
            grafik.kons(kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+" ist Tod");
            try { 
                Thread.sleep(500);                 
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            beendezug();
        }
        grafik.kons("an der Reihe: "+kaempfer[reihenfolge[0]].name+" Team "+team[reihenfolge[0]]+"  (Kämepfer "+reihenfolge[0]+")");
        grafik.markiereaktuell(kepos[reihenfolge[0]]);
        grafik.zeichneinfeld(reihenfolge[0],kepos[reihenfolge[0]],anz[reihenfolge[0]]);

        geheilt=false;      //kontollen zurücksetzen
        gekaempft=false;
        bewegt=false;
        bewhelp=0;
        aktionen=0;
    }

    public void zugreihenfolge() {
        int help1=r.nextInt(2);                                  //Zugreihenfolge wird gewählt
        if(help1==0) {  
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
        else {   
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
                helppos1=r.nextInt(5)*5+1;
            }while(welt[helppos1]!=10);
            welt[helppos1]=a;
            kepos[a]=helppos1;
        }
        for(int b=0;b<5;b++) {
            do {
                helppos1=r.nextInt(5)*5+2;
            }while(welt[helppos1]!=10);
            welt[helppos1]=b+5;
            kepos[b+5]=helppos1;
        }
    }

    public void kontrollesieg() {
        if(tod[0]==true && tod[1]==true && tod[2]==true && tod[3]==true && tod[4]==true) {
            grafik.kons("Verloren");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            grafik.zeichneverloren();
        }else if(tod[5]==true && tod[6]==true && tod[7]==true && tod[8]==true && tod[9]==true) {
            grafik.kons("Sieg");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            grafik.zeichnesieg();
        }
    }

    /** public void hindernisse() {
    helphind=r.nextInt(3); 
    for(int a=0;a<=helphind;a++) {
    feldhind=r.nextInt(3);
    helphind2=r.nextInt(5);
    feldhind=feldhind+helphind2*5+1;
    grafik.zeichnehindernis(feldhind);
    welt[feldhind]=11;
    }
    } **/

    public void decide(int pos) {
        alg = new ALGORITHM(pos,welt,anz);
        alg.decide();
    }

    public int[] getAttack(int pos) {
        alg = new ALGORITHM(pos,welt,anz);
        return alg.getAttackPos();
    }

}
//          try {
//              Thread.sleep(1000);                 
//          } catch(InterruptedException ex) {
//              Thread.currentThread().interrupt();
//          } 
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.Timer;
public class WELT implements MouseListener 
{
    private ZEICHENFENSTER f;
    GRAFIKWELT grafik;
    ALGOGR algsw;
    OBJBILDSCHIRM objschirm;
    KAMPFEINGABE kampf;
    INVENTAR inv;
    Random r;
    Timer t;
    int[] welt,ansicht;
    int[] gegnerpos;
    int genwelthelp,genwelthelp2,bildpos,aktpos,aktansichtpos,genhelpkampf;  
    int zerx ,zery,xzerbew,yzerbew,count=0,helpmonsbew;
    int hp1,hp2=0,hp3=0,help4=0,hp5=0,hp6=0,hp7,hp8,counter;
    boolean anzl,anzo,anzr,anzu,bewl,bewo,bewr,bewu,kongenehmigung=false,wegkont=false,bewegungssperre=false,kontrolleweg=false,quest2=false,mausfreigabe=false;
    double schwerfaktor=1;
    public WELT() {
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        grafik=new GRAFIKWELT();
        algsw=new ALGOGR();
        objschirm=new OBJBILDSCHIRM();
        inv=new INVENTAR();
        r=new Random();
        welt=new int[250000]; 
        ansicht=new int[49]; 
        gegnerpos=new int[250000];
        t = new Timer();
        for(int a=0;a<250000;a++) {
            gegnerpos[a]=101;
        }
        generierestart();            //startpos bei tests ändern
        bildpos=aktpos-1503; 
        aktansichtpos=24;
        grafik.zeichnerahmen();
        generierewelt();
        berechneansicht();
        zeichneansicht();
        anzl=false;
        anzo=false;
        anzr=false;
        anzu=false;
        bewl=false;
        bewo=false;
        bewr=false;
        bewu=false;
        bewegungssperre=false;
        grafik.kordinatenanzeige((aktpos%500)+" : "+(aktpos/500));
    }

    public void bewegen(int richtung) {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kontrollerand();
        grafik.zeichnerahmen();
        switch(richtung) {
            case 0:
            if((aktansichtpos==8 || aktansichtpos==15 || aktansichtpos==22 || aktansichtpos==29 || aktansichtpos==36) && anzl==false) {
                bildpos=bildpos-1;
                aktpos=aktpos-1;
            }else if(bewl==false) {
                aktpos=aktpos-1;
                aktansichtpos=aktansichtpos-1;
            }
            anzr=false;
            bewr=false;
            break;
            case 1:
            if((aktansichtpos==8 || aktansichtpos==9 || aktansichtpos==10 || aktansichtpos==11 || aktansichtpos==12) && anzo==false) {
                bildpos=bildpos-500;
                aktpos=aktpos-500;
            }else if(bewo==false) {
                aktpos=aktpos-500;
                aktansichtpos=aktansichtpos-7;
            }
            anzu=false;
            bewu=false;
            break;
            case 2:
            if((aktansichtpos==12 || aktansichtpos==19 || aktansichtpos==26 || aktansichtpos==33 || aktansichtpos==40) && anzr==false) {
                bildpos=bildpos+1;
                aktpos=aktpos+1;
            }else if(bewr==false) {
                aktpos=aktpos+1;
                aktansichtpos=aktansichtpos+1;
            }
            anzl=false;
            bewl=false;
            break;
            case 3:
            if((aktansichtpos==36 || aktansichtpos==37 || aktansichtpos==38 || aktansichtpos==39 || aktansichtpos==40) && anzu==false) {
                bildpos=bildpos+500;
                aktpos=aktpos+500;
            }else if(bewu==false) {
                aktpos=aktpos+500;
                aktansichtpos=aktansichtpos+7;
            }
            anzo=false;
            bewo=false;
            break;
        } 
        zeichneansicht();
        if(gegnerpos[aktpos]==100) {  //kontrolle gegner
            bewegungssperre=true;
            kampf=new KAMPFEINGABE(inv.anz[0],inv.anz[1],inv.anz[2],inv.anz[3],inv.anz[4],(int)((r.nextInt(300)+20)*schwerfaktor),(int)((r.nextInt(100)+30)*schwerfaktor),(int)((r.nextInt(20)+50)*schwerfaktor),(int)((r.nextInt(50)+20)*schwerfaktor),(int)((r.nextInt(20)+25)*schwerfaktor),inv.heiltrankkl,inv.heiltrankgr);
            while(kampf.sieg!=false || kampf.verloren!=false) {       
            }
            if(kampf.sieg==true) {
                //obj sieg
                bewegungssperre=false;
                schwerfaktor=schwerfaktor+0.4;
            }else if(kampf.verloren==true) {
                //obj game over
            }
        }
        if(welt[aktpos]==26) {                                //ab hier kontrolle obj     //kontrolle  hptst
            grafik.loeschekons();
            bewegungssperre=true;
            objschirm.hauptstadt();  
            mausfreigabe=true;
        }else if(welt[aktpos]==27 && objschirm.kaserne==true) {
            grafik.loeschekons();
            objschirm.kaserne();
            bewegungssperre=true;
            mausfreigabe=true;
            if (hp1==1) {
                schwerfaktor=schwerfaktor+0.05;
            }
        }else if(welt[aktpos]==27 && objschirm.kaserne==false) {
            grafik.kons("Du darfst hier noch nicht rein!");
            grafik.kons("Gehe zur Hauptstadt nach X: "+getpos(26)%500+" Y: "+getpos(26)/500);
        }
        if(kontrolleweg==true) {
            if(welt[aktpos]<26 || welt[aktpos]>39) {
                if(help4==2) {
                    grafik.kons("Quest abgebrochen");
                    help4=0;
                    objschirm.kaserne=false;
                    hp3=0;
                    hp2=0;
                    kontrolleweg=false;
                }else {
                    grafik.kons("bleibe auf dem Weg");
                    help4++;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getX()>59 && e.getX()<209 && e.getY()>94 && e.getY()<107 && mausfreigabe==true) {          //fld1
            if(objschirm.hpt==true) {
                objschirm.kaserne=true;
                hp2++;
                if(hp3==0) {
                    hp3++;
                    grafik.kons("folge dem Weg und Gelange zur Kaserne");
                    kontrolleweg=true;
                    hp8=1;
                }else if(hp8==1) {
                    grafik.kons("Quest bereits angenommen");
                }else if(objschirm.kaserne==true) {
                    grafik.kons("Quest bereits abgeschlossen");
                }
            }else if(objschirm.shp==true) {
                inv.kaufetruppen(0);
            }else if(objschirm.kas==true) {
                if(hp2==1) {
                    grafik.kons("Quest abgeschlossen");
                    try {
                        Thread.sleep(500);                 
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } 
                    grafik.kons("Truppen,Heiltränke und Geld erhalten");
                    inv.anz[0]=inv.anz[0]+100;
                    inv.anz[1]=inv.anz[1]+80;
                    inv.anz[2]=inv.anz[2]+65;
                    inv.anz[3]=inv.anz[3]+50;
                    inv.anz[4]=inv.anz[4]+45;
                    inv.geld=inv.geld+5000;
                    inv.heiltrankkl=inv.heiltrankkl+5;
                    inv.heiltrankgr=inv.heiltrankgr+2;
                    kontrolleweg=false;
                    hp2++;
                    hp5=1;
                    hp8=0;
                }else if(hp5==1) {
                    grafik.kons("Jetzt geh und Töte 10 Gegner");
                    hp6=1;
                }else  if(hp6==1 && counter==10) {
                    grafik.kons("Heiltränke und Geld erhalten");
                    inv.geld=inv.geld+8000;
                    inv.heiltrankkl=inv.heiltrankkl+10;
                    hp6++;                                                            
                }
            }
        }else if(e.getX()>59 && e.getX()<209 && e.getY()>114 && e.getY()<127 && mausfreigabe==true) {    //fld2
            if(objschirm.hpt==true) {
                objschirm.shop();
            }else if(objschirm.shp==true) {
                inv.kaufetruppen(1);
            }else if(objschirm.kas==true) {
                objschirm.shop();
            }
        }else if(e.getX()>59 && e.getX()<209 && e.getY()>134 && e.getY()<147 && mausfreigabe==true) {   //fld3
            if(objschirm.hpt==true || objschirm.kas==true) {
                bewegungssperre=false;
                objschirm.hpt=false;
                ZEICHENFENSTER.gibFenster().loescheAlles();
                grafik.zeichnerahmen();
                zeichneansicht();
                mausfreigabe=false;
            }else if(objschirm.shp==true) {
                inv.kaufetruppen(2);
            }
        }else  if(e.getX()>59 && e.getX()<209 && e.getY()>154 && e.getY()<167 && mausfreigabe==true) {  //fld4
            if(objschirm.shp==true) {
                inv.kaufetruppen(3);
            }
        }else if(e.getX()>59 && e.getX()<209 && e.getY()>174 && e.getY()<187 && mausfreigabe==true) {  //fld5
            if(objschirm.shp==true) {
                inv.kaufetruppen(4);
            }
        }else if(e.getX()>59 && e.getX()<209 && e.getY()>194 && e.getY()<207 && mausfreigabe==true) {  //fld6
            if(objschirm.shp==true) {
                objschirm.hauptstadt();
            }
        }
    }

    public void generierewelt() {          //weltteil darf innerhalb 12 felder nur einmal vorkommen
        welt[0]=r.nextInt(25);             //IdentifikatorNr.1
        do {                               //IdfNR.2
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp);
        welt[1]=genwelthelp;
        do {                                //IdfNR.3
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp || welt[1]==genwelthelp);
        welt[500]=genwelthelp;
        do{                                 //IdfNR.4
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp ||welt[1]==genwelthelp || welt[500]==genwelthelp);
        welt[501]=genwelthelp;
        for(int a=2;a<500;a++) {            //IdfNR.5
            do {
                genwelthelp=r.nextInt(25);
            }while(welt[a-2]==genwelthelp || welt[a-1]==genwelthelp || welt[a+499]==genwelthelp);
            welt[a]=genwelthelp;
            do {                            //IdfNR.5,1
                genwelthelp=r.nextInt(25);
            }while(welt[a+500-2]==genwelthelp || welt[a+500-1]==genwelthelp || welt[a-1]==genwelthelp || welt[a]==genwelthelp || welt[a+1]==genwelthelp);
            welt[a+500]=genwelthelp;
        }
        for(int b=2;b<500;b++) {            //IdfNR.6
            do {
                genwelthelp=r.nextInt(25);
            }while(welt[b*500-1000]==genwelthelp || welt[b*500-500]==genwelthelp || welt[b*500-499]==genwelthelp);
            welt[b*500]=genwelthelp;
            do {                            //IdfNR.6,1
                genwelthelp=r.nextInt(25);
            }while(welt[b*500-1000]==genwelthelp || welt[b*500-500]==genwelthelp || welt[b*500-501]==genwelthelp || welt[b*500-1]==genwelthelp);
            welt[b*500+1]=genwelthelp;
        }
        for(int y=2;y<500;y++) {            //IdfNR.7,*
            for(int x=2;x<500;x++) {        //IdfNR.7
                do {
                    genwelthelp=r.nextInt(25);
                }while(welt[x+y*500-1000]==genwelthelp || welt[x+y*500-2]==genwelthelp || welt[x+y*500-1]==genwelthelp || welt[x+y*500-501]==genwelthelp || welt[x+y*500-500]==genwelthelp || welt[x+y*500-499]==genwelthelp);
                welt[x+y*500]=genwelthelp;
            }
        } 
        for(int a=0;a<500;a++) {   //randzuweisung  
            welt[a]=25;            //oben
            welt[a*500]=25;        //links
            welt[499+a*500]=25;    //rechts
            welt[249500+a]=25;     //unten
        }
        int genwelthelp3=aktpos-1503;                //ab hier für algosw
        do {
            genwelthelp=r.nextInt(7)*7+r.nextInt(7);
        }while((genwelthelp%7)+((genwelthelp/7)*500)+genwelthelp3==aktpos);
        do {
            genwelthelp2=r.nextInt(7)*7+r.nextInt(7);
        }while((genwelthelp2%7)+((genwelthelp2/7)*500)+genwelthelp3==aktpos || (genwelthelp2%7)+((genwelthelp2/7)*500)+genwelthelp3==genwelthelp || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-1 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-501 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-500 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-499 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+1 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+501 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+500 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+499);                                                  
        algsw.eingabestartziel(genwelthelp,genwelthelp2);
        algsw.loese();
        for(int a=0;a<49;a++) {              //richung der wegteile
            if(algsw.pos[a]!=0) {
                switch (algsw.eing[a]) {
                    case 0:
                    switch(algsw.ausg[a]) {
                        case 1:
                        welt[a%7+(a/7)*500+genwelthelp3]=28;   //links oben
                        break;
                        case 2:
                        welt[a%7+(a/7)*500+genwelthelp3]=29;   //links rechts;
                        break;
                        case 3:
                        welt[a%7+(a/7)*500+genwelthelp3]=30;   //links unten
                        break;
                    }
                    break;
                    case 1:
                    switch(algsw.ausg[a]) {
                        case 0:
                        welt[a%7+(a/7)*500+genwelthelp3]=31;  //oben links
                        break;
                        case 2:
                        welt[a%7+(a/7)*500+genwelthelp3]=32;  //oben rechts
                        break;
                        case 3:
                        welt[a%7+(a/7)*500+genwelthelp3]=33;  //oben unten
                        break;
                    }
                    break;
                    case 2:
                    switch(algsw.ausg[a]) {
                        case 0:
                        welt[a%7+(a/7)*500+genwelthelp3]=34;  //rechts links(wie links rechts
                        break;
                        case 1:
                        welt[a%7+(a/7)*500+genwelthelp3]=35;  //rechts oben
                        break;
                        case 3:
                        welt[a%7+(a/7)*500+genwelthelp3]=36;  //rechts unten
                    }
                    break;
                    case 3:
                    switch(algsw.ausg[a]) {
                        case 0:
                        welt[a%7+(a/7)*500+genwelthelp3]=37;  //unten links
                        break;
                        case 1:
                        welt[a%7+(a/7)*500+genwelthelp3]=38;  //unten oben
                        break;
                        case 2:
                        welt[a%7+(a/7)*500+genwelthelp3]=39;  //unten rechts
                        break;
                    }
                }
            }
        }  
        welt[genwelthelp%7+(genwelthelp/7)*500+genwelthelp3]=26;
        welt[genwelthelp2%7+(genwelthelp2/7)*500+genwelthelp3]=27;
        for(int a=0;a<10000;a++) {                                        //generierung von ca. 10000 gegnern 
            do {
                genhelpkampf=r.nextInt(250000);
            }while(welt[genhelpkampf]>=24 || gegnerpos[genhelpkampf]==100);
            gegnerpos[genhelpkampf]=100;
        }
    }

    public void generierestart() {
        int genstart1,genstart2;
        do {
            genstart1=r.nextInt(500);
        }while(genstart1<3 || genstart1>495);
        do {
            genstart2=r.nextInt(500);
        }while(genstart2<3 || genstart2>495);
        aktpos=genstart2*500+genstart1;
    }

    public void zeichneansicht() {
        berechneansicht();
        grafik.loescheansicht();
        grafik.zeichnerahmen();
        if(grafik.str4!="") {
            grafik.konsz3(grafik.str4); 
        }
        if(grafik.str3!="") {
            grafik.konsz2(grafik.str3); 
        }
        if(grafik.str2!="") {
            grafik.konsz(grafik.str2); 
        }
        grafik.kordinatenanzeige((aktpos%500)+" : "+(aktpos/500)); 
        for(int a=0;a<7;a++) {
            for(int b=0;b<7;b++) {
                grafik.weltteil(b,a,ansicht[a*7+b]);
                if(gegnerpos[bildpos+a*500+b]==100) {
                    grafik.weltteil(b,a,100);
                }
            }
        }
        grafik.zeichnespieler(aktansichtpos);
    }

    public void berechneansicht() {      //inhalt wird von welt[] in ansicht[] überschrieben
        if(bildpos<0) {
            bildpos=0;
        }
        if(bildpos>246993) {
            bildpos=246993;
        }
        for(int a=0;a<7;a++) {           //xfelder
            for(int b=0;b<7;b++) {       //yfelder
                ansicht[a*7+b]=welt[bildpos+a*500+b];
            }
        }
    }

    public void zerteileansicht() {
        zerx=bildpos%500;
        zery=bildpos/500;
        xzerbew=(aktpos%500);
        yzerbew=aktpos/500;
    }

    public void kontrollerand() {
        zerteileansicht();
        if(zerx==0) {
            anzl=true;
        }
        if(zery==0) {
            anzo=true;
        }
        if(zerx==493) {
            anzr=true;
        }
        if(zery==493) {
            anzu=true;
        }
        if(xzerbew==1) {
            bewl=true;
        }
        if(yzerbew==1) {
            bewo=true;
        }
        if(xzerbew==498) {
            bewr=true;
        }
        if(yzerbew==498) {
            bewu=true;
        }
    }

    public int getpos(int typ) {
        for(int a=0;a<250000;a++) {
            if(welt[a]==typ) {
                hp7=a;
            }
        }
        return hp7;
    }

    public void inventaraufruf() {
        inv.inventar();
    }

    public void mousePressed(MouseEvent e) 
    {   
    } 

    public void mouseEntered(MouseEvent e) 
    {  
    }  

    public void mouseExited(MouseEvent e) 
    {     
    } 

    public void mouseClicked(MouseEvent e) 
    {
    }
}

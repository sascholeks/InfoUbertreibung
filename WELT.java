import java.util.Random;
public class WELT
{
    GRAFIKWELT grafik;
    ALGOGR algsw;
    OBJBILDSCHIRM objschirm;
    KAMPFEINGABE kampf;
    INVENTAR inv;
    Random r;
    int[] welt,ansicht;
    int genwelthelp,genwelthelp2,bildpos,aktpos,aktansichtpos,genhelpkampf;  
    int zerx ,zery,xzerbew,yzerbew,count=0;
    boolean anzl,anzo,anzr,anzu,bewl,bewo,bewr,bewu,kongenehmigung=false,wegkont=false;
    public WELT() {
        grafik=new GRAFIKWELT();
        algsw=new ALGOGR();
        objschirm=new OBJBILDSCHIRM();
        inv=new INVENTAR();
        r=new Random();
        welt=new int[250000]; 
        ansicht=new int[49]; 
        aktpos=2004;               //startpos bei tests ändern
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
    }
   
    public void bewegen(int richtung) {
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
            if(welt[aktpos]==100) {
                kampf=new KAMPFEINGABE(inv.ausanz[0],inv.ausanz[1],inv.ausanz[2],inv.ausanz[3],inv.ausanz[4],r.nextInt(300)+20,r.nextInt(100+30),r.nextInt(20)+50,r.nextInt(50)+20,r.nextInt(20)+25,inv.heiltrankkl,inv.heiltrankgr);
            }
            if(welt[aktpos]==26) {                                //ab hier kontrolle quests
                objschirm.hauptstadt();
                kongenehmigung=true;
                wegkont=true;
            }else if(welt[aktpos]==27 && kongenehmigung==true) {
                objschirm.stadtmiene();
                wegkont=false;
                }
                
    }
    
    public void inventaraufruf() {
        inv.inventar();
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
        int genwelthelp3=aktpos-1503;                //ab hier für algokor
        do {
            genwelthelp=r.nextInt(7)*7+r.nextInt(7);
        }while((genwelthelp%7)+((genwelthelp/7)*500)+genwelthelp3==aktpos);
        do {
            genwelthelp2=r.nextInt(7)*7+r.nextInt(7);
        }while((genwelthelp2%7)+((genwelthelp2/7)*500)+genwelthelp3==aktpos || (genwelthelp2%7)+((genwelthelp2/7)*500)+genwelthelp3==genwelthelp || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-1 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-501 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-500 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp-499 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+1 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+501 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+500 || ((genwelthelp2/7)*500)+genwelthelp3==genwelthelp+499);                                                  
        algsw.eingabestartziel(genwelthelp,genwelthelp2);
        algsw.loese();
        for(int a=0;a<49;a++) {
            if(algsw.pos[a]!=0) {
                welt[a%7+(a/7)*500+genwelthelp3]=28;
            }
        }
        welt[genwelthelp%7+(genwelthelp/7)*500+genwelthelp3]=26;
        welt[genwelthelp2%7+(genwelthelp2/7)*500+genwelthelp3]=27;
        for(int a=0;a<10000;a++) {
            do {
                genhelpkampf=r.nextInt(250000);
            }while(welt[genhelpkampf]>=24);
            welt[genhelpkampf]=100;
        }
    }
    
    public void zeichneansicht() {
        berechneansicht();
        grafik.loescheansicht();
        for(int a=0;a<7;a++) {
            for(int b=0;b<7;b++) {
                grafik.weltteil(b,a,ansicht[a*7+b]);
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
}

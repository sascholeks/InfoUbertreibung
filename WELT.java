import java.awt.event.*;
import javax.swing.*;
import java.util.Random; 
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class WELT implements MouseListener 
{
    //Timer timer,zeichner;
    GRAFIKGGENERIERUNG grafikgen;
    private ZEICHENFENSTER f;
    MUSIK musik;
    SOUNDAUSWAHL soundausw;
    GRAFIKWELT grafik;
    ALGOGR algsw;
    ALGOGEGNER algge;
    OBJBILDSCHIRM objschirm;
    KAMPFEINGABE kampf;
    ALGOGEGNER alggeg;
    INVENTAR inv;
    MINIGAME game2;
    //COOKIECLICKER clicker;
    Random r;
    int[] welt,ansicht;
    int[] gegnerpos,hp11;
    boolean[] quest,besuchtapfel;
    int genwelthelp,genwelthelp2,bildpos,aktpos,aktansichtpos,genhelpkampf;  
    int zerx ,zery,xzerbew,yzerbew,count=0,helpmonsbew,drfx,drfy,hafx,hafy,weltwertvorher,hptpos;
    int hp1,hp2=0,hp3=0,help4=0,hp5=0,hp6=0,hp7,hp8,hp9=0,hp10,hp12,hp13,hp14,hp15,hp19,hp20,counter,anzap=10,bewegterichtung;
    boolean anzl,anzo,anzr,anzu,bewl,bewo,bewr,bewu,kongenehmigung=false,wegkont=false,bewegungssperre=true,kontrolleweg=false,quest2=false,mausfreigabe=false,hp16,ton=true,kampfton=true,hp21=false;
    boolean ignor=false,boot=false,opttonan=true;
    double schwerfaktor=1;
    String ort1,ort2;
    public WELT() {
        r=new Random();
        //timer = new Timer(10, new ActionListener() {
        //        public void actionPerformed(ActionEvent evt2) {
        //            bewegegegner();
        //        }    
        //    });
        //zeichner = new Timer(1000, new ActionListener() {
        //        public void actionPerformed(ActionEvent evt3) {
        //            try {
        //                zeichneansicht();
        //                Thread.sleep(4000);    
        //                zeichner.stop();
        //            } catch(InterruptedException ex) {
        //                Thread.currentThread().interrupt();
        //            }
        //            zeichner.start();
        //        }    
        //    });
        ZEICHENFENSTER.gibFenster().frame.addMouseListener(this);
        grafikgen=new GRAFIKGGENERIERUNG();
        musik=new MUSIK();
        soundausw=new SOUNDAUSWAHL();
        grafik=new GRAFIKWELT();
        algsw=new ALGOGR();
        algge=new ALGOGEGNER();
        objschirm=new OBJBILDSCHIRM();
        alggeg= new ALGOGEGNER();
        kampf=new KAMPFEINGABE();
        game2=new MINIGAME();
        //clicker=new COOKIECLICKER();
        inv=new INVENTAR();
        r=new Random();
        welt=new int[250000]; 
        ansicht=new int[49]; 
        gegnerpos=new int[250000];
        besuchtapfel=new boolean[250000];
        for(int a=0;a<250000;a++) {
            gegnerpos[a]=101;
        }
        hp11=new int [500];
        generierestart();            //startpos bei tests ändern
        bildpos=aktpos-1503; 
        aktansichtpos=24;
        generierewelt();
        berechneansicht();
        hp14=1;
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
        quest=new boolean[100];
        musik.spiele();
        //timer.start();
        //zeichner.start();
    }

    public void bewegen(int richtung) {
        ZEICHENFENSTER.gibFenster().loescheAlles();
        kontrollerand();
        grafik.zeichnerahmen();
        switch(richtung) {
            case 0:
            if(welt[aktpos-1]==6 && boot==false) {
                break;
            }else {
                if((aktansichtpos==8 || aktansichtpos==15 || aktansichtpos==22 || aktansichtpos==29 || aktansichtpos==36) && anzl==false) {
                    bildpos=bildpos-1;
                    aktpos=aktpos-1;
                }else if(bewl==false) {
                    aktpos=aktpos-1;
                    aktansichtpos=aktansichtpos-1;
                }
            }
            anzr=false;
            bewr=false;
            bewegterichtung=0;
            break;
            case 1:
            if(welt[aktpos-500]==6 && boot==false) {
                break;
            }else {
                if((aktansichtpos==8 || aktansichtpos==9 || aktansichtpos==10 || aktansichtpos==11 || aktansichtpos==12) && anzo==false) {
                    bildpos=bildpos-500;
                    aktpos=aktpos-500;
                }else if(bewo==false) {
                    aktpos=aktpos-500;
                    aktansichtpos=aktansichtpos-7;
                }
            }
            anzu=false;
            bewu=false;
            bewegterichtung=1;
            break;
            case 2:
            if(welt[aktpos+1]==6 && boot==false) {
                break;
            }else {
                if((aktansichtpos==12 || aktansichtpos==19 || aktansichtpos==26 || aktansichtpos==33 || aktansichtpos==40) && anzr==false) {
                    bildpos=bildpos+1;
                    aktpos=aktpos+1;
                }else if(bewr==false) {
                    aktpos=aktpos+1;
                    aktansichtpos=aktansichtpos+1;
                }
            }
            anzl=false;
            bewl=false;
            bewegterichtung=2;
            break;
            case 3:
            if(welt[aktpos+500]==6 && boot==false) {
                break;
            }else {
                if((aktansichtpos==36 || aktansichtpos==37 || aktansichtpos==38 || aktansichtpos==39 || aktansichtpos==40) && anzu==false) {
                    bildpos=bildpos+500;
                    aktpos=aktpos+500;
                }else if(bewu==false) {
                    aktpos=aktpos+500;
                    aktansichtpos=aktansichtpos+7;
                }
            }
            anzo=false;
            bewo=false;
            bewegterichtung=3;
            break;
        } 
        zeichneansicht();
        if(ignor==false) {
            if(welt[aktpos]==26) {                                //ab hier kontrolle obj     //kontrolle  hptst
                grafik.loeschekons();
                bewegungssperre=true;
                objschirm.hauptstadt(quest[0]);  
                mausfreigabe=true;
            }else if(welt[aktpos]==27 && objschirm.kaserne==true) {       //kontrolle kaserne
                grafik.loeschekons();
                objschirm.kaserne(quest[1]);
                bewegungssperre=true;
                mausfreigabe=true;
                if (hp1==1) {
                    schwerfaktor=schwerfaktor+0.05;
                }
            }else if(welt[aktpos]==40) {                                //kontrolle dungeon
                switch(r.nextInt(3)) {
                    case 0:
                    //clicker
                    break;
                    case 1:
                    bewegungssperre=true;
                    game2.spiele();
                    break;
                    case 2:
                    break;
                }
            }else if(welt[aktpos]==42) {                    //kontrolle hafen
                grafik.loeschekons();
                bewegungssperre=true;
                mausfreigabe=true;
                objschirm.hafen(quest[2]);
                hafx=aktpos%500;
                hafy=aktpos/500;
            }else if(welt[aktpos]==27 && objschirm.kaserne==false) {
                grafik.kons("Du darfst hier noch nicht rein!");
                grafik.kons("Gehe zur Hauptstadt nach X: "+getpos(26)%500+" Y: "+getpos(26)/500);
            }else if(welt[aktpos]==41) {                    //kontrolle dorf
                grafik.loeschekons();
                objschirm.dorf();
                bewegungssperre=true;
                mausfreigabe=true;
                drfx=aktpos%500;
                drfy=aktpos/500;
            }
            if(hp21==true && besuchtapfel[aktpos]==false && (welt[aktpos]==3 || welt[aktpos]==5 ||welt[aktpos]==11)) {  //kontrolle apfelbaum
                besuchtapfel[aktpos]=true;
                inv.gesap++;
                grafik.kons("+1 Apfel");
            }
            if(kontrolleweg==true) {
                if((((welt[aktpos]==34 || welt[aktpos]==35 || welt[aktpos]==36) && bewegterichtung!=0) || ((welt[aktpos]==37 || welt[aktpos]==38 || welt[aktpos]==39) && bewegterichtung!=1) || ((welt[aktpos]==28|| welt[aktpos]==29 || welt[aktpos]==30) && bewegterichtung!=2) || ((welt[aktpos]==31 || welt[aktpos]==32 || welt[aktpos]==33) && bewegterichtung!=3)) || (welt[aktpos]<26 || welt[aktpos]>39)) {
                    if(help4==1) {
                        grafik.kons("Quest abgebrochen");
                        help4=0;
                        objschirm.kaserne=false;
                        hp3=0;
                        hp2=0;
                        kontrolleweg=false;
                    }else {
                        grafik.kons("Bleibe auf dem Weg");
                        help4++;
                    }
                }
            }
            if(gegnerpos[aktpos]==100) {  //kontrolle gegner   
                bewegungssperre=true;
                kampf.aktionssperre=false;
                kampf.kampf(inv.anz[0],inv.anz[1],inv.anz[2],inv.anz[3],inv.anz[4],(int)((r.nextInt(300)+20)*schwerfaktor),(int)((r.nextInt(100)+30)*schwerfaktor),(int)((r.nextInt(20)+50)*schwerfaktor),(int)((r.nextInt(50)+20)*schwerfaktor),(int)((r.nextInt(20)+25)*schwerfaktor),inv.heiltrankkl,inv.heiltrankgr,schwerfaktor,kampfton);
                hp16=true;
                musik.stop();
            }
        }
        weltwertvorher=welt[aktpos];  
    }

    public void mouseReleased(MouseEvent e) {
        if(hp16==true && kampf.kampf.sieg==true) {    //weiter
            hp16=false;
            bewegungssperre=false;
            gegnerpos[aktpos]=101;
            inv.anz[0]=inv.anz[0]+kampf.kampf.verlorenanz[0];
            inv.anz[1]=inv.anz[1]+kampf.kampf.verlorenanz[1];
            inv.anz[2]=inv.anz[2]+kampf.kampf.verlorenanz[2];
            inv.anz[3]=inv.anz[3]+kampf.kampf.verlorenanz[3];
            inv.anz[4]=inv.anz[4]+kampf.kampf.verlorenanz[4];
            schwerfaktor=schwerfaktor*1.02;
            kampf.aktionssperre=true;
            if(ton==true) {
                musik.spiele();
            }
        }else if(hp16==true && kampf.kampf.verloren==true) {
            aktpos=hptpos;
            bildpos=aktpos-1503;
            aktansichtpos=24;
            hp16=false;
            bewegungssperre=false;
            inv.anz[0]=0;
            inv.anz[1]=0;
            inv.anz[2]=0;
            inv.anz[3]=0;
            inv.anz[4]=0;
            kampf.aktionssperre=true;
            inv.geld=inv.geld-5000;
            if(inv.geld<0) {
                inv.geld=0;
                boot=false;
            }
            if(ton==true) {
                musik.spiele();
            }
        }
        if(mausfreigabe==true) {
            //zeichner.stop();
            if(e.getX()>59 && e.getX()<209 && e.getY()>94 && e.getY()<107 && mausfreigabe==true) {          //fld1
                if(objschirm.hpt==true) {
                    objschirm.kaserne=true;
                    hp2++;
                    hp13=0;
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
                        hp13=1;
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
                        quest[0]=true;
                    }else if(hp5==1) {
                        hp9=hp9+10;
                        grafik.kons("Geh und Töte 10 Gegner");
                        hp6=1;
                    }else  if(hp6==1 && counter==10) {
                        grafik.kons("Heiltränke und Geld erhalten");
                        inv.geld=inv.geld+8000*(int)hp9/100+1000;
                        inv.heiltrankkl=inv.heiltrankkl+5*(int)hp9/50+2; 
                        hp6=0;
                        hp5=0;
                        counter++;
                        if(counter==10) {
                            quest[1]=true;
                            objschirm.haken();
                        }
                    }else {
                        grafik.kons("Keine Quest angenommen");
                    }
                }else if(objschirm.nav==true) {
                    hp14=0;
                    ort1=(getpos(26)%500)+" : "+(getpos(26)/500);
                    ort2="Hauptstadt";
                    grafik.ortsanzeige(ort1,ort2);
                }else if(objschirm.haf==true) {
                    if(boot==true) {
                        grafik.kons("Du hast bereits ein Boot");
                    }else {
                        if(inv.geld>=5000) {
                            boot=true;
                            inv.geld=inv.geld-5000;
                            quest[2]=true;
                            objschirm.hakenhf();
                        }else {
                            grafik.kons("nicht genug Geld");
                        }
                    }
                }else if(objschirm.drf==true) {
                    if(hp21==false) {
                        grafik.kons("Bringe "+anzap+" Äpfel");
                        hp21=true;
                    }else if(hp21==true) {
                        if(inv.gesap>=anzap) {  
                            grafik.kons("Quest abgeschlossen");
                            inv.geld=inv.geld+anzap*15;
                            inv.gesap=inv.gesap-anzap;
                            hp21=false;
                            anzap=(int)(anzap*schwerfaktor*1.2);
                        }else {
                            grafik.kons("Es fehlen noch "+(anzap-inv.gesap)+ "Äpfel");
                        }
                    }
                }else if(objschirm.esc==true) {
                    bewegungssperre=false;
                    objschirm.hpt=false;
                    ZEICHENFENSTER.gibFenster().loescheAlles();
                    grafik.zeichnerahmen();
                    zeichneansicht();
                    mausfreigabe=false;
                    objschirm.esc=false;
                    objschirm.opt=false;
                }else if(objschirm.opt==true) {
                    if(opttonan==true) {
                        tonaus();
                        opttonan=false;
                        objschirm.optionen(opttonan);
                    }else if(opttonan==false) {
                        tonan();
                        opttonan=true;
                        objschirm.optionen(opttonan);
                    }
                }
                soundausw.play();
            }else if(e.getX()>59 && e.getX()<209 && e.getY()>114 && e.getY()<127 && mausfreigabe==true) {    //fld2
                if(objschirm.hpt==true) {
                    hp13=0;
                    objschirm.shop();
                }else if(objschirm.shp==true) {
                    inv.kaufetruppen(1);
                }else if(objschirm.kas==true) {
                    hp13=1;
                    objschirm.shop();   
                }else if(objschirm.haf==true) {
                    hp13=2;
                    objschirm.shop();
                }else if(objschirm.drf==true) {
                    hp13=3;
                    objschirm.shop();
                }else if(objschirm.nav==true) {
                    hp14=0;
                    ort1=(getpos(27)%500)+" : "+(getpos(27)/500);
                    ort2="Kaserne";
                    grafik.ortsanzeige(ort1,ort2);
                }else if(objschirm.esc==true) {
                    objschirm.optionen(opttonan);
                }
                soundausw.play();
            }else if(e.getX()>59 && e.getX()<209 && e.getY()>134 && e.getY()<147 && mausfreigabe==true) {   //fld3
                if(objschirm.hpt==true || objschirm.kas==true || objschirm.haf==true || objschirm.drf==true) {
                    bewegungssperre=false;
                    objschirm.hpt=false;
                    ZEICHENFENSTER.gibFenster().loescheAlles();
                    grafik.zeichnerahmen();
                    zeichneansicht();
                    mausfreigabe=false;
                    objschirm.hpt=false;
                    objschirm.kas=false;
                    objschirm.haf=false;
                    objschirm.drf=false;
                    //zeichner.start();
                }else if(objschirm.shp==true) {
                    inv.kaufetruppen(2);
                }else if(objschirm.nav==true) {
                    hp14=0;
                    ort1=(hafx+" : "+hafy);
                    ort2="Hafen";
                    grafik.ortsanzeige(ort1,ort2);
                }else if(objschirm.esc==true) {
                    System.exit(0);
                }
                soundausw.play();
            }else  if(e.getX()>59 && e.getX()<209 && e.getY()>154 && e.getY()<167 && mausfreigabe==true) {  //fld4
                if(objschirm.shp==true) {
                    inv.kaufetruppen(3);
                }else if(objschirm.nav==true) {
                    hp14=0;
                    ort1=(drfx+" : "+drfy);
                    ort2="Dorf";
                    grafik.ortsanzeige(ort1,ort2);
                }
                soundausw.play();
            }else if(e.getX()>59 && e.getX()<209 && e.getY()>174 && e.getY()<187 && mausfreigabe==true) {  //fld5
                if(objschirm.shp==true) {
                    inv.kaufetruppen(4);
                }else if(objschirm.nav==true) {
                    hp14=1;
                    grafik.loescheort();    
                }
                soundausw.play();
            }else if(e.getX()>59 && e.getX()<209 && e.getY()>194 && e.getY()<207 && mausfreigabe==true) {  //fld6
                if(objschirm.shp==true && hp13==0) {
                    objschirm.hauptstadt(quest[0]);
                }else if(objschirm.shp==true && hp13==1) {
                    objschirm.kaserne(quest[1]);
                }else if(objschirm.shp==true && hp13==2) {
                    objschirm.hafen(quest[2]);
                }else if(objschirm.shp==true && hp13==3) {
                    objschirm.dorf();
                }else if(objschirm.nav==true) {
                    bewegungssperre=false;
                    objschirm.nav=false;
                    ZEICHENFENSTER.gibFenster().loescheAlles();
                    grafik.zeichnerahmen();
                    zeichneansicht();
                    mausfreigabe=false;
                }else if(objschirm.opt==true) {
                    objschirm.esc();
                }
                soundausw.play();
            }
        }
    }

    public void generierewelt() {  
        //Ph.1
        grafikgen.ph1();
        welt[0]=r.nextInt(25);              //IdentifikatorNr.1
        grafikgen.ph1x1();
        do {                                //IdfNR.2
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp);
        welt[1]=genwelthelp;
        grafikgen.ph1x2();
        do {                                //IdfNR.3
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp || welt[1]==genwelthelp);
        welt[500]=genwelthelp;
        grafikgen.ph1x3();
        do{                                 //IdfNR.4
            genwelthelp=r.nextInt(25);
        }while(welt[0]==genwelthelp ||welt[1]==genwelthelp || welt[500]==genwelthelp);
        welt[501]=genwelthelp;
        grafikgen.ph1x4();
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
        for(int a=0;a<25;a++) {
            grafikgen.ph1x5();
        }
        grafikgen.ph1x51();
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
        grafikgen.ph1x6();
        grafikgen.ph1x61();
        for(int y=2;y<500;y++) {            //IdfNR.7,*
            for(int x=2;x<500;x++) {        //IdfNR.7
                do {
                    genwelthelp=r.nextInt(25);
                }while(welt[x+y*500-1000]==genwelthelp || welt[x+y*500-2]==genwelthelp || welt[x+y*500-1]==genwelthelp || welt[x+y*500-501]==genwelthelp || welt[x+y*500-500]==genwelthelp || welt[x+y*500-499]==genwelthelp);
                welt[x+y*500]=genwelthelp;
            }
        } 
        grafikgen.ph1x7();
        grafikgen.ph1x7X();
        //Ph.2
        grafikgen.ph2();
        for(int a=0;a<250000;a++) {   //entfernung von ein paar Seen
            if(welt[a]==6) {
                welt[a]=r.nextInt(10);  
            }
        }
        for(int a=0;a<250000;a++) {     //kontrolle anz Seen (für Häfen)
            if(welt[a]==6) {
                hp19++;
            }
        }
        for(int b=0;b<=4;b++) {       //wald generierung
            for(int a=0;a<250000;a++) {
                if(welt[a]==3 && a>501 && a<249498) {
                    switch(r.nextInt(3)) {  //typgenerierung
                        case 0:
                        hp12=3;
                        break;
                        case 1:
                        hp12=5;
                        break;
                        case 2:
                        hp12=11;
                        break;
                    }
                    switch(r.nextInt(4)) {  //richtung
                        case 0:
                        welt[a-1]=hp12;
                        break;
                        case 1:
                        welt[a-500]=hp12;
                        break;
                        case 2:
                        welt[a+1]=hp12;
                        break;
                        case 3:
                        welt[a+500]=hp12;
                        break;
                    }
                }
            }
            grafikgen.ph2xWald();
        }
        for(int b=0;b<11;b++) {              //generierung seen
            for(int a=0;a<250000;a++) {
                if(welt[a]==6 && a>501 && a<249498) {
                    switch(r.nextInt(4)) {    //richtung
                        case 0:
                        welt[a-1]=6;
                        break;
                        case 1:
                        welt[a-500]=6;
                        break;
                        case 2:
                        welt[a+1]=6;
                        break;
                        case 3:
                        welt[a+500]=6;
                        break;
                    }
                }
            }
        }
        for(int a=0;a<49;a++) {         //sicherstellen des spwan auf land/insel
            do {
                welt[bildpos+a%7+a/7*500]=r.nextInt(25);
            }while(welt[bildpos+a%7+a/7*500]==6); 
            welt[bildpos+996]=r.nextInt(25);
            welt[bildpos+496]=r.nextInt(25);
            welt[bildpos+2001]=r.nextInt(25);
            welt[bildpos+2002]=r.nextInt(25);
            welt[bildpos+2003]=r.nextInt(25);
            welt[bildpos+2004]=r.nextInt(25);
            welt[bildpos+1504]=r.nextInt(25);
            welt[bildpos+4]=r.nextInt(25);
            grafikgen.ph2xSee();
        }
        for(int a=0;a<500;a++) {   //randzuweisung  
            welt[a]=25;            
            welt[a*500]=25;        
            welt[499+a*500]=25;    
            welt[249500+a]=25;     
        }  
        grafikgen.ph2xRand();
        //Ph.3
        grafikgen.ph3xHafen();
        for(int a=0;a<((int)hp19*1.4);a++) {   //generierung hafen
            do {
                hp20=r.nextInt(248997)+501;
            }while(((welt[hp20-1]==6 && welt[hp20-500]==6 && welt[hp2+1]==6 && welt[hp20+500]==6) || (welt[hp20-1]!=6 && welt[hp20-500]!=6 && welt[hp2+1]!=6 && welt[hp20+500]!=6)) || (welt[hp20-1]==42 ||welt[hp20-500]==42 || welt[hp20+1]==42 || welt[hp20+500]==42));
            welt[hp20]=42;
        }  
        grafikgen.ph3();
        int genwelthelp3=aktpos-1503;                //ab hier für algosw
        do { 
            genwelthelp=r.nextInt(7)*7+r.nextInt(7);
        }while((genwelthelp3%500+(genwelthelp%7))+(genwelthelp/500+(genwelthelp/7))*500==aktpos);
        do {
            genwelthelp2=r.nextInt(7)*7+r.nextInt(7);
        }while(welt[genwelthelp3+genwelthelp2%7+genwelthelp2/7*500]>24 || welt[genwelthelp3+genwelthelp2%7+genwelthelp2/7*500-1]>25 || welt[genwelthelp3+genwelthelp2%7+genwelthelp2/7*500-500]>25 || welt[genwelthelp3+genwelthelp2%7+genwelthelp2/7*500+1]>25 || welt[genwelthelp3+genwelthelp2%7+genwelthelp2/7*500+500]>25);                                               
        algsw.eingabestartziel(genwelthelp,genwelthelp2);
        hptpos=genwelthelp;
        grafikgen.ph3xhpt();
        grafikgen.ph3xKaserne();
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
            grafikgen.ph3xalgosw();
        }  
        for(int a=0;a<1500;a++) {        //generierung dungeon
            do {
                hp15=r.nextInt(250000);
            }while(welt[hp15]>24 || welt[hp15]==6);
            welt[hp15]=40;
        }
        grafikgen.ph3xDungeon();
        welt[genwelthelp%7+(genwelthelp/7)*500+genwelthelp3]=26;
        welt[genwelthelp2%7+(genwelthelp2/7)*500+genwelthelp3]=27;  
        for(int a=0;a<3000;a++) {       //generierung dörfer
            do {
                hp15=r.nextInt(250000);
            }while(welt[hp15]>24);
            welt[hp15]=41;
        }
        for(int a=0;a<10000;a++) {                                        //generierung von 10000 gegnern 
            do {
                genhelpkampf=r.nextInt(23998)+501;
            }while(welt[genhelpkampf]>24 || gegnerpos[genhelpkampf]==100 || welt[genhelpkampf]==6);
            gegnerpos[genhelpkampf]=100;
        }
        grafikgen.ph3xGegner();
        bewegungssperre=false;
    }

    public void generierestart() {
        int genstart1,genstart2;
        do {
            genstart1=r.nextInt(500);
        }while(genstart1<5 || genstart1>493);
        do {
            genstart2=r.nextInt(500);
        }while(genstart2<5 || genstart2>493);
        aktpos=genstart2*500+genstart1;
    }

    public void zeichneansicht() {
        berechneansicht();
        grafik.loescheansicht();
        grafik.zeichnerahmen();
        if(grafik.str4!="") {  //konsole
            grafik.konsz3(grafik.str4); 
        }
        if(grafik.str3!="") {
            grafik.konsz2(grafik.str3); 
        }
        if(grafik.str2!="") {
            grafik.konsz(grafik.str2); 
        }
        grafik.kordinatenanzeige((aktpos%500)+" : "+(aktpos/500)); 
        for(int a=0;a<7;a++) {    //zeichnung bei gegner auf feld
            for(int b=0;b<7;b++) {
                grafik.weltteil(b,a,ansicht[a*7+b]);
                if(gegnerpos[bildpos+a*500+b]==100 && welt[bildpos+a*500+b]!=3 && welt[bildpos+a*500+b]!=5 && welt[bildpos+a*500+b]!=11) {  //kontrolle wald
                    grafik.weltteil(b,a,100);
                }
            }
        }
        for(int a=0;a<49;a++) {            //seerand
            if(welt[(bildpos+a%7+a/7*500)]==6) {
                if(welt[(bildpos+a%7+a/7*500)-1]!=6) {
                    grafik.zeichneufer(a,0);
                }
                if(welt[(bildpos+a%7+a/7*500)-500]!=6) {
                    grafik.zeichneufer(a,1);
                }
                if(welt[(bildpos+a%7+a/7*500)+1]!=6) {
                    grafik.zeichneufer(a,2);
                }
                if(welt[(bildpos+a%7+a/7*500)+500]!=6) {
                    grafik.zeichneufer(a,3);
                }
            }    
        }
        grafik.zeichnespieler(aktansichtpos);
        if(welt[aktpos]==6) {
            grafik.boot(aktansichtpos);
        }
        if(hp14==0) {
            grafik.ortsanzeige(ort1,ort2);
        }
        ZEICHENFENSTER.gibFenster().zeichneText("V Alpha 1.4",630,298);
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

    public void bewegegegner() {
        try {
            for(int a=0;a<249500;a++) {
                if(gegnerpos[a]==100) { 
                    gegnerpos[a]=101;
                    gegnerpos[algge.bewegen(a,welt[a-1],welt[a-500],welt[a+1],welt[a+500])]=100;
                }
            } 
            //timer.stop();
            Thread.sleep(4000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        //timer.start();
    }

    public void navi() {
        objschirm.navi();
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

    public void tonaus() {
        ton=false;
        musik.stop();
        kampfton=false;
        kampf.kampf.musik.stop();
    }

    public void tonan() {
        ton=true;
        musik.spiele();
        kampfton=true;        
    }

    public void tonweltaus() {
        musik.stop();
        ton=false;
    }

    public void inventaraufruf() {
        inv.inventar();
    }

    public void tonkampfaus() {
        kampfton=false;
        kampf.kampf.musik.stop();
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

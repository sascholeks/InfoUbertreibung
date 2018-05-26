import java.util.Random;
public class WELT
{
    GRAFIKWELT grafik;
    Random r;
    int[] welt,ansicht;
    int genwelthelp,bildpos,aktpos,aktansichtpos;   
    public WELT() {
        grafik=new GRAFIKWELT();
        r=new Random();
        welt=new int[250000]; 
        ansicht=new int[49]; 
        aktpos=120000;
        bildpos=aktpos-1503;
        aktansichtpos=24;
        grafik.zeichnerahmen();
        generierewelt();
        berechneansicht();
        zeichneansicht();
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
        for(int a=0;a<7;a++) {           //xfelder
            for(int b=0;b<7;b++) {       //yfelder
                ansicht[a*7+b]=welt[bildpos+a*500+b];
            }
        }
    }
    
    public void bewegen(int richtung) {
        switch(richtung) {
            case 0:
                if(aktansichtpos==8 || aktansichtpos==15 || aktansichtpos==22 || aktansichtpos==29 || aktansichtpos==36) {
                    bildpos=bildpos-1;
                }else {
                    aktpos=aktpos-1;
                    aktansichtpos=aktansichtpos-1;
                }
                break;
            case 1:
                if(aktansichtpos==8 || aktansichtpos==9 || aktansichtpos==10 || aktansichtpos==11 || aktansichtpos==12) {
                    bildpos=bildpos-500;
                }else {
                    aktpos=aktpos-500;
                    aktansichtpos=aktansichtpos-7;
                }
                break;
            case 2:
                if(aktansichtpos==12 || aktansichtpos==19 || aktansichtpos==26 || aktansichtpos==33 || aktansichtpos==40) {
                    bildpos=bildpos+1;
                }else {
                    aktpos=aktpos+1;
                    aktansichtpos=aktansichtpos+1;
                }
                break;
            case 3:
                if(aktansichtpos==36 || aktansichtpos==37 || aktansichtpos==38 || aktansichtpos==39 || aktansichtpos==40) {
                    bildpos=bildpos+500;
                }else {
                    aktpos=aktpos+500;
                    aktansichtpos=aktansichtpos+7;
                }
                break;
        }
        zeichneansicht();
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
    }
}

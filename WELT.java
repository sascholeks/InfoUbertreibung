import java.util.Random;
public class WELT
{
    GRAFIKWELT grafik;
    int[] welt,weltobj,weltbild,objpos;
    boolean[] kontrollerand;
    Random r;
    int genwelthelp,genobj,aktpos;
    public WELT()
    {
        grafik=new GRAFIKWELT();
        r=new Random();
        welt=new int[250002];
        for(int a=0;a<25002;a++) {  //eine zusätzliches feld für befüllen 
            welt[a]=26;
        }
        weltobj=new int[250000];
        for(int a=0;a<250000;a++) {
            weltobj[a]=0;               //bei 0=feri/leer,1=aktpos,2=gegner,>2=alle obj (z.b.dungeons)
        }
        kontrollerand=new boolean[4];
        for(int a=0;a<4;a++) {
            kontrollerand[a]=false;
        }
        objpos=new int[50];
        weltbild=new int[49];
        grafik.zeichnerahmen();
    }
    
    public void generiereWelt() {          //weltteil darf innerhalb 12 felder nur einmal vorkommen
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
        aktpos=12550;
        objpos[0]=aktpos;
    }
    
    public void generiereobj() {
        welt[aktpos]=1;
        int helpgenobj=aktpos-1503;
        do {
            genobj=helpgenobj+(r.nextInt(7)+r.nextInt(7)*500);       
        }while(weltobj[genobj]==1);
        weltobj[genobj]=3;
        objpos[3]=genobj;
        do {
            genobj=helpgenobj+(r.nextInt(7)+r.nextInt(7)*500);
        }while(weltobj[genobj]==1|| weltobj[genobj]==3 || weltobj[genobj-1]==objpos[3] || weltobj[genobj+1]==objpos[3] || weltobj[genobj-500]==objpos[3] || weltobj[genobj+500]==objpos[3]);
    }
    
    public void bewege(int richtung) {
        switch (richtung) {
            case 0:
                if(welt[aktpos-1]==26  && kontrollerand[0]==false) {
                    weltobj[aktpos]=0;
                    aktpos=aktpos-1;
                    kontrollerand[2]=false;
                }else if(kontrollerand[0]==true) {
                    grafik.kons("oberer rand erreicht");
                }else {
                    grafik.kons("Feld nicht Frei");
                }
                break;   
            case 1:
                if(welt[aktpos-500]==26 && kontrollerand[1]==false) {
                    weltobj[aktpos]=0;
                    aktpos=aktpos-500;
                    kontrollerand[3]=false;
                    if(aktpos<500) {
                        kontrollerand[1]=true;
                    }
                }else if(kontrollerand[1]==true) {
                    grafik.kons("oberer rand erreicht");                
                }else {
                    grafik.kons("Feld nicht Frei");
                }
                break; 
            case 2:
                if(welt[aktpos+1]==26) {
                    weltobj[aktpos]=0;
                    aktpos=aktpos+1;
                    kontrollerand[0]=false;
                }else {
                    grafik.kons("Feld nicht Frei");
                }
                break; 
            case 3: 
                if(welt[aktpos+500]==26 && kontrollerand[3]==false) {
                    weltobj[aktpos]=0;
                    aktpos=aktpos+500;
                    kontrollerand[1]=false;
                    if(aktpos<500) {
                        kontrollerand[1]=true;
                    }
                }else if(kontrollerand[1]==true) {
                    grafik.kons("oberer rand erreicht");               
                }else {
                    grafik.kons("Feld nicht Frei");
                }
                break; 
            default:
                grafik.kons("ungültige Eingabe");
                break;
        }
    }
}








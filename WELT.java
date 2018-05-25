import java.util.Random;
public class WELT
{
    GRAFIKWELT grafik;
    int[] welt,weltbild;
    boolean[] kontrollerand;
    Random r;
    int genwelthelp,aktpos;
    public WELT()
    {
        grafik=new GRAFIKWELT();
        r=new Random();
        welt=new int[25001];
        for(int a=0;a<25001;a++) {  //eine zusätzliches feld für befüllen 
            welt[a]=26;
        }
        kontrollerand=new boolean[4];
        for(int a=0;a<4;a++) {
            kontrollerand[a]=false;
        }
        weltbild=new int[49];
        aktpos=r.nextInt(25000);
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
        for(int a=2;a<500;a++) {            //IdfNR.6
            do {
                genwelthelp=r.nextInt(25);
            }while(welt[a*500-1000]==genwelthelp || welt[a*500-500]==genwelthelp || welt[a*500-499]==genwelthelp);
            welt[a*500]=genwelthelp;
            do {                            //IdfNR.6,1
                genwelthelp=r.nextInt(25);
            }while(welt[a*500-1000]==genwelthelp || welt[a*500-500]==genwelthelp || welt[a*500-501]==genwelthelp || welt[a*500-1]==genwelthelp);
            welt[a*500+1]=genwelthelp;
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
    
    public void bewege(int richtung) {
        switch (richtung) {
            case 0:
                if(welt[aktpos-1]==26  && kontrollerand[0]==false) {
                    welt[aktpos]=26;
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
                    welt[aktpos]=26;
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
                    welt[aktpos]=26;
                    aktpos=aktpos+1;
                    kontrollerand[0]=false;
                }else {
                    grafik.kons("Feld nicht Frei");
                }
                break; 
            case 3: 
                if(welt[aktpos+500]==26 && kontrollerand[3]==false) {
                    welt[aktpos]=26;
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








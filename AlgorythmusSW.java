import java.util.Random;
public class AlgorythmusSW
{
    private Random r;
    private boolean[] feld;    
    private boolean[] mgrg;                           //mögliche richtungen die ausgegeben werden könnten
    
    int start;
    int ziel;
    int aktfeld;   
    
    public AlgorythmusSW()
    {
       r=new Random();
       mgrg=new boolean[4];
       for(int a=0;a<4;a++) {
           mgrg[a]=false;
       }       
       feld=new boolean[49];
       for(int a=0;a<49;a++) {
           feld[a]=false;              //feld benutzt = false
        }
       start=r.nextInt(49);
       aktfeld=start;                 //aktuelle position = startpunkt
       feld[start]=true;              //startpunkt
       do {
           ziel=r.nextInt(49);
       } while(ziel==start);
    }
     
    public void kontrolle(int rnd) {                                               //kontrolle rand und benutzt und ziel        
        switch(rnd) {
            case 0:
                if(mgrg[0]==false){
                    if(aktfeld==0 || aktfeld==7 || aktfeld==14 || aktfeld==21 || aktfeld==28 || aktfeld==35 || aktfeld==42) {
                        mgrg[0]=true;
                    }
                    else if(feld[(aktfeld-1)]==true && mgrg[0]==false) {
                        mgrg[0]=true;
                    }   
                    else if(mgrg[0]==false){
                        aktfeld--;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                    }
                }
                break;
            case 1:
                if(mgrg[1]==false) {
                    if(aktfeld==0 || aktfeld==1 || aktfeld==2 || aktfeld==3 || aktfeld==4 || aktfeld==5 || aktfeld==6) {
                        mgrg[1]=true;
                    }
                    else if(feld[(aktfeld-7)]==true && mgrg[1]==false) {
                        mgrg[1]=true;
                    }
                    else if(mgrg[1]==false){
                        aktfeld=aktfeld-7;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                    }
                }
                break;
            case 2:
                if(mgrg[2]==false) {
                    if(aktfeld==6 || aktfeld==13 || aktfeld==20 || aktfeld==27 || aktfeld==34 || aktfeld==41 || aktfeld==48) {
                        mgrg[2]=true;
                    }
                    else if(feld[(aktfeld+1)]==true && mgrg[2]==false) {
                        mgrg[2]=true;
                    }
                    else if(mgrg[2]==false){
                        aktfeld=aktfeld+1;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                    }
                }
                break;
            case 3:
                if (mgrg[3]==false) {
                    if(aktfeld==42 || aktfeld==43 || aktfeld==44 || aktfeld==45 || aktfeld==46 || aktfeld==47 || aktfeld==48) {
                        mgrg[3]=true;
                    }
                    else if(feld[(aktfeld+7)]==true && mgrg[3]==false) {
                        mgrg[3]=true;
                    }
                    else if(mgrg[3]==false){
                        aktfeld=aktfeld+7;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                    }
                }
                break;
        }      
    }
    
    public void loese() {    
        while(aktfeld!=ziel) {
            kontrolle(r.nextInt(4));
            if(mgrg[0]==true && mgrg[1]==true && mgrg[2]==true && mgrg[3]==true) {
                for(int a=0;a<49;a++) {
                    feld[a]=false;
                }
                feld[start]=true;
                aktfeld=start;
                for(int a=0;a<4;a++) {
                    mgrg[a]=false;
                }                            
            }   
        }      
        for(int a=0;a<49;a++) {
            feld[a]=false;
        }
        feld[start]=true;
        aktfeld=start;
    }
    
    public void aendereobj(int starta ,int ziela) {
        feld[start]=false;
        start=starta;
        feld[start]=true;
        ziel=ziela;
        aktfeld=start;       
    }
}

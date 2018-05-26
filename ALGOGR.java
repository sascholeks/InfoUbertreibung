import java.util.Random;
public class ALGOGR {                           //graphische Klasse vonTESTLÖSUNGSALGO
    private Random r;
    GRAFIKWELT grafik;
    private boolean[] feld;    
    private boolean[] mgrg;                           //mögliche richtungen die ausgegeben werden könnten
    int[] pos;
    int start;
    int ziel;
    int aktfeld;   
    int xzer=0, yzer=0; 
    int helpa=0, helpb=0,c=0;
    public ALGOGR() {
        r=new Random();
        grafik=new GRAFIKWELT();
        pos=new int[49];
        for(int a=0;a<49;a++) {
            pos[a]=0;
        }
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
        zeichen();
    }
    
    public void eingabestartziel(int start,int ziel) {
        this.start=start;
        this.ziel=ziel;
        aktfeld=start;                 //aktuelle position = startpunkt
        feld[start]=true;              //startpunkt
    }
    
    public void zeichen() {                       //graphische klasse
       zerlegefeld(start);
       helpa=xzer;
       helpb=yzer;
       zerlegefeld(ziel);
    }
    
    public void kontrolle(int rnd) {                                               //kontrolle rand und benutzt und ziel        
        switch(rnd) {
            case 0:
                if(mgrg[0]==false){
                    if(aktfeld==0 || aktfeld==7 || aktfeld==14 || aktfeld==21 || aktfeld==28 || aktfeld==35 || aktfeld==42) {
                        mgrg[0]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(feld[(aktfeld-1)]==true && mgrg[0]==false) {
                        mgrg[0]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }   
                    else if(mgrg[0]==false){
                        aktfeld--;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }  
                        zerlegefeld(aktfeld);                  //graphisches Element
                        pos[c]=aktfeld;
                        c++;
                    }
                }
                break;
            case 1:
                if(mgrg[1]==false) {
                    if(aktfeld==0 || aktfeld==1 || aktfeld==2 || aktfeld==3 || aktfeld==4 || aktfeld==5 || aktfeld==6) {
                        mgrg[1]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(feld[(aktfeld-7)]==true && mgrg[1]==false) {
                        mgrg[1]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[1]==false){
                        aktfeld=aktfeld-7;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);                     //graphisches Element
                        pos[c]=aktfeld;
                        c++;
                    }
                }
                break;
            case 2:
                if(mgrg[2]==false) {
                    if(aktfeld==6 || aktfeld==13 || aktfeld==20 || aktfeld==27 || aktfeld==34 || aktfeld==41 || aktfeld==48) {
                        mgrg[2]=true;   
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(feld[(aktfeld+1)]==true && mgrg[2]==false) {
                        mgrg[2]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[2]==false){
                        aktfeld=aktfeld+1;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);                 //graphisches Element
                        pos[c]=aktfeld;
                        c++;
                    }
                }
                break;
            case 3:
                if (mgrg[3]==false) {
                    if(aktfeld==42|| aktfeld==43 || aktfeld==44 || aktfeld==45 || aktfeld==46 || aktfeld==47 || aktfeld==48) {
                        mgrg[3]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(feld[(aktfeld+7)]==true && mgrg[3]==false) {
                        mgrg[3]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[3]==false){
                        aktfeld=aktfeld+7;
                        feld[aktfeld]=true;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);  //graphisches Element
                        pos[c]=aktfeld;
                        c++;
                    }
                }
                break;
        }      
    }
    
    public void loese() {   
            zeichen(); 
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
                    c=0;
                    zeichen();                                 //graphisches element          
                }   
            }  
            for(int a=0;a<49;a++) {
                feld[a]=false;
            }
            feld[start]=true;
            aktfeld=start;

    }

    public void zerlegefeld(int feld) {                                                      //graphische methode
        yzer=feld/7;
        xzer=feld%7;
    }
}
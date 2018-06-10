import java.util.Random;
public class ALGOGR {                           //graphische Klasse vonTESTLÖSUNGSALGO
    private Random r;
    private boolean[] mgrg;                           //mögliche richtungen die ausgegeben werden könnten
    int[] pos,eing,ausg;  
    int start;
    int ziel;
    int aktfeld;   
    int xzer=0, yzer=0; 
    int helpa=0, helpb=0,c=0;
    public ALGOGR() {
        r=new Random();
        pos=new int[49];
        eing=new int[49];
        ausg=new int[49];
        for(int a=0;a<49;a++) {
            pos[a]=0;
            eing[a]=4;
            ausg[a]=4;
        }
        mgrg=new boolean[4];
        for(int a=0;a<4;a++) {
            mgrg[a]=false;
        }
        start=r.nextInt(49);
        aktfeld=start;                 //aktuelle position = startpunkt
        do {
            ziel=r.nextInt(49);
        } while(ziel==start);
    }
    
    public void eingabestartziel(int start,int ziel) {
        this.start=start;
        this.ziel=ziel;
        aktfeld=start;                 //aktuelle position = startpunkt
        pos[start]=26;              //startpunkt
    } 
    
    public void kontrolle(int rnd) {                                               //kontrolle rand und benutzt und ziel        
        switch(rnd) {
            case 0:
                if(mgrg[0]==false){
                    if(aktfeld==0 || aktfeld==7 || aktfeld==14 || aktfeld==21 || aktfeld==28 || aktfeld==35 || aktfeld==42) {
                        mgrg[0]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(pos[(aktfeld-1)]!=0 && mgrg[0]==false) {
                        mgrg[0]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }   
                    else if(mgrg[0]==false){
                        ausg[aktfeld]=0;
                        aktfeld--;
                        eing[aktfeld]=2;
                        pos[aktfeld]=28;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }  
                        zerlegefeld(aktfeld);                  //graphisches Element
                    }
                }
                break;
            case 1:
                if(mgrg[1]==false) {
                    if(aktfeld==0 || aktfeld==1 || aktfeld==2 || aktfeld==3 || aktfeld==4 || aktfeld==5 || aktfeld==6) {
                        mgrg[1]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(pos[(aktfeld-7)]!=0 && mgrg[1]==false) {
                        mgrg[1]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[1]==false){
                        ausg[aktfeld]=1;
                        aktfeld=aktfeld-7;
                        eing[aktfeld]=3;
                        pos[aktfeld]=28;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);                     //graphisches Element
                    }
                }
                break;
            case 2:
                if(mgrg[2]==false) {
                    if(aktfeld==6 || aktfeld==13 || aktfeld==20 || aktfeld==27 || aktfeld==34 || aktfeld==41 || aktfeld==48) {
                        mgrg[2]=true;   
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(pos[(aktfeld+1)]!=0 && mgrg[2]==false) {
                        mgrg[2]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[2]==false){
                        ausg[aktfeld]=2;
                        aktfeld=aktfeld+1;
                        eing[aktfeld]=0;
                        pos[aktfeld]=28;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);                 //graphisches Element
                    }
                }
                break;
            case 3:
                if (mgrg[3]==false) {
                    if(aktfeld==42|| aktfeld==43 || aktfeld==44 || aktfeld==45 || aktfeld==46 || aktfeld==47 || aktfeld==48) {
                        mgrg[3]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(pos[(aktfeld+7)]!=0 && mgrg[3]==false) {
                        mgrg[3]=true;
                        zerlegefeld(aktfeld);                                    //graphisches Element
                    }
                    else if(mgrg[3]==false){
                        ausg[aktfeld]=3;
                        aktfeld=aktfeld+7;
                        eing[aktfeld]=1;
                        pos[aktfeld]=28;
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        zerlegefeld(aktfeld);  //graphisches Element
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
                    pos[a]=0;
                }
                pos[start]=26;
                aktfeld=start;
                for(int a=0;a<4;a++) {
                    mgrg[a]=false;
                }
                c=0;       
            }   
        }  
    }

    public void zerlegefeld(int feld) {                                                      //graphische methode
        yzer=feld/7;
        xzer=feld%7;
    }
}
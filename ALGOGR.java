import java.util.Random;

public class ALGOGR {                           //graphische Klasse vonTESTLÖSUNGSALGO
    
    private Random r;
    private WELTALGO alg;
    private boolean[] feld;    
    private boolean[] mgrg;                           //mögliche richtungen die ausgegeben werden könnten
    
    int start;
    int ziel;
    int aktfeld;   
    int xzer=0, yzer=0;
    
    int helpa=0, helpb=0,farbn=11;
    public ALGOGR() {
       r=new Random();
       alg=new WELTALGO();
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
       
       System.out.println("");
       System.out.println("blauer Kasten = Start");
       System.out.println("grauer Kreis = Ziel");
       System.out.println("  hellblaue-rote Punkte=Weg");
       System.out.println("    rote Makierungen = Versuch über Feldende zu gehen");
       System.out.println("    gelbe Makierungen = Versuch auf ein bereits belegtes Feld zu gehen");
    }
    
    public void zeichen() {                       //graphische klasse
       for(int a=0;a<7;a++) {
          for(int b=0;b<7;b++) {
              alg.loesche(a,b);
            }
       }
       zerlegefeld(start);
       helpa=xzer;
       helpb=yzer;
       zerlegefeld(ziel);
       alg.zeichneobj(helpa,helpb,xzer,yzer);
    }
    
    public void kontrolle(int rnd) {                                               //kontrolle rand und benutzt und ziel        
        switch(rnd) {
            case 0:
                if(mgrg[0]==false){
                    if(aktfeld==0 || aktfeld==5 || aktfeld==10 || aktfeld==15 || aktfeld==20) {
                        mgrg[0]=true;
                        System.out.println("am linken Rand angekommen");
                        
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testeRand(0,xzer,yzer);
                    }
                    else if(feld[(aktfeld-1)]==true && mgrg[0]==false) {
                        mgrg[0]=true;
                        System.out.println("linkes Feld bereits benutzt");   //loeschen
                        
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testebenutzt(0,xzer,yzer);
                    }   
                    else if(mgrg[0]==false){
                        aktfeld--;
                        feld[aktfeld]=true;
                        System.out.println("aktuell: "+aktfeld);
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        
                        zerlegefeld(aktfeld);                  //graphisches Element
                        alg.setzeWeg(xzer,yzer,farbn);
                        farbn++;
                    }
                }
                break;
            case 1:
                if(mgrg[1]==false) {
                    if(aktfeld==0 || aktfeld==1 || aktfeld==2 || aktfeld==3 || aktfeld==4) {
                        mgrg[1]=true;
                        System.out.println("am oberen Rand angekommen");
                         
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testeRand(1,xzer,yzer);
                    }
                    else if(feld[(aktfeld-5)]==true && mgrg[1]==false) {
                        mgrg[1]=true;
                        System.out.println("oberes Feld bereits benutzt");
                        
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testebenutzt(1,xzer,yzer);
                    }
                    else if(mgrg[1]==false){
                        aktfeld=aktfeld-5;
                        feld[aktfeld]=true;
                        System.out.println("aktuell: "+aktfeld);
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        
                        zerlegefeld(aktfeld);                     //graphisches Element
                        alg.setzeWeg(xzer,yzer,farbn);
                        farbn++;
                    }
                }
                break;
            case 2:
                if(mgrg[2]==false) {
                    if(aktfeld==4 || aktfeld==9 || aktfeld==14 || aktfeld==19 || aktfeld==24) {
                        mgrg[2]=true;
                        System.out.println("am rechten Rand angekommen");
                         
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testeRand(2,xzer,yzer);
                    }
                    else if(feld[(aktfeld+1)]==true && mgrg[2]==false) {
                        mgrg[2]=true;
                        System.out.println("rechtes Feld bereits benutzt");
                        
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testebenutzt(2,xzer,yzer);
                    }
                    else if(mgrg[2]==false){
                        aktfeld=aktfeld+1;
                        feld[aktfeld]=true;
                        System.out.println("aktuell: "+aktfeld);
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        
                        zerlegefeld(aktfeld);                 //graphisches Element
                        alg.setzeWeg(xzer,yzer,farbn);
                        farbn++;
                    }
                }
                break;
            case 3:
                if (mgrg[3]==false) {
                    if(aktfeld==20 || aktfeld==21 || aktfeld==22 || aktfeld==23 || aktfeld==24) {
                        mgrg[3]=true;
                        System.out.println("am unteren Rand angekommen");
                         
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testeRand(3,xzer,yzer);
                    }
                    else if(feld[(aktfeld+5)]==true && mgrg[3]==false) {
                        mgrg[3]=true;
                        System.out.println("unteres Feld bereits benutzt");
                        
                        zerlegefeld(aktfeld);                                    //graphisches Element
                        alg.testebenutzt(3,xzer,yzer);
                    }
                    else if(mgrg[3]==false){
                        aktfeld=aktfeld+5;
                        feld[aktfeld]=true;
                        System.out.println("aktuell: "+aktfeld);
                        for(int a=0;a<4;a++) {
                            mgrg[a]=false;
                        }
                        
                        zerlegefeld(aktfeld);  //graphisches Element
                        alg.setzeWeg(xzer,yzer,farbn);
                        farbn++;
                    }
                }
                break;
        }      
    }
    
    public void loese() {    
        zeichen();
        
        System.out.println("");
        System.out.println("start: "+start+ " | Ziel: "+ziel);
        System.out.println("");
        

        while(aktfeld!=ziel) {
            kontrolle(r.nextInt(4));
            if(mgrg[0]==true && mgrg[1]==true && mgrg[2]==true && mgrg[3]==true) {
                for(int a=0;a<25;a++) {
                    feld[a]=false;
                }
                feld[start]=true;
                aktfeld=start;
                for(int a=0;a<4;a++) {
                    mgrg[a]=false;
                }
                System.out.println("");
                System.out.println("Keine möglichen Wege");
                System.out.println("fange von Vorne an");
                System.out.println("");
                farbn=11;
                zeichen();                                 //graphisches element          
            }   
        }
        
        for(int a=0;a<25;a++) {
            feld[a]=false;
        }
        feld[start]=true;
        aktfeld=start;
        System.out.println("Ziel erreicht");
        farbn=11;
    }
    
    public void aendereobj(int starta ,int ziela) {
        for(int a=0;a<5;a++) {                                                                //graphisches Element
            for(int b=0;b<5;b++) {
                alg.loesche(b,a);
            }
        }
        feld[start]=false;
        start=starta;
        feld[start]=true;
        ziel=ziela;
        aktfeld=start;       
        zeichen();
    }
 
    public void zerlegefeld(int feld) {                                                      //graphische methode
        yzer=feld/5;
        xzer=feld%5;
    }
    
    public void fun(int lengh) {
        for(int a=0;a<lengh;a++) {
            loese();
            try {
                Thread.sleep(1000);                 
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
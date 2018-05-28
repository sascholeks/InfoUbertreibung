import java.util.Random;
public class ALGOLEUTE
{
    Random r;
    int aktionsauswahl,richtung,posfaktor,aktpos;
    int xzer,yzer;
    boolean konpause=false,bewu,bewo,bewl,bewr;
    public ALGOLEUTE()
    {
       r=new Random();
    }
    
    public void aktion() {
        aktionsauswahl=r.nextInt(7);
        switch(aktionsauswahl) {
            case 0:                  //case 0&1=pause
            if(konpause==true){
                aktion();
                break;
            }
            case 1:
                konpause=true;
                break;
            case 2:                 //case 2,3&4=bewegen
            case 3:    
            case 4:
                aktpos=aktpos+posfaktor;
                break;
            case 5:                 //case 5&6=drehen
            case 6:
                richtung=r.nextInt(4);
                switch (richtung) {
                    case 0:
                        if(bewl==true) {
                            aktion();
                        }else {
                            posfaktor=-1;
                            bewr=false;
                            break;
                        }
                        posfaktor=0;
                        break;
                    case 1:
                        if(bewo==true) {
                            aktion();
                        }else {
                            posfaktor=-500;
                            bewu=false;
                            break;
                        }
                        posfaktor=0;
                        break;
                    case 2:
                        if(bewr==true) {
                            aktion();
                        }else {
                            posfaktor=+1;
                            bewl=false;
                            break;
                        }
                        posfaktor=0;
                        break;
                    case 3:
                        if(bewu==true) {
                            aktion();
                        }else {
                            posfaktor=+500;
                            bewo=false;
                            break;
                        }
                        posfaktor=0;
                        break;
                }
                aktpos=aktpos+posfaktor;
                break;
        }
        kontrollerand();
    }
    
    public void kontrollerand() {
        xzer=(aktpos%500);
        yzer=aktpos/500;
        if(xzer==1) {
            bewl=true;
        }
        if(yzer==1) {
            bewo=true;
        }
        if(xzer==498) {
            bewr=true;
        }
        if(yzer==498) {
            bewu=true;
        }
    }
}

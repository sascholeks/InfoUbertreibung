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
    
    public void aktion(int aktfeld) {
        kontrollerand(aktfeld);
        switch(r.nextInt(4)) {
            case 0:
                if(bewl==false)  {
                    bewr=false;
                    aktfeld=aktfeld-1;
                }
                break;
            case 1:
                if(bewo==false)  {
                    bewu=false;
                    aktfeld=aktfeld-500;
                }
                break;
            case 2:
                if(bewr==false)  {
                    bewl=false;
                    aktfeld=aktfeld+1;
                }
                break;
            case 3:
                if(bewu==false)  {
                    bewo=false;
                    aktfeld=aktfeld+500;
                }
                break;
        }
    }
    
    public void kontrollerand(int fedl) {
        xzer=(fedl%500);
        yzer=fedl/500;
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

import java.util.Random;
public class MUSIK
{
    SOUNDMUSIKwelt1 mu1;
    SOUNDMUSIKwelt2 mu2;
    SOUNDMUSIKwelt3 mu3;
    Random r;
    int zufall;
    boolean[] gespielt;
    public MUSIK()
    {
        mu1=new SOUNDMUSIKwelt1();
        mu2=new SOUNDMUSIKwelt2();
        mu3=new SOUNDMUSIKwelt3();
        r=new Random();
        gespielt=new boolean[3];
    }

    public void spiele() {
        do {
            zufall=r.nextInt(3);
        }while(gespielt[zufall]==true);
        switch(zufall) {
            case 0:
                mu2.stop();
                mu3.stop();
                gespielt[0]=true;
                mu1.play();
                break;
            case 1:
                mu1.stop();
                mu3.stop();
                gespielt[1]=true;
                mu2.play();
                break;
            case 2:
                mu1.stop();
                mu2.stop();
                gespielt[2]=true;
                mu3.play();
                break;
        }
    }
    
    public void stop() {
        mu1.stop();
        mu2.stop();
        mu3.stop();
    }
}

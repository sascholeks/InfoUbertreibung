import java.util.Random;
public class ALGOGEGNER
{
    Random r;
    int neupos;
    public ALGOGEGNER()
    {
        r=new Random();
    }

    public int bewegen(int pos) {
        switch(r.nextInt(7)) {
            case 0:
                neupos=pos-1;
                break;
            case 1:
                neupos=pos-500;
                break;
            case 2:
                neupos=pos+1;
                break;
            case 3:
                neupos=pos+500;
                break;
            case 4:     //für 4,5 und 6 nichts tun
            case 5:
            case 6:
                neupos=pos;
                break;
        }
        return neupos;
    }   
}






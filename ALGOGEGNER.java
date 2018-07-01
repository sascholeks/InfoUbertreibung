import java.util.Random;
public class ALGOGEGNER
{
    Random r;
    int neupos;
    public ALGOGEGNER()
    {
        r=new Random();
    }

    public int bewegen(int pos,int links,int oben,int rechts,int unten) {
        switch(r.nextInt(7)) {
            case 0:
                if(links<25 && links!=6) {
                    neupos=pos-1;
                }else {
                    bewegen(pos,links,oben,rechts,unten);
                }        
                break;
            case 1:
                if(links<25 && links!=6) {
                    neupos=pos-500;
                }else {
                    bewegen(pos,links,oben,rechts,unten);
                }   
                break;
            case 2:
                if(links<25 && links!=6) {
                    neupos=pos+1;
                }else {
                    bewegen(pos,links,oben,rechts,unten);
                }   
                break;
            case 3:
                if(links<25 && links!=6) {
                    neupos=pos+500;
                }else {
                    bewegen(pos,links,oben,rechts,unten);
                }   
                break;
            case 4:     //für 4,5 und 6 nichts tun
            case 5:
            case 6:
                neupos=pos;
                break;
        }
        System.out.println(neupos+"---");
        return neupos;
    }   
}






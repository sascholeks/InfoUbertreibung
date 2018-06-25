import java.util.Random;
public class ALGOGEGNER
{
    Random r;
    public ALGOGEGNER()
    {
       r=new Random();
    }

    public void bewegen(int pos) {
        switch(r.nextInt(7)) {
            case 0:
                if(pos%500>1) {
                    pos=pos-1;
                }else {
                    bewegen(pos);
                }
                break;
            case 1:
                if(pos/500>1) {
                    pos=pos-500;
                }else {
                    bewegen(pos);
                }
                break;
            case 2:
                if(pos%500<498) {
                    pos=pos+1;
                }else {
                    bewegen(pos);
                }
                break;
            case 3:
                if(pos/500<498) {
                    pos=pos+500;
                }else {
                    bewegen(pos);
                }
                break;
            case 4:      //case 4,5 und 6 =warten
            case 5:
            case 6:
                break;
        }
    }
    
    
}






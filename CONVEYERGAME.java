import java.util.Random;
public class CONVEYERGAME
{
    Random r;
    GRAFIKELEMENTE grafik;
    public CONVEYERGAME()
    {
        r=new Random();
        grafik=new GRAFIKELEMENTE();
        
        grafik.conveyeransicht();
    }

   
}

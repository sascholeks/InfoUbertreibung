import java.util.Random;

public class GEGNERINVENTAR
{
    Random r;
    int anz0=30,anz1=15,anz2=12,anz3=5,anz4=3;
    public GEGNERINVENTAR()
    {
        r=new Random();
        anz0=r.nextInt(30)+20;
        anz1=r.nextInt(20)+35;
        anz2=r.nextInt(30)+25;
        anz3=r.nextInt(25)+12;
        anz4=r.nextInt(20)+2;
    }
}

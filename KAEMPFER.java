
public class KAEMPFER
{
    String name;
    public int leben;
    public int dmg;
    public static int UUID;
    public int type;
    public KAEMPFER(int type)
    {
        switch (type) {
            case 0:
            name="Bogenschütze";
            leben=40;
            dmg=55;
            break;
            case 1:
            name="Speerkämpfer";
            leben=60;
            dmg=40;
            break;
            case 2:
            name="Schildknappe";
            leben=75;
            dmg=20;
            break;
            case 3:
            name="Ritter";
            leben=60;
            dmg=30;
            break;
            case 4:
            name="Paladin";
            leben=100;
            dmg=35;
            break;
        }
    }
}


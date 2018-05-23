
public class KAEMPFER
{
    String name;
    int leben;
    int dmg;
    public KAEMPFER(int typ)
    {
        switch (typ) {
            case 0:
                name="Bogenschütze";
                leben=70;
                dmg=50;
                break;
            case 1:
                name="Speerkämpfer";
                leben=80;
                dmg=40;
                break;
            case 2:
                name="Schildknappe";
                leben=140;
                dmg=35;
                break;
            case 3:
                name="Ritter";
                leben=120;
                dmg=50;
                break;
            case 4:
                name="Paladin";
                leben=150;
                dmg=70;
                break;
            }
    }
}



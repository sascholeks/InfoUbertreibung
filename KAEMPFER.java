
public class KAEMPFER
{
    String name;   
    int leben,dmg;
    public String name(int typ) {
        switch (typ) {
            case 0:
                name=("Bogenschütze");
                break;
            case 1:
                name="Speerkämpfer";
                break;
            case 2:
                name="Schildknappe";
                break;
            case 3:
                name="Ritter";
                break;
            case 4:
                name="Paladin";
                break;
        }
        return name;
    }
    
    public int leben(int typ) {
        switch (typ) {
            case 0:
                leben=CONFIG.HP0;
                break;
            case 1:
                leben=CONFIG.HP1;
                break;
            case 2:
                leben=CONFIG.HP2;
                break;
            case 3:
                leben=CONFIG.HP3;
                break;
            case 4:
                leben=CONFIG.HP4;
                break;
        }
        return leben;
    }
    
    public int dmg(int typ) {
        switch(typ) {
            case 0:
                dmg=CONFIG.Dmg0;
                break;
            case 1:
                dmg=CONFIG.Dmg1;
                break;
            case 2:
                dmg=CONFIG.Dmg2;
                break;
            case 3:
                dmg=CONFIG.Dmg3;
                break;
            case 4:
                dmg=CONFIG.Dmg4;
                break;
            
        }
        return dmg;
    }
}


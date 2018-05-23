
public class SPIELERINVENTAR
{
    int heiltrankkl=1,heiltrankgr=1;
    int anz0=50,anz1=15,anz2=12,anz3=5,anz4=3;
    int geld=1000;
    public SPIELERINVENTAR()
    {
        geld=geld;
        heiltrankkl=heiltrankkl;
        heiltrankgr=heiltrankgr;
        heiltrankkl=heiltrankkl;
        heiltrankgr=heiltrankgr;
        anz0=anz0;
        anz1=anz1;
        anz2=anz2;
        anz3=anz3;
        anz4=anz4;
    }
    
    public void kaufetruppe (int typ) {
        switch (typ) {
            case 0:
                if(geld>=500) {
                    System.out.println("10 Bogenschützen gekauft");
                    anz0=anz0+10;
                    geld=geld-500;
                }
                else {
                    System.out.println("Nicht genug Geld");
                }
                break;     
            case 1:
                if(geld>=300) {
                    System.out.println("5 Speerkämpfer gekauft");
                    anz1=anz1+5;
                    geld=geld-300;
                }
                else {
                    System.out.println("Nicht genug Geld");
                }
                break; 
            case 2:
                if(geld>=600) {
                    System.out.println("3 Schildknappen gekauft");
                    anz2=anz2+3;
                    geld=geld-600;
                }
                else {
                    System.out.println("Nicht genug Geld");
                }
                break; 
            case 3:
                if(geld>=800) {
                    System.out.println("2 Ritter gekauft");
                    anz3=anz3+2;
                    geld=geld-800;
                }
                else {
                    System.out.println("Nicht genug Geld");
                }
                break; 
            case 4:
                if(geld>=1000) {
                    System.out.println("1 Paladin gekauft");
                    anz4=anz4+1;
                    geld=geld-1000;
                }
                else {
                    System.out.println("Nicht genug Geld");
                }
                break; 
            default: 
                System.out.println("ungültiger kaempfertyp");
                break;
        }
    }
    
    public void zeigeArmee() {
        System.out.println(anz0+" Bogenschützen");
        System.out.println(anz1+" Speerkämpfer");
        System.out.println(anz2+" Schildknappen");
        System.out.println(anz3+" Ritter");
        System.out.println(anz4+" Paladine");
    }
    
    public void plusheiltrank(int gr ,int anz) {
        switch (gr) {
            case 0:
                heiltrankkl=heiltrankkl+anz;
                break;
            case 1:
                heiltrankgr=heiltrankgr+anz;
                break;
            default :
                System.out.println("Ungültige Nummer");
                break;
        }
    }
    
    public void benutzeheiltrank(int gr) {
        switch (gr) {
            case 0:
                heiltrankkl--;
                break;
            case 1:
                heiltrankgr--;
                break;
            default :
                System.out.println("Ungültige Nummer");
                break;
        }
    }
    
    
}

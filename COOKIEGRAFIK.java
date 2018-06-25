public class COOKIEGRAFIK
{
    public COOKIEGRAFIK() {
        
    }

    public void kasten(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,40,40,11);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+40,40,40,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,40,40);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y+40,40,40);
    }

    public void upgrade(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x+12,y,6,30,36);
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y+12,30,6,36);
    }

    public void upgradekasten(int x,int y) {
        kasten(x,y);
        upgrade(x+5,y+45);
        typ(x+5,y+5);
    }

    public void typ(int x,int y) {
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+15,y+15,15,36);
        ZEICHENFENSTER.gibFenster().fuelleKreis(x+15,y+15,12,11);
    }

    public void text(int x,int y,String text) {
        ZEICHENFENSTER.gibFenster().zeichneText(text,x,y);
    }

    public void leben(double leben, int x,int y) {
        String text = "Leben:     " + leben;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

    public void schaden(int attack, int x,int y) {
        String text = "Schaden: " + attack;
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

    public void coins(int coins, int x,int y) {
        String text = "Coins:      " + coins + "/100";
        ZEICHENFENSTER.gibFenster().fuelleRechteck(x,y,110,20,11);
        ZEICHENFENSTER.gibFenster().zeichneRechteck(x,y,110,20);
        text(x+3,y+15,text);
    }

}
public class ALGORITHM
{
    int[] welt;
    int pos;
    int range[];
    int path[];
    int[] enemiePos;
    int[] enemieDmg;
    int[] enemieHP;
    int[] enemieStr;
    int[] anz;
    int Str;
    GRAFIKELEMENTE graphic;
    public ALGORITHM(int pos, int[] welt, int[] anz)
    {
        this.welt = welt;
        this.pos =pos;
        range = new int[25];
        path = new int[25];
        enemiePos = new int[25];
        enemieHP = new int[25];
        enemieDmg = new int[25];
        enemieStr = new int[25];
        this.anz = anz;
        graphic =new GRAFIKELEMENTE();
    }

    public int getType() {
        return welt[pos];
    }

    private void setRange() {
        if(getType()==0) { //muss am ende in 5 geändert werden, da Gegner Team
            for(int i=0;i<25;i++) {
                range[i] = 1;
            }
            if(pos-6>=0 && difLineCheck(pos,-6)) {
                range[pos-6] = 0;
            }
            if(pos-5>=0 && difLineCheck(pos,-5)) {
                range[pos-5] = 0;
            }
            if(pos-4>=0 && difLineCheck(pos,-4)) {
                range[pos-4] = 0;
            }
            if(pos-1>=0 && sameLineCheck(pos,-1)) {
                range[pos-1] = 0;
            }
            if(pos+1<25 && sameLineCheck(pos,+1)) {
                range[pos+1] = 0;
            }
            if(pos+4<25 && difLineCheck(pos,+4)) {
                range[pos+4] = 0;
            }
            if(pos+5<25 && difLineCheck(pos,+5)) {
                range[pos+5] = 0;
            }
            if(pos+6<25 && difLineCheck(pos,+6)) {
                range[pos+6] = 0;
            }
            range[pos] = 0;
        } else {
            for(int i=0;i<25;i++) {
                range[i] = 0;
            }
            if(pos-5>=0 && difLineCheck(pos,-5)) {
                range[pos-5] = 1;
            }
            if(pos-1>=0 && sameLineCheck(pos,-1)) {
                range[pos-1] = 1;
            }
            if(pos+1<25 && sameLineCheck(pos,+1)) {
                range[pos+1] = 1;
            }
            if(pos+5<25 && difLineCheck(pos,+5)) {
                range[pos+5] = 1;
            }
        }
    }  

    public int[] getRange() {
        setRange();
        return range;
    }

    private void setPath() {
        for(int i=0;i<25;i++) {
            path[i] = 0;
        }
        if(pos-5>=0 && difLineCheck(pos,-5) && welt[pos-5] == 10) {
            path[pos-5] = 1;
        }
        if(pos-1>=0 && sameLineCheck(pos,-1) && welt[pos-1] == 10) {
            path[pos-1] = 1;
        }
        if(pos+1<25 && sameLineCheck(pos,+1) && welt[pos+1] == 10) {
            path[pos+1] = 1;
        }
        if(pos+5<25 && difLineCheck(pos,+5) && welt[pos+5] == 10) {
            path[pos+5] = 1;
        }
        path[pos] = 0;
    }

    public int[] getPath() {
        setPath();
        return path;
    }

    private int checkLine(int pos) {
        int line = 0;
        if(pos >= 0 && pos < 5) {
            line = 0;
        }
        else if(pos >= 5 && pos < 10) {
            line = 1;
        }
        else if(pos >= 10 && pos < 15) {
            line = 2;
        }
        else if(pos >= 15 && pos < 20) {
            line = 3;
        }
        else if(pos >= 20 && pos < 25) {
            line = 4;
        }
        return line;
    }

    public boolean difLineCheck(int pos, int dif) {
        boolean check=false;
        int difLine = 0;
        if(checkLine(pos)!=checkLine(pos+dif)) {
            check = true;
        }
        if(check) {
            if(pos<pos+dif) {
                if(checkLine(pos)==checkLine(pos+dif)-1) {
                    check = true;
                } else {
                    check = false;
                }
            }
            if(pos>pos+dif) {
                if(checkLine(pos)==checkLine(pos+dif)+1) {
                    check = true;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    public boolean sameLineCheck(int pos, int dif) {
        boolean check=false;
        if(checkLine(pos)==checkLine(pos+dif)) {
            check = true;
        }
        if(check) {
            if(pos<pos+dif) {
                if(checkLine(pos)==checkLine(pos+dif)) {
                    check = true;
                } else {
                    check = false;
                }
            }
            if(pos>pos+dif) {
                if(checkLine(pos)==checkLine(pos+dif)) {
                    check = true;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    public int[] checkEnemie() {
        setRange();
        int count = 0;
        for(int i=0;i<25;i++) {
            enemiePos[i] = 0;
        }
        for(int i=0;i<25;i++) {
            if(range[i]==1) {
                if(welt[i]>=5 && welt[i] < 10) {
                    count ++;  
                    enemiePos[i] = 1;
                }
            }
        }       
        return enemiePos;
    }

    public void setPriority() {
        checkEnemie();
        for(int i=0;i<25;i++) {
            if(enemiePos[i]==1) {
                int eID = welt[i];
                switch (eID) {
                    case 0:
                    enemieHP[i]=40;
                    enemieDmg[i]=55;
                    enemieStr[i]= enemieHP[i]*anz[i];
                    break;
                    case 1:
                    enemieHP[i]=60;
                    enemieDmg[i]=40;
                    enemieStr[i]= enemieHP[i]*anz[i];
                    break;
                    case 2:
                    enemieHP[i]=75;
                    enemieDmg[i]=20;
                    enemieStr[i]= enemieHP[i]*anz[i];
                    break;
                    case 3:
                    enemieHP[i]=60;
                    enemieDmg[i]=30;
                    enemieStr[i]= enemieHP[i]*anz[i];
                    break;
                    case 4:
                    enemieHP[i]=100;
                    enemieDmg[i]=35;
                    enemieStr[i]= enemieHP[i]*anz[i];
                    break;
                }
            }
        }
    }
    
    public void setStrength() {
        int ID = welt[pos];
        switch (ID) {
                    case 0:
                    Str = 55 * anz[pos];
                    break;
                    case 1:
                    Str = 40 * anz[pos];
                    break;
                    case 2:
                    Str = 20 * anz[pos];
                    break;
                    case 3:
                    Str = 30 * anz[pos];
                    break;
                    case 4:
                    Str = 35 * anz[pos];
                    break;
                }
    }
}
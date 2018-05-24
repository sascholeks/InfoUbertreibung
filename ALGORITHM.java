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
    int[] StrCom;
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
        StrCom = new int[25];
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
        for(int i=0;i<25;i++) {
            enemiePos[i] = 0;
        }
        for(int i=0;i<25;i++) {
            if(range[i]==1) {
                if(welt[i]>=5 && welt[i] < 10) {    //muss am Ende in (welt[i] >=0 && welt[i]<10) abgeändert werden, da anderes Team
                    enemiePos[i] = 1;
                }
            }
        }       
        return enemiePos;
    }

    public int[] getEnemieStr() {
        for(int i=0;i<25;i++) {
            if(checkEnemie()[i]==1) {
                int eID = welt[i];
                if(eID>=5 && eID < 10) {
                    eID = eID - 5;
                }

                switch (eID) {
                    case 0:
                    enemieHP[i]=CONFIG.HP0;
                    enemieDmg[i]=CONFIG.Dmg0;
                    enemieStr[i]= enemieHP[i]*anz[welt[i]];
                    break;
                    case 1:
                    enemieHP[i]=CONFIG.HP1;
                    enemieDmg[i]=CONFIG.Dmg1;
                    enemieStr[i]= enemieHP[i]*anz[welt[i]];
                    break;
                    case 2:
                    enemieHP[i]=CONFIG.HP2;
                    enemieDmg[i]=CONFIG.Dmg2;
                    enemieStr[i]= enemieHP[i]*anz[welt[i]];
                    break;
                    case 3:
                    enemieHP[i]=CONFIG.HP3;
                    enemieDmg[i]=CONFIG.Dmg3;
                    enemieStr[i]= enemieHP[i]*anz[welt[i]];
                    break;
                    case 4:
                    enemieHP[i]=CONFIG.HP4;
                    enemieDmg[i]=CONFIG.Dmg4;
                    enemieStr[i]= enemieHP[i]*anz[welt[i]];
                    break;
                    default: 
                    enemieStr[i] = 0;
                }
            }
            else {
                enemieStr[i] = 0;
            }
        }
        return enemieStr;
    }

    public int getStrength() {
        int ID = welt[pos];
        switch (ID) {
            case 0:
            Str = CONFIG.Dmg0 * anz[welt[pos]];
            break;
            case 1:
            Str = CONFIG.Dmg1 * anz[welt[pos]];
            break;
            case 2:
            Str = CONFIG.Dmg2 * anz[welt[pos]];
            break;
            case 3:
            Str = CONFIG.Dmg3 * anz[welt[pos]];
            break;
            case 4:
            Str = CONFIG.Dmg4 * anz[welt[pos]];
            break;
        }
        return Str;
    }

    public int[] getStrengthCom() {
        for(int i=0;i<25;i++) {
            if(getEnemieStr()[i]>=getStrength() && getEnemieStr()[i] != 0) {
                StrCom[i]=0;
            } else if(getEnemieStr()[i]==0) {
                StrCom[i]=0;
            } else {
                StrCom[i]=1;
            }
        }
        return StrCom;
    }

    public void decide() {
        int cE=0;
        int cP=0;
        int cSC=0;
        for(int i=0;i<25;i++) {
            if(checkEnemie()[i]==1) {
                cE++;
            }
        }
        if(cE==0) {
            for(int i=0;i<25;i++) {
                if(getPath()[i]==1) {
                    cP++;
                }
            }
            if(cP!=0) {
                move();
            } else {
                stop();
            }
        } else {
            for(int i=0;i<25;i++) {
                if(getStrengthCom()[i]==1) {
                    cSC++;
                }
            } 
            if(cSC==0) {
                cP = 0;
                for(int i=0;i<25;i++) {
                    if(getPath()[i]==1) {
                        cP++;
                    }
                }
                if(cP!=0) {
                    move();
                } else {
                    stop();
                }
            } else {
                attack();
            }
        }
    }

    private void move() {
        graphic.kons("move()");
    }

    private void stop() {
        graphic.kons("stop()");
    }
    
    private void attack() {
        graphic.kons("attack()");
    }

}

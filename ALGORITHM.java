import java.util.Random;

public class ALGORITHM
{
    int[] welt;
    int pos;
    int[] range;
    int[] path;
    int[] enemyPos;
    int[] enemyDmg;
    int[] enemyHP;
    int[] enemyStr;
    int[] anz;
    int[] StrCom;
    int[] attackPos;
    int Str;
    int[] order;
    Random r;
    int[] ExtendedAttack;

    int action = -1;
    int actionPos = -1;

    //GRAFIKELEMENTE graphic;
    public ALGORITHM(int[] welt, int[] anz, int[] order)
    {
        this.welt = welt;
        this.order = order;
        this.anz = anz;
        this.pos = getOrderPos();
        range = new int[25];
        path = new int[25];
        enemyPos = new int[25];
        enemyHP = new int[25];
        enemyDmg = new int[25];
        enemyStr = new int[25];
        StrCom = new int[25];
        attackPos = new int[25];
        //graphic =new GRAFIKELEMENTE();
        r = new Random();
    }

    public void updateOrder(int[] order) {
        this.order = order;
    }

    public int getOrderPos() {
        int pos=-1;
        for(int i=0;i<25;i++) {
            if(order[0]==welt[i]) {
                this.pos = i;
                pos = i;
            }
        }
        if(pos==-1) {
            // graphic.kons("AI Position Getter Error!");
        }
        return pos;  
    }

    public int getType() {
        return welt[pos];
    }

    private int[] getRange(int pos) {
        if(getType()==5) { //muss am ende in 5 geändert werden, da Gegner Team
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

    public int[] checkEnemy() {
        for(int i=0;i<25;i++) {
            enemyPos[i] = 0;
        }
        for(int i=0;i<25;i++) {
            if(getRange(pos)[i]==1) {
                if(welt[i]>=0 && welt[i] < 5) {    //muss am Ende in (welt[i] >=0 && welt[i]<10) abgeändert werden, da anderes Team
                    enemyPos[i] = 1;
                }
            }
        }       
        return enemyPos;
    }

    public int[] getAllEnemies() {
        int[] aEnemies = new int[25];
        for(int i=0;i<25;i++) {
            if(welt[i]>= 0 && welt[i] <5) {
                aEnemies[i] = 1;
            } else {
                aEnemies[i] = 0;
            }
        }
        return aEnemies;
    }

    public int[] getenemyStr() {
        for(int i=0;i<25;i++) {
            if(checkEnemy()[i]==1) {
                int eID = welt[i];

                switch (eID) {
                    case 0:
                    enemyHP[i]=CONFIG.HP0;
                    enemyDmg[i]=CONFIG.Dmg0;
                    enemyStr[i]= enemyHP[i]*anz[welt[i]];
                    break;
                    case 1:
                    enemyHP[i]=CONFIG.HP1;
                    enemyDmg[i]=CONFIG.Dmg1;
                    enemyStr[i]= enemyHP[i]*anz[welt[i]];
                    break;
                    case 2:
                    enemyHP[i]=CONFIG.HP2;
                    enemyDmg[i]=CONFIG.Dmg2;
                    enemyStr[i]= enemyHP[i]*anz[welt[i]];
                    break;
                    case 3:
                    enemyHP[i]=CONFIG.HP3;
                    enemyDmg[i]=CONFIG.Dmg3;
                    enemyStr[i]= enemyHP[i]*anz[welt[i]];
                    break;
                    case 4:
                    enemyHP[i]=CONFIG.HP4;
                    enemyDmg[i]=CONFIG.Dmg4;
                    enemyStr[i]= enemyHP[i]*anz[welt[i]];
                    break;
                    default: 
                    enemyStr[i] = 0;
                }
            }
            else {
                enemyStr[i] = 0;
            }
        }
        return enemyStr;
    }

    public int getStrength(int pos) {
        int ID = welt[pos];
        if(ID>=0 && ID < 5) {
            ID = ID-5;
        }

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
            if(getenemyStr()[i]>=getStrength(pos) && getenemyStr()[i] != 0) {
                StrCom[i]=0;
            } else if(getenemyStr()[i]==0) {
                StrCom[i]=0;
            } else {
                StrCom[i]=1;
            }
        }
        return StrCom;
    }

    public int[] getAttackPos(int pos) {
        for(int i=0;i<25;i++) {
            attackPos[i]=0;
        }
        if(pos-5>=0 && difLineCheck(pos,-5) && welt[pos-5] < 5 && welt[pos-5] >= 0) { //muss am Ende  (welt[pos-5] < 5  && welt[pos-5] >= 0) heißen
            attackPos[pos-5] = 1;
        }
        if(pos-1>=0 && sameLineCheck(pos,-1) && welt[pos-1] < 5 && welt[pos-1] >=0) {
            attackPos[pos-1] = 1;
        }
        if(pos+1<25 && sameLineCheck(pos,+1) && welt[pos+1] < 5 && welt[pos+1] >= 0) {
            attackPos[pos+1] = 1;
        }
        if(pos+5<25 && difLineCheck(pos,+5) && welt[pos+5] < 5 && welt[pos+5] >= 0) {
            attackPos[pos+5] = 1;
        }
        return attackPos;
    }

    public int getAttackCount(int pos) {
        int AttackCount = 0;
        for(int i=0;i<25;i++) {
            if(getAttackPos(pos)[i]==1) {
                AttackCount++;
            }
        }
        return AttackCount;
    }

    public int getSaveDeath(int pos) {
        int saveDeathCount=0;
        for(int i=0;i<25;i++) {
            if(getenemyStr()[i]>getStrength(pos) && welt[i] !=0) { //muss zu 0 geändert werden
                if(getRange(pos)[i]==1) {
                    saveDeathCount++; 
                }
            }
        }
        return saveDeathCount;
    }

    public void decide() {
        this.pos = getOrderPos();
        int cE=0;
        int cP=0;
        int cSC=0;
        int EnemyStrCom = 0;
        int EnemyPos = 0;
        if(anz[pos]==0) {
            setActionType(2);
            setActionPos(pos);
        } else 
        {
            if(getType()>=10) {
                // graphic.kons("Error: Please select an Entity!");
            } else if(getType()==5) { //muss zu 5 geändert werden
                boolean moveback = false;
                for(int i=0;i<25;i++) {
                    if(getAttackPos(pos)[i]==1 && welt[i] != 0) { //5 muss zu 0 geändert werden
                        moveback = true;
                    }
                }
                if(moveback) {
                    moveaway();
                } else {
                    for(int i=0;i<25;i++) {
                        if(getenemyStr()[i]>EnemyStrCom) {
                            EnemyStrCom = getenemyStr()[i];
                            EnemyPos = i;
                        }
                    }
                    attackpos(EnemyPos);
                }
            } else {
                for(int i=0;i<25;i++) {
                    if(checkEnemy()[i]==1) {
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
                        movenormal();
                    } else {
                        stop(); //attack strongest
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
                            boolean check = false;
                            int attackposition = 0;
                            for(int i=0;i<25;i++) {
                                if(getRange(pos)[i]==1 && welt[i] == 0) { //muss zu 0 geändert werden
                                    if(getSaveDeath(pos)==0) {
                                        check = true;
                                        attackposition = i;
                                    }
                                }
                            }
                            if(check) {
                                attackpos(attackposition);
                            } else {
                                moveaway();
                            }
                        } else {
                            stop(); //heilen überprüfen
                        }
                    } else {
                        int EnPos = 0;
                        int EnStr = 0;
                        for(int i=0;i<25;i++) {
                            if(checkEnemy()[i]==1 && getStrength(i) >= EnStr) {
                                EnPos = i;
                            }
                        }
                        attackpos(EnPos);
                    }
                }
            }
        }
    }

    public void stop() { //heal überprüfen
        // graphic.kons("stop()");
        setActionType(2);
    }

    public void attack() {
        // graphic.kons("attack()");
        setActionType(0);
        setActionPos(pos);
    }

    public void attackpos(int pos) {
        // graphic.kons("attack(" + pos + ")");  
        setActionType(0);
        setActionPos(pos);
    }

    public boolean checkArrayOrder(int pos) {
        boolean ArrayOrder=false;
        if(pos>=0 && pos<25) {
            ArrayOrder = true;
        }
        return ArrayOrder;
    }

    public boolean DifArrayCreator(int pos,int dif) {
        boolean check=false;
        if(checkArrayOrder(pos+dif) && difLineCheck(pos,dif)) {
            check=true;   
        }
        return check;
    }

    public boolean SameArrayCreator(int pos,int dif) {
        boolean check=false;
        if(checkArrayOrder(pos+dif) && sameLineCheck(pos,dif)) {
            check=true;   
        }
        return check;
    }

    public void moveaway() {
        boolean up=false,down=false,left=false,right=false;
        int acl = 0; 
        int acr = 0;
        int acu = 0;
        int acd = 0; 
        int sac = 0;
        int tc = 0;

        int EnPos = -1;
        int EnStr = 0;
        for(int i=0;i<25;i++) {
            if(checkEnemy()[i]==1 && getStrength(i) >= EnStr) {
                EnPos = i;
            }
        }
        if(EnPos!=-1) {
            attackpos(EnPos);
        } else {
            if(pos-1 >= 0 && getPath()[pos-1] == 1) {
                left = true;
                acl = getSaveDeath(pos-1);
                tc++;
            }
            if(pos+1 < 25 && getPath()[pos+1] == 1) {
                right = true;
                acr = getSaveDeath(pos+1);
                tc++;
            }
            if(pos+5 < 25 && getPath()[pos+5] == 1) {
                down = true;
                acd = getSaveDeath(pos+5);
                tc++;
            }
            if(pos-5 >= 0 && getPath()[pos-5] == 1) {
                up = true;
                acu = getSaveDeath(pos-5);
                tc++;
            }
            if(acl>getSaveDeath(pos)) {
                left = false;
            }
            if(acr>getSaveDeath(pos)) {
                right = false;
            }
            if(acu>getSaveDeath(pos)) {
                up = false;
            }
            if(acd>getSaveDeath(pos)) {
                down = false;
            }
            if(tc==0) {
                stop();
            } else {
                if(left) {
                    // graphic.kons("moveleft()");
                    setActionType(1);
                    setActionPos(pos-1);
                } else if(up || down) {
                    if(checkLine(pos) < 2 && up) { 
                        // graphic.kons("moveup()");
                        setActionType(1);
                        setActionPos(pos-5);
                    } else if(checkLine(pos) > 2 && down) { 
                        // graphic.kons("movedown()");
                        setActionType(1);
                        setActionPos(pos+5);
                    } else {
                        if(r.nextInt(2)==0) {
                            if(up) {
                                // graphic.kons("moveup()");
                                setActionType(1);
                                setActionPos(pos-5);
                            } else {
                                stop();
                            }
                        } else {
                            if(down) {
                                // graphic.kons("movedown()");
                                setActionType(1);
                                setActionPos(pos+5);
                            } else {
                                stop();
                            }
                        }
                    }
                } else if(right) {
                    // graphic.kons("moveright()");
                    setActionType(1);
                    setActionPos(pos+1);
                } else {
                    stop();
                }
            }
        }
    }

    public void movenormal() { //Abstand zu Gegnern halten + StrengthComparision + SaveDeath
        boolean up=false,down=false,left=false,right=false;
        int EnPos = -1;
        int EnStr = 0;
        for(int i=0;i<25;i++) {
            if(checkEnemy()[i]==1 && getStrength(i) >= EnStr) {
                EnPos = i;
            }
        }
        if(EnPos!=-1) {
            attackpos(EnPos);
        } else {
            if(pos-1 >= 0 && getPath()[pos-1] == 1) {
                if(pos-2 >= 0 && getAllEnemies()[pos-2] == 0) {
                    left = true;
                } else if(pos-2 >=0 && getSaveDeath(pos-2)==0) {
                    left = true;
                }
            }
            if(pos+1 < 25 && getPath()[pos+1] == 1) {
                if(pos+2 <25 && getAllEnemies()[pos+2] == 0) {
                    right = true;
                } else if(pos+2 < 25 && getSaveDeath(pos+2)==0) {
                    right = true;
                }
            }
            if(pos+5 < 25 && getPath()[pos+5] == 1) {
                if(pos+10 < 25 && getAllEnemies()[pos+10] == 0) {
                    down = true;
                } else if(pos+10 < 25 && getSaveDeath(pos+10)==0) {
                    down = true;
                }
            }
            if(pos-5 >= 0 && getPath()[pos-5] == 1) {
                if(pos-10 >= 0 && getAllEnemies()[pos-10] == 0) {
                    up = true;
                } else if(pos-10 >= 0 && getSaveDeath(pos-10)==0) {
                    up = true;
                }
            }
            if(left) {
                // graphic.kons("moveleft()");
                setActionType(1);
                setActionPos(pos-1);
            } else if(up || down) {
                if(checkLine(pos) < 2 && up) { 
                    // graphic.kons("moveup()");
                    setActionType(1);
                    setActionPos(pos-5);
                } else if(checkLine(pos) > 2 && down) { 
                    // graphic.kons("movedown()");
                    setActionType(1);
                    setActionPos(pos+5);
                } else {
                    if(r.nextInt(2)==0) {
                        if(up) {
                            // graphic.kons("moveup()");
                            setActionType(1);
                            setActionPos(pos-5);
                        } else {
                            stop();
                        }
                    } else {
                        if(down) {
                            // graphic.kons("movedown()");
                            setActionType(1);
                            setActionPos(pos+5);
                        } else {
                            stop();
                        }
                    }
                }
            } else if(right) {
                // graphic.kons("moveright()");
                setActionType(1);
                setActionPos(pos+1);
            } else {
                stop();
            }
        }
    }

    public void setActionType(int action) {
        this.action = action;
    }

    public void setActionPos(int actionPos) {
        this.actionPos = actionPos;
    }

    public int getActionType() {
        return action;
    }

    public int getActionPos() {
        return actionPos;
    }

}

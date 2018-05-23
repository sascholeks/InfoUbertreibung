public class ALGORITHMUS
{
    int[] welt;
    int pos;
    int range[];
    int path[];
    GRAFIKELEMENTE grafik;
    public ALGORITHMUS(int pos, int[] welt)
    {
        this.welt = welt;
        this.pos =pos;
        range = new int[25];
        path = new int[25];
        grafik=new GRAFIKELEMENTE();
    }

    public int getType() {
        return welt[pos];
    }

    public void setRange() {
        if(getType()==0) {
            for(int i=0;i<25;i++) {
                range[i] = 1;
            }
            if(pos-6>=0 && checkLine(pos)!=checkLine(pos-6)) {
                range[pos-6] = 0;
            }
            if(pos-5>=0 && checkLine(pos)!=checkLine(pos-5)) {
                range[pos-5] = 0;
            }
            if(pos-4>=0 && checkLine(pos)!=checkLine(pos-4)) {
                range[pos-4] = 0;
            }
            if(pos-1>=0 && checkLine(pos)==checkLine(pos-1)) {
                range[pos-1] = 0;
            }
            if(pos+1<25 && checkLine(pos)==checkLine(pos+1)) {
                range[pos+1] = 0;
            }
            if(pos+4<25 && checkLine(pos)!=checkLine(pos+4)) {
                range[pos+4] = 0;
            }
            if(pos+5<25 && checkLine(pos)!=checkLine(pos+5)) {
                range[pos+5] = 0;
            }
            if(pos+6<25 && checkLine(pos)!=checkLine(pos+6)) {
                range[pos+6] = 0;
            }
            range[pos] = 0;
        } else {
            for(int i=0;i<25;i++) {
                range[i] = 0;
            }
            if(pos-5>=0 && checkLine(pos)!=checkLine(pos-5)) {
                range[pos-5] = 1;
            }
            if(pos-1>=0 && checkLine(pos)==checkLine(pos-1)) {
                range[pos-1] = 1;
            }
            if(pos+1<25 && checkLine(pos)==checkLine(pos+1)) {
                range[pos+1] = 1;
            }
            if(pos+5<25 && checkLine(pos)!=checkLine(pos+5)) {
                range[pos+5] = 1;
            }
        }
    }  

    public int[] getRange() {
        setRange();
        return range;
    }

    public boolean checkEnemie() {
        setRange();
        boolean check=false;
        for(int i=0;i<25;i++) {
            if(range[i]==1) {
                if(welt[i]>=5 && welt[i] < 10) {
                    grafik.kons("Gegner gefunden! (Pos: " + i + ", ID: " + welt[i] + ")");
                    check = true;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    public void setPath() {
        for(int i=0;i<25;i++) {
            path[i] = 0;
        }
        if(pos-5>=0 && checkLine(pos)!=checkLine(pos-5) && welt[pos-5] == 10) {
            path[pos-5] = 1;
        }
        if(pos-1>=0 && checkLine(pos)==checkLine(pos-1) && welt[pos-1] == 10) {
            path[pos-1] = 1;
        }
        if(pos+1<25 && checkLine(pos)==checkLine(pos+1) && welt[pos+1] == 10) {
            path[pos+1] = 1;
        }
        if(pos+5<25 && checkLine(pos)!=checkLine(pos+5) && welt[pos+5] == 10) {
            path[pos+5] = 1;
        }
        path[pos] = 0;
    }

    public int[] getPath() {
        return path;
    }

    public int checkLine(int pos) {
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
}

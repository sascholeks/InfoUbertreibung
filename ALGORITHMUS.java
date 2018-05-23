public class ALGORITHMUS
{
    int[] welt;
    int pos;
    int range[];
    public ALGORITHMUS(int pos, int[] welt)
    {
        this.welt = welt;
        this.pos =pos;
        range = new int[25];
    }

    public int getType() {
        return welt[pos];
    }

    public void getRange() {
        if(getType()==5) {
            for(int i=0;i<25;i++) {
                range[i]=1;
            }
            range[pos-6] = 0;
            range[pos-5] = 0;
            range[pos-4] = 0;
            range[pos-1] = 0;
            range[pos] = 0;
            range[pos+1] = 0;
            range[pos+4] = 0;
            range[pos+5] = 0;
            range[pos+6] = 0;
        }
    }   

}

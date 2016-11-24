/**
 * Created by Admin on 24.11.2016.
 */
public abstract class Rate {

    private int rate;

    public Rate(int rate) {
        this.rate = rate;
    }

    public int getValueRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

package labs.chrono;

public class Chronometre {

    private static int MAX_HOURS = 100;
    private static int MAX_MINUTES = 60;
    private static int MAX_SECONDS = 60;

    private int h;
    private int m;
    private int s;



    public Chronometre(int h, int m, int s) {
        if(h >= MAX_HOURS || h < 0 || m >= MAX_MINUTES || m < 0 || s >= MAX_SECONDS || s < 0) throw new IllegalArgumentException("OK MEK");

        this.setHour(h);
        this.setMinute(m);
        this.setSecond(s);

    }

    public Chronometre() {
        this(0, 0, 0);
    }

    public int getHour() {
        return this.h;
    }

    public int getMinute() {
        return this.m;
    }
    
    public int getSecond() {
        return this.s;
    }

    private void setToMax() {
            this.h = MAX_HOURS - 1;
            this.m = MAX_MINUTES - 1;
            this.s = MAX_SECONDS - 1;
    }

    private void setHour(int newH) {
        if(newH >= MAX_HOURS - 1) {
            this.setToMax();
        } else if (newH < 0) {
            throw new IllegalArgumentException("E");
        } else {
            this.h = newH;
        }
    }

    private void setMinute(int newM) {
        this.m = newM;
    }

    private void setSecond(int newS) {
        this.s = newS;
    }

    public void addHour(int hour) {
        if(hour < 0) throw new IllegalArgumentException("BZ TA MERE");

        int newH = (this.getHour() + hour);
        this.setHour(newH);
    }

    public void addMinute(int minutes) {
        if(minutes < 0) throw new IllegalArgumentException("BZ TA MERE");

        int hIncr = (this.getMinute() + minutes) / MAX_MINUTES;
        int reste = (this.getMinute() + minutes) % MAX_MINUTES;

        this.setMinute(reste);
        this.addHour(hIncr);
    }

    public void addSecond(int seconds) {
        if(seconds < 0) throw new IllegalArgumentException("BZ TA MERE");

        int mIncr = (this.getSecond() + seconds) / MAX_SECONDS;
        int reste = (this.getSecond() + seconds) % MAX_SECONDS;

        this.setSecond(reste);
        this.addMinute(mIncr);
    }

    public void reset() {
        this.setHour(0);
        this.setMinute(0);
        this.setSecond(0);
    }

    @Override
    /**
     * Format the chronometer into a String
     * @return a formatted String which represent the chronometer.
     */
    public String toString() {
        return String.format("%02d:%02d:%02d", this.h, this.m, this.s);
    }

    public boolean isMax() {
        return (this.getHour() == MAX_HOURS - 1) && (this.getMinute() == MAX_MINUTES - 1) && (this.getSecond() == MAX_SECONDS - 1);
    }

    public int toSeconds() {
        return (this.getHour() * 3600) + (this.getMinute() * 60) + this.getSecond(); 
    }

    public int compare(Chronometre c2) {
        if(c2 == null) return -1;
        if(c2 == this) return 0;


        int s1 = this.toSeconds();
        int s2 = c2.toSeconds();

        if(s1 == s2) return 0;
        return s1 < s2 ? -1 : 1;
    }
    

}

package App;
import java.time.LocalTime;

public class Session {
    // private int attendence;
    private LocalTime start_time;
    private LocalTime end_time;
    private LocalTime period;

    // public int getAttendence() {
    //     return attendence;
    // }
    public Session(LocalTime ti, LocalTime tf, LocalTime p) {
        this.start_time = ti;
        this.end_time = tf;
        this.period = p;
    }
    public LocalTime getStart_time() {
        return start_time;
    }
    public LocalTime getEnd_time() {
        return end_time;
    }
    public LocalTime getPeriod() {
        return period;
    }
    // public static void main(String[] args) {
    //     LocalTime ti = LocalTime.now();
    //     ti.wait(1000);
    //     LocalTime tf = LocalTime.now();
    //     LocalTime p = tf - ti;

    //     // Session s = new Session(ti, tf, p);
    //     System.out.println(p);
    // }
    
}

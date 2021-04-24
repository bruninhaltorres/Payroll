package src;

public class TimeCard {
    private int in;
    private int out;
    private int hoursWorked = out - in;
    private String date;

    public TimeCard(int in, int out, String date) {
        this.in = in;
        this.out = out;
        this.setDate(date);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

}

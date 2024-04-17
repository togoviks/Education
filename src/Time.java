public class Time {
    private final int hours;
    private final int minutes;

    public Time(int hours, int minutes) {
        if (hours > 23 || minutes > 59) {
            throw new IllegalArgumentException("Wrong time format");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isLater(Time time) {
        return toMinutes() > time.toMinutes();
    }

    public Time timeDifference(Time time) {
        int timeDiff = Math.abs(toMinutes() - time.toMinutes());
        return new Time(timeDiff / 60, timeDiff % 60);
    }

    public void printTime() {
        System.out.printf("%02d:%02d", hours, minutes);
    }

    private int toMinutes() {
        return hours * 60 + minutes;
    }
}

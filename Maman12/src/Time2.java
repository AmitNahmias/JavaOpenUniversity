/**
 * The program creates time object in 24 hours format.
 * The user can create time instance and change the time by change hours/minutes, add number of minutes to the time,
 * compare between two time instances and find the difference between two times.
 *
 * @author Amit Nahmias
 * @version 23.3.2022
 */

public class Time2 {
    final int DEFAULT_VALUE = 0;
    final int MAX_HOUR = 23;
    final int MAX_MINUTE = 59;
    final int MINUTES_IN_HOUR = 60;
    final int HOURS_IN_DAY = 24;
    final int MAX_SINGLE_DIGIT = 9;
    final String ZERO_AS_STRING = "0";

    private int _minFromMid;

    /**
     * Creates a new time object
     *
     * @param h the hour in the time
     * @param m the minutes in the time
     */
    public Time2(int h, int m) {
        int hour = (h <= MAX_HOUR && h >= DEFAULT_VALUE) ? h : DEFAULT_VALUE;
        int minute = (m <= MAX_MINUTE && m >= DEFAULT_VALUE) ? m : DEFAULT_VALUE;
        _minFromMid = hour * MINUTES_IN_HOUR + minute;
    }

    /**
     * Copy Constructor
     *
     * @param other time object to copy
     */
    public Time2(Time2 other) {
        int hour = other.getHour();
        int minute = other.getMinute();
        _minFromMid = hour * MINUTES_IN_HOUR + minute;
    }

    /**
     * Gets hour
     */
    public int getHour() {
        return _minFromMid / MINUTES_IN_HOUR;
    }

    /**
     * Gets minutes
     */
    public int getMinute() {
        return _minFromMid % MINUTES_IN_HOUR;
    }

    /**
     * Set hour, check if the hour value is valid
     *
     * @param num hour to set
     */
    public void setHour(int num) {
        if (num <= MAX_HOUR && num >= DEFAULT_VALUE) {
            _minFromMid = _minFromMid - (this.getHour() * MINUTES_IN_HOUR) + num * MINUTES_IN_HOUR;
        }
    }

    /**
     * Set minutes, check if minutes value is valid
     *
     * @param num minutes to set
     */
    public void setMinute(int num) {
        if (num <= MAX_MINUTE && num >= DEFAULT_VALUE) {
            _minFromMid = _minFromMid - this.getMinute() + num;
        }
    }

    /**
     * @return String that represents time in the following format: hours:minutes (22:50)
     */
    public String toString() {
        String hours = String.valueOf(this.getHour()), minutes = String.valueOf(this.getMinute());
        if (this.getHour() <= MAX_SINGLE_DIGIT)
            hours = ZERO_AS_STRING + hours;
        if (this.getMinute() <= MAX_SINGLE_DIGIT)
            minutes = ZERO_AS_STRING + minutes;
        return hours + ":" + minutes;
    }

    /**
     * @return how many minutes has passed from midnight
     */
    public int minFromMidnight() {
        return _minFromMid;
    }

    /**
     * Check if two time instances are equals by there values
     *
     * @param other another time instance
     * @return True if they are equal, otherwise false
     */
    public boolean equals(Time2 other) {
        return (other.minFromMidnight() == _minFromMid);
    }

    /**
     * Check if current time is before other time
     *
     * @param other another time instance
     * @return True if he is before, otherwise false
     */
    public boolean before(Time2 other) {
        return _minFromMid < other.minFromMidnight();
    }

    /**
     * Check if current time is after other time
     *
     * @param other another time instance
     * @return True if he is after, otherwise false
     */
    public boolean after(Time2 other) {
        return other.before(this);
    }

    /**
     * Calculate the difference in minutes between two time instances
     *
     * @param other another time instance
     * @return The difference in minutes
     */
    public int difference(Time2 other) {
        return _minFromMid - other.minFromMidnight();
    }

    /**
     * Change time by minutes parameter
     *
     * @param num minutes to change
     * @return new time instance after the change
     */
    public Time2 addMinutes(int num) {
        int newTime = _minFromMid + num;
        int hours, minutes;
        if (newTime > DEFAULT_VALUE) {
            hours = (newTime / MINUTES_IN_HOUR) % HOURS_IN_DAY;
            minutes = newTime % MINUTES_IN_HOUR;
        } else {
            hours = MAX_HOUR + (newTime / MINUTES_IN_HOUR) % HOURS_IN_DAY;
            minutes = MINUTES_IN_HOUR + newTime % MINUTES_IN_HOUR;
        }
        return new Time2(hours, minutes);
    }
}



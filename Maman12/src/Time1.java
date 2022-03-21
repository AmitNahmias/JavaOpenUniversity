/**
 * The program creates time object in 24 hours format.
 * The user can create time instance and change the time by change hours/minutes, add number of minutes to the time,
 * compare between two time instances and find the difference between two times.
 *
 * @author Amit Nahmias
 * @version 22.3.2022
 */

public class Time1 {
    final int DEFAULT_VALUE = 0;
    final int MAX_HOUR = 23;
    final int MAX_MINUTE = 59;
    final int MINUTES_IN_HOUR = 60;
    final int HOURS_IN_DAY = 24;
    final int MAX_SINGLE_DIGIT = 9;
    final String ZERO_AS_STRING = "0";

    private int _hour; // represents hours
    private int _minute; // represents minutes

    /**
     * Creates a new time object
     *
     * @param h the hour in the time
     * @param m the minutes in the time
     */
    public Time1(int h, int m) {
        _hour = (h <= MAX_HOUR && h >= DEFAULT_VALUE) ? h : DEFAULT_VALUE;
        _minute = (m <= MAX_MINUTE && m >= DEFAULT_VALUE) ? m : DEFAULT_VALUE;
    }

    /**
     * Copy Constructor
     *
     * @param other time object to copy
     */
    public Time1(Time1 other) {
        _hour = other._hour;
        _minute = other._minute;
    }

    /**
     * Gets hour
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Gets minutes
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Set hour, check if the hour value is valid
     *
     * @param num hour to set
     */
    public void setHour(int num) {
        _hour = (num <= MAX_HOUR && num >= DEFAULT_VALUE) ? num : _hour;
    }

    /**
     * Set minutes, check if minutes value is valid
     *
     * @param num minutes to set
     */
    public void setMinute(int num) {
        _minute = (num <= MAX_MINUTE && num >= DEFAULT_VALUE) ? num : _minute;
    }

    /**
     * @return String that represents time in the following format: hours:minutes (22:50)
     */
    public String toString() {
        String hours = String.valueOf(_hour), minutes = String.valueOf(_minute);
        if (_hour <= MAX_SINGLE_DIGIT)
            hours = ZERO_AS_STRING + hours;
        if (_minute <= MAX_SINGLE_DIGIT)
            minutes = ZERO_AS_STRING + minutes;
        return hours + ":" + minutes;
    }

    /**
     * @return how many minutes has passed from midnight
     */
    public int minFromMidnight() {
        return _hour * MINUTES_IN_HOUR + _minute;
    }

    /**
     * Check if two time instances are equals by there values
     * @param other another time instance
     * @return True if they are equal, otherwise false
     */
    public boolean equals(Time1 other) {
        return (other.getHour() == _hour && _minute == other.getMinute());
    }

    /**
     * Check if current time is before other time
     * @param other another time instance
     * @return True if he is before, otherwise false
     */
    public boolean before(Time1 other) {
        if (_hour < other.getHour()) return true;
        else return _minute < other.getMinute();
    }
    /**
     * Check if current time is after other time
     * @param other another time instance
     * @return True if he is after, otherwise false
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * Calculate the difference in minutes between two time instances
     * @param other another time instance
     * @return The difference in minutes
     */
    public int difference(Time1 other) {
        return ((_hour - other.getHour()) * MINUTES_IN_HOUR) + (_minute - other.getMinute());
    }

    /**
     * Change time by minutes parameter
     * @param num minutes to change
     * @return new time instance after the change
     */
    public Time1 addMinutes(int num) {
        int timeInMinutes = this.minFromMidnight() + num;
        int hours, minutes;
        if (timeInMinutes > DEFAULT_VALUE) {
            hours = (timeInMinutes / MINUTES_IN_HOUR) % HOURS_IN_DAY;
            minutes = timeInMinutes % MINUTES_IN_HOUR;
        } else {
            hours = MAX_HOUR + (timeInMinutes / MINUTES_IN_HOUR) % HOURS_IN_DAY;
            minutes = MINUTES_IN_HOUR + timeInMinutes % MINUTES_IN_HOUR;
        }
        return new Time1(hours, minutes);
    }
}


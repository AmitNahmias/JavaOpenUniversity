/**
 * Represents time - hours:minutes. Values cannot be negative.
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

    private int _hour;
    private int _minute;

    /**
     * Constructs a Time1 object. Construct a new time instance with the specified hour and minute. hour should be between 0-23, otherwise it should be set to 0. minute should be between 0-59, otherwise it should be set to 0.
     *
     * @param h the hour of the time.
     * @param m the minute of the time.
     */
    public Time1(int h, int m) {
        _hour = (h <= MAX_HOUR && h >= DEFAULT_VALUE) ? h : DEFAULT_VALUE;
        _minute = (m <= MAX_MINUTE && m >= DEFAULT_VALUE) ? m : DEFAULT_VALUE;
    }

    /**
     * Copy constructor for Time1. Construct a time with the same instance variables as another time.
     *
     * @param other The time object from which to construct the new time.
     */
    public Time1(Time1 other) {
        _hour = other._hour;
        _minute = other._minute;
    }

    /**
     * Returns the hour of the time.
     *
     * @return The hour of the time.
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Returns the minute of the time.
     *
     * @return The minute of the time.
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
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
     *
     * @param num The new minute.
     */
    public void setMinute(int num) {
        _minute = (num <= MAX_MINUTE && num >= DEFAULT_VALUE) ? num : _minute;
    }

    /**
     * Return a string representation of this time (hh:mm).
     *
     * @return String representation of this time (hh:mm).
     */
    public String toString() {
        String hours = String.valueOf(_hour), minutes = String.valueOf(_minute);
        if (_hour <= MAX_SINGLE_DIGIT) hours = ZERO_AS_STRING + hours;
        if (_minute <= MAX_SINGLE_DIGIT) minutes = ZERO_AS_STRING + minutes;
        return hours + ":" + minutes;
    }

    /**
     * Return the amount of minutes since midnight.
     *
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        return _hour * MINUTES_IN_HOUR + _minute;
    }

    /**
     * Check if the received time is equal to this time.
     *
     * @param other The time to be compared with this time.
     * @return True if the received time is equal to this time.
     */
    public boolean equals(Time1 other) {
        return (other.getHour() == _hour && _minute == other.getMinute());
    }

    /**
     * Check if this time is before a received time.
     *
     * @param other The time to check if this point is before.
     * @return True if this time is before other time.
     */
    public boolean before(Time1 other) {
        if (_hour < other.getHour()) return true;
        else if (_hour == other.getHour()) return _minute < other.getMinute();
        else return false;
    }

    /**
     * Check if this time is after a received time.
     *
     * @param other The time to check if this point is after.
     * @return True if this time is after other time.
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
     *
     * @param other The time to check the difference to.
     * @return int difference in minutes.
     */
    public int difference(Time1 other) {
        return Math.abs(((_hour - other.getHour()) * MINUTES_IN_HOUR) + (_minute - other.getMinute()));
    }

    /**
     * Calculates new time after add X minutes.
     *
     * @param num minutes to add.
     * @return new time instance after the change.
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


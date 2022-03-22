/**
 * Represents time - hours:minutes. Values must represent a proper time.
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
     * Constructs a Time2 object. Construct a new time instance with the specified hour and minute . hour should be between 0-23, otherwise it should be set to 0. minute should be between 0-59, otherwise they should be set to 0.
     *
     * @param h hour
     * @param m minutes
     */
    public Time2(int h, int m) {
        int hour = (h <= MAX_HOUR && h >= DEFAULT_VALUE) ? h : DEFAULT_VALUE;
        int minute = (m <= MAX_MINUTE && m >= DEFAULT_VALUE) ? m : DEFAULT_VALUE;
        _minFromMid = hour * MINUTES_IN_HOUR + minute;
    }

    /**
     * Copy constructor for Time2. Constructs a time with the same variables as another time.
     *
     * @param other The time object from which to construct the new time.
     */
    public Time2(Time2 other) {
        int hour = other.getHour();
        int minute = other.getMinute();
        _minFromMid = hour * MINUTES_IN_HOUR + minute;
    }

    /**
     * Returns the hour of the time.
     *
     * @return The hour of the time.
     */
    public int getHour() {
        return _minFromMid / MINUTES_IN_HOUR;
    }

    /**
     * Returns the minute of the time.
     *
     * @return The minute of the time.
     */
    public int getMinute() {
        return _minFromMid % MINUTES_IN_HOUR;
    }

    /**
     * Changes the hour of the time. If an illegal number is received hour will remain unchanged.
     *
     * @param num The new hour.
     */
    public void setHour(int num) {
        if (num <= MAX_HOUR && num >= DEFAULT_VALUE) {
            _minFromMid = _minFromMid - (this.getHour() * MINUTES_IN_HOUR) + num * MINUTES_IN_HOUR;
        }
    }

    /**
     * Changes the minute of the time. If an illegal number is received minute will remain unchanged.
     *
     * @param num The new minute.
     */
    public void setMinute(int num) {
        if (num <= MAX_MINUTE && num >= DEFAULT_VALUE) {
            _minFromMid = _minFromMid - this.getMinute() + num;
        }
    }

    /**
     * Returns a string representation of this time(hh:mm).
     *
     * @return String representation of this time(hh:mm).
     */
    public String toString() {
        String hours = String.valueOf(this.getHour()), minutes = String.valueOf(this.getMinute());
        if (this.getHour() <= MAX_SINGLE_DIGIT) hours = ZERO_AS_STRING + hours;
        if (this.getMinute() <= MAX_SINGLE_DIGIT) minutes = ZERO_AS_STRING + minutes;
        return hours + ":" + minutes;
    }

    /**
     * Return the amount of minutes since midnight.
     *
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        return _minFromMid;
    }

    /**
     * Checks if the received time is equal to this time.
     *
     * @param other The time to be compared with this time.
     * @return True if the received time is equal to this time.
     */
    public boolean equals(Time2 other) {
        return (other.minFromMidnight() == _minFromMid);
    }

    /**
     * Checks if this time is before a received time.
     *
     * @param other The time to check if this time is before.
     * @return True if this time is before other time.
     */
    public boolean before(Time2 other) {
        return _minFromMid < other.minFromMidnight();
    }

    /**
     * Checks if this time is after a received time.
     *
     * @param other The time to check if this time is after.
     * @return True if this time is after other time.
     */
    public boolean after(Time2 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference (in minutes) between two times.
     *
     * @param other The time to check the difference with. Assumption: this time is after other time.
     * @return int difference in minutes.
     */
    public int difference(Time2 other) {
        return _minFromMid - other.minFromMidnight();
    }

    /**
     * Calculates new time after add X minutes.
     *
     * @param num minutes to add.
     * @return new time instance after the change.
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



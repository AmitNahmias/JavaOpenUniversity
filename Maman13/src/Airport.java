import java.util.Arrays;

public class Airport {
    final int MAX_FLIGHTS = 200;

    private Flight[] _flightsSchedule;
    private int _noOfFlights;
    private String _city;

    public Airport(String city) {
        _city = new String(city);
        _flightsSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    public boolean addFlight(Flight f) {
        if (f.getOrigin().equals(_city) || f.getDestination().equals(_city)) {
            if (_noOfFlights < MAX_FLIGHTS) {
                _flightsSchedule[_noOfFlights] = new Flight(f);
                _noOfFlights++;
                return true;
            }
        }
        return false;
    }

    public boolean removeFlight(Flight f) {
        for (int flightNumber = 0; flightNumber < MAX_FLIGHTS; flightNumber++)
            if (_flightsSchedule[flightNumber].equals(f)) {
                _flightsSchedule[flightNumber] = new Flight(_flightsSchedule[_noOfFlights - 1]);
                _flightsSchedule[flightNumber] = null;
                return true;
            }
        return false;
    }

    public Time1 firstFlightFromOrigin(String place) {
        Time1 minTime = new Time1(23, 59);
        boolean isExists = false;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            if (_flightsSchedule[flightNumber].getOrigin().equals(place)) {
                isExists = true;
                if (minTime.before(_flightsSchedule[flightNumber].getDeparture()))
                    minTime = new Time1(_flightsSchedule[flightNumber].getDeparture());
            }
        }
        if (isExists)
            return minTime;
        return null;
    }

    public int howManyFullFlights() {
        int fullyFlightsCounter = 0;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            if (_flightsSchedule[flightNumber].getIsFull())
                fullyFlightsCounter++;
        }
        return fullyFlightsCounter;
    }

    public int howManyFlightsBetween(String place) {
        int counter = 0;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            Flight currentFlight = _flightsSchedule[flightNumber];
            if ((currentFlight.getOrigin().equals(_city) && currentFlight.getDestination().equals(place)) ||
                    (currentFlight.getOrigin().equals(place) && currentFlight.getDestination().equals(_city)))
                counter++;
        }
        return counter;
    }

    public String mostPopularDestination(String place) {
        int max = 0;
        String mostPopularDestination;
        if (Arrays.stream(_flightsSchedule).)
            for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
                String destination = new String(_flightsSchedule[flightNumber].getDestination());
                mostPopularDestination = new String(destination);
                int counter = 0;
                for (int flight = flightNumber + 1; flight < _noOfFlights; flight++) {
                    if (_flightsSchedule[flight].getDestination().equals(place))
                        counter++;
                }
                if (max < counter) {
                    max = counter;
                    mostPopularDestination = new String(destination);
                }
            }
        if (max == 0)
            return null;
        return mostPopularDestination;
    }
}
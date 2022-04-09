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
                _flightsSchedule[_noOfFlights - 1] = null;
                _noOfFlights--;
                return true;
            }
        return false;
    }

    public Time1 firstFlightFromOrigin(String place) {
        Time1 firstDeparture = new Time1(23, 59);
        boolean isExists = false;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            if (_flightsSchedule[flightNumber].getOrigin().equals(place)) {
                isExists = true;
                if (firstDeparture.after(_flightsSchedule[flightNumber].getDeparture()))
                    firstDeparture = new Time1(_flightsSchedule[flightNumber].getDeparture());
            }
        }
        if (isExists)
            return firstDeparture;
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

    public String mostPopularDestination() {
        int max = 0;
        String mostPopularDestination = null;
        if (_noOfFlights == 0)
            return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            String destination = new String(_flightsSchedule[flightNumber].getDestination());
            int counter = 1; // starts at one because we skip this flight in the next for
            for (int flight = flightNumber + 1; flight < _noOfFlights; flight++) {
                if (_flightsSchedule[flight].getDestination().equals(destination))
                    counter++;
            }
            if (max < counter) {
                max = counter;
                mostPopularDestination = new String(destination);
            }
        }
        return mostPopularDestination;
    }

    public Flight mostExpensiveTicket() {
        int maxPrice = 0;
        Flight mostExpensiveFlight = null;
        if (_noOfFlights == 0)
            return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            int ticketPrice = _flightsSchedule[flightNumber].getPrice();
            if (ticketPrice > maxPrice) {
                mostExpensiveFlight = new Flight(_flightsSchedule[flightNumber]);
                maxPrice = mostExpensiveFlight.getPrice();
            }
        }
        return mostExpensiveFlight;
    }

    public Flight longestFlight() {
        int maxDuration = 0;
        Flight longestFlight = null;
        if (_noOfFlights == 0)
            return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            int duration = _flightsSchedule[flightNumber].getFlightDuration();
            if (duration > maxDuration) {
                longestFlight = new Flight(_flightsSchedule[flightNumber]);
                maxDuration = longestFlight.getFlightDuration();
            }
        }
        return longestFlight;
    }

    public String toString() {
        if (_noOfFlights == 0)
            return null;
        String output = "The flights for airport " + _city + " today are:";
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            output = output + "\n";
            output = output + _flightsSchedule[flightNumber];
        }
        return output;
    }
}
/**
 * Represents an airport flights board.
 * A airport object represented by the number of flights, airport's city, list of flights.
 *
 * @author Amit Nahmias
 * @version 9.4.22
 */

public class Airport {
    final int MAX_FLIGHTS = 200;

    private Flight[] _flightsSchedule;
    private int _noOfFlights;
    private String _city;

    /**
     * Constructor for an airport flights board. The max flights number is 200.
     *
     * @param city The city of the airport.
     */
    public Airport(String city) {
        _city = new String(city);
        _flightsSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
    }

    /**
     * Add flight to the flights board.
     *
     * @param f The flight to add.
     * @return True if added successfully.
     */
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

    /**
     * Remove flight from the flights board.
     *
     * @param f The flight to remove.
     * @return True if removed successfully.
     */
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

    /**
     * Find the first flight from input city.
     *
     * @param place The origin city.
     * @return The departure time of the first flight.
     */
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
        if (isExists) return firstDeparture;
        return null;
    }

    /**
     * Count how many flight on board are fully booked.
     *
     * @return The number of full flights.
     */
    public int howManyFullFlights() {
        int fullyFlightsCounter = 0;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            if (_flightsSchedule[flightNumber].getIsFull()) fullyFlightsCounter++;
        }
        return fullyFlightsCounter;
    }

    /**
     * Takes input city and count how many flights there is between this city and airport's city.
     * Between meaning is the flight is from the input city to the airport's city or vice versa.
     *
     * @param city The other city.
     * @return The number of flights between those two cities.
     */
    public int howManyFlightsBetween(String city) {
        int counter = 0;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            Flight currentFlight = _flightsSchedule[flightNumber];
            if ((currentFlight.getOrigin().equals(_city) && currentFlight.getDestination().equals(city)) || (currentFlight.getOrigin().equals(city) && currentFlight.getDestination().equals(_city)))
                counter++;
        }
        return counter;
    }

    /**
     * Find the most popular destination city. If the board is empty return null. If there is few cities that
     * have the same maximum number of flights that landing there returns the first that found.
     *
     * @return The name of the first most popular destination city.
     */
    public String mostPopularDestination() {
        int max = 0;
        String mostPopularDestination = null;
        if (_noOfFlights == 0) return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            String destination = new String(_flightsSchedule[flightNumber].getDestination());
            int counter = 1; // starts at one because we skip this flight in the next for
            for (int flight = flightNumber + 1; flight < _noOfFlights; flight++) {
                if (_flightsSchedule[flight].getDestination().equals(destination)) counter++;
            }
            if (max < counter) {
                max = counter;
                mostPopularDestination = new String(destination);
            }
        }
        return mostPopularDestination;
    }

    /**
     * Find the most expensive flight. If the board is empty return null. If there is few flights that
     * have the same maximum price returns the first that found.
     *
     * @return The first most expensive flight.
     */
    public Flight mostExpensiveTicket() {
        int maxPrice = 0;
        Flight mostExpensiveFlight = null;
        if (_noOfFlights == 0) return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            int ticketPrice = _flightsSchedule[flightNumber].getPrice();
            if (ticketPrice > maxPrice) {
                mostExpensiveFlight = new Flight(_flightsSchedule[flightNumber]);
                maxPrice = mostExpensiveFlight.getPrice();
            }
        }
        return mostExpensiveFlight;
    }

    /**
     * Find the longest flight. If the board is empty return null. If there is few flights that
     * have the same maximum duration flights returns the first that found.
     *
     * @return The first longest flight.
     */
    public Flight longestFlight() {
        int maxDuration = 0;
        Flight longestFlight = null;
        if (_noOfFlights == 0) return null;
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            int duration = _flightsSchedule[flightNumber].getFlightDuration();
            if (duration > maxDuration) {
                longestFlight = new Flight(_flightsSchedule[flightNumber]);
                maxDuration = longestFlight.getFlightDuration();
            }
        }
        return longestFlight;
    }

    /**
     * Return a string representation of this airport (for example:
     * "The flights for airport Tel-Aviv today are:
     * Flight from Tel-Aviv to London departs at 12:00. Flight is full.
     * Flight from New York to Tel-Aviv departs at 10:50. Flight is full.").
     *
     * @return String representation of this airport (for example:
     * "The flights for airport Tel-Aviv today are:
     * Flight from Tel-Aviv to London departs at 12:00. Flight is full.
     * Flight from New York to Tel-Aviv departs at 10:50. Flight is full.").
     */
    public String toString() {
        if (_noOfFlights == 0) return null;
        String output = "The flights for airport " + _city + " today are:";
        for (int flightNumber = 0; flightNumber < _noOfFlights; flightNumber++) {
            output = output + "\n";
            output = output + _flightsSchedule[flightNumber];
        }
        return output;
    }
}
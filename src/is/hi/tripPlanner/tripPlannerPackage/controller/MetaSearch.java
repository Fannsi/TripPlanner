package is.hi.tripPlanner.tripPlannerPackage.controller;


import is.hi.tripPlanner.dayTourPackage.SearchModel;
import is.hi.tripPlanner.dayTourPackage.Trip;
import is.hi.tripPlanner.dayTourPackage.mockObjects.DayTourFetching;
import is.hi.tripPlanner.flightPackage.*;
import is.hi.tripPlanner.hotelPackage.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MetaSearch{
    private DayTourFetching dayTourSearchObject;

    public MetaSearch(DayTourFetching d){
        dayTourSearchObject = d;
    }

    public Trip[] getDayTourInfo(SearchModel s){
        // Check if end date occurs before the start date.
        if(s.getDateBegin() != null) {
            if(s.getDateEnd() != null){
                if (s.getDateEnd().before(s.getDateBegin())) {
                    return new Trip[0];
                }
            }
        }
        // Check if the price is negative (user being payed).
        if(s.getPrice() < 0){
            return new Trip[0];
        }

        return dayTourSearchObject.findResults(s);
    }

    /**
     * called from HotelUI,  fetches a list of hotels that fit search conditions from hotel program
     * @param searchHotel search object from hotel program,  gets hotel search results from their db
     * @return
     */
    public ArrayList<Hotel> getHotelInfo(SearchEngine searchHotel){
        // tilviksbreytan availableHotelList í SearchEngine geymir líklega  leitarniðurstöðurnar
        return new ArrayList();

    }


    /**
     *
     * @param searchFlight  search object from flight program
     * @return
     */
    public Flight[] getFlightInfo(Search searchFlight){
        // skv. domain modelinu er hjá 7F virðist tilviksbreytan availableFlightList geyma leitarniðurstöðurnar
        return new Flight[0];
    }

    /* --------------------------------------------------------- */
    /*                          Sort                             */
    /* --------------------------------------------------------- */

    // ======================   Flight   =======================
    // These functions are made but I don't seem to be able to find object of type "Flight" on their GitHub so this might be obsolete.

    // Sorts array f by departure time in descending order if desc = true, otherwise in ascending.
    public Flight[] sortByDeparture_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getDeparture() == null || f2.getDeparture() == null)
                        return 0;
                    return f1.getDeparture().compareTo(f2.getDeparture());
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getDeparture() == null || f2.getDeparture() == null)
                        return 0;
                    return f1.getDeparture().compareTo(f2.getDeparture());
                }
            }.reversed());
        }

        return f;
    }

    // Sorts array f by arrival time in descending order if desc = true, otherwise in ascending.
    public Flight[] sortByArrival_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getArrival() == null || f2.getArrival() == null)
                        return 0;
                    return f1.getArrival().compareTo(f2.getArrival());
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getArrival() == null || f2.getArrival() == null)
                        return 0;
                    return f1.getArrival().compareTo(f2.getArrival());
                }
            }.reversed());
        }

        return f;
    }

    // Sorts array f by location in descending order if desc = true, otherwise in ascending.
    public Flight[] sortByLocation_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getLocation() == null || f2.getLocation() == null)
                        return 0;
                    return f1.getLocation().compareTo(f2.getLocation());
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getLocation() == null || f2.getLocation() == null)
                        return 0;
                    return f1.getLocation().compareTo(f2.getLocation());
                }
            }.reversed());
        }

        return f;
    }

    // Sorts array f by destination in descending order if desc = true, otherwise in ascending.
    public Flight[] sortByDestination_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getDestination() == null || f2.getDestination() == null)
                        return 0;
                    return f1.getDestination().compareTo(f2.getDestination());
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getDestination() == null || f2.getDestination() == null)
                        return 0;
                    return f1.getDestination().compareTo(f2.getDestination());
                }
            }.reversed());
        }

        return f;
    }

    // Sorts array f by price in descending order if desc = true, otherwise in ascending.
    public Flight[] sortByPrice_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getPrice() == f2.getPrice())
                        return 0;
                    return f1.getPrice() < f2.getPrice() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getPrice() == f2.getPrice())
                        return 0;
                    return f1.getPrice() < f2.getPrice() ? -1 : 1;
                }
            }.reversed());
        }

        return f;
    }

    // Sorts array f by numbPeople in descending order if desc = true, otherwise in ascending.
    public Flight[] sortBynumbPeople_Flight(Flight[] f, boolean desc){
        if(desc){
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getNumbPeople() == f2.getNumbPeople())
                        return 0;
                    return f1.getNumbPeople() < f2.getNumbPeople() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Arrays.sort(f, new Comparator<Flight>() {
                public int compare(Flight f1, Flight f2) {
                    if (f1.getNumbPeople() == f2.getNumbPeople())
                        return 0;
                    return f1.getNumbPeople() < f2.getNumbPeople() ? -1 : 1;
                }
            }.reversed());
        }

        return f;
    }

    // ======================   Hotel    =======================
    // These functions are based off of the UML diagram which is already obsolete, highly likely this will have to be modified.

    // Sorts list h by location in descending order if desc = true, otherwise in ascending.
    public ArrayList<Hotel> sortByLocation_Hotel(ArrayList<Hotel> h, boolean desc){
        if(desc){
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getLocation() == null || h2.getLocation() == null)
                        return 0;
                    return h1.getLocation().compareTo(h2.getLocation());
                }
            }.reversed());
        }
        else{
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getLocation() == null || h2.getLocation() == null)
                        return 0;
                    return h1.getLocation().compareTo(h2.getLocation());
                }
            });
        }

        return h;
    }

    // Sorts list h by quality in descending order if desc = true, otherwise in ascending.
    public ArrayList<Hotel> sortByQuality_Hotel(ArrayList<Hotel> h, boolean desc){
        if(desc){
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getQuality() == h2.getQuality())
                        return 0;
                    return h1.getQuality() < h2.getQuality() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getQuality() == h2.getQuality())
                        return 0;
                    return h1.getQuality() < h2.getQuality() ? -1 : 1;
                }
            });
        }

        return h;
    }

    // Sorts list h by popularity in descending order if desc = true, otherwise in ascending.
    public ArrayList<Hotel> sortByPopularity_Hotel(ArrayList<Hotel> h, boolean desc){
        if(desc){
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getPopularity() == h2.getPopularity())
                        return 0;
                    return h1.getPopularity() < h2.getPopularity() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getPopularity() == h2.getPopularity())
                        return 0;
                    return h1.getPopularity() < h2.getPopularity() ? -1 : 1;
                }
            });
        }

        return h;
    }

    // Sorts list h by price in descending order if desc = true, otherwise in ascending.
    public ArrayList<Hotel> sortByPrice_Hotel(ArrayList<Hotel> h, boolean desc){
        if(desc){
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getPrice() == h2.getPrice())
                        return 0;
                    return h1.getPrice() < h2.getPrice() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Collections.sort(h, new Comparator<Hotel>() {
                public int compare(Hotel h1, Hotel h2) {
                    if (h1.getPrice() == h2.getPrice())
                        return 0;
                    return h1.getPrice() < h2.getPrice() ? -1 : 1;
                }
            });
        }

        return h;
    }

    // =====================   Day Tour   ======================
    // Sorts array t by starting date in descending order if desc = true, otherwise in ascending.
    public Trip[] sortByDate_Trip(Trip[] t, boolean desc){
        if(desc){
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getDateBegin() == null || t2.getDateBegin() == null)
                        return 0;
                    return t1.getDateBegin().compareTo(t2.getDateBegin());
                }
            }.reversed());
        }
        else{
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getDateBegin() == null || t2.getDateBegin() == null)
                        return 0;
                    return t1.getDateBegin().compareTo(t2.getDateBegin());
                }
            });
        }

        return t;
    }

    // Sorts array t by name in descending order if desc = true, otherwise in ascending.
    public Trip[] sortByTripName_Trip(Trip[] t, boolean desc){
        if(desc){
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getTripName() == null || t2.getTripName() == null)
                        return 0;
                    return t1.getTripName().compareTo(t2.getTripName());
                }
            }.reversed());
        }
        else{
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getTripName() == null || t2.getTripName() == null)
                        return 0;
                    return t1.getTripName().compareTo(t2.getTripName());
                }
            });
        }

        return t;
    }

    // Sorts array t location in descending order if desc = true, otherwise in ascending.
    public Trip[] sortByLocation_Trip(Trip[] t, boolean desc){
        if(desc){
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getLocation() == null || t2.getLocation() == null)
                        return 0;
                    return t1.getLocation().compareTo(t2.getLocation());
                }
            }.reversed());
        }
        else{
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getLocation() == null || t2.getLocation() == null)
                        return 0;
                    return t1.getLocation().compareTo(t2.getLocation());
                }
            });
        }

        return t;
    }

    // Sorts array t price in descending order if desc = true, otherwise in ascending.
    public Trip[] sortByPrice_Trip(Trip[] t, boolean desc){
        if(desc){
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getPrice() == t2.getPrice())
                        return 0;
                    return t1.getPrice() < t2.getPrice() ? -1 : 1;
                }
            }.reversed());
        }
        else{
            Arrays.sort(t, new Comparator<Trip>() {
                public int compare(Trip t1, Trip t2) {
                    if (t1.getPrice() == t2.getPrice())
                        return 0;
                    return t1.getPrice() < t2.getPrice() ? -1 : 1;
                }
            });
        }

        return t;
    }
}

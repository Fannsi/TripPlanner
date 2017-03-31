package is.hi.tripPlanner.tripPlannerPackage;

import is.hi.tripPlanner.dayTourPackage.mockObjects.DayTourFetching;
import is.hi.tripPlanner.dayTourPackage.SearchModel;
import is.hi.tripPlanner.dayTourPackage.Trip;

public class MetaSearch{
    private DayTourFetching dayTourSearchObject;

    public MetaSearch(DayTourFetching d){
        dayTourSearchObject = d;
    }

    public Trip[] getDayTourInfo(SearchModel s){
        // Check if end date occurs before the start date.
        if(s.getDateBegin() != null) {
            System.out.println("x");
            if(s.getDateEnd() != null){
                System.out.println("y");
                // Does not compare time, needs to be accounted for and fixed.
                if (s.getDateEnd().before(s.getDateEnd())) {
                    System.out.println("z");
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

}

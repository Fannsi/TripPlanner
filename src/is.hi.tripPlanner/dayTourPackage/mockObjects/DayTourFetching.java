package is.hi.tripPlanner.dayTourPackage.mockObjects;

import is.hi.tripPlanner.dayTourPackage.SearchObject;
import is.hi.tripPlanner.dayTourPackage.Trip;

public interface DayTourFetching {
    public Trip[] findResults(SearchObject s);
}

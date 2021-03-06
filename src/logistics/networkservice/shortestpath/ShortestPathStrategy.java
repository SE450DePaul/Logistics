package logistics.networkservice.shortestpath;

import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;

import java.util.Collection;

/**
 * Created by uchennafokoye on 5/2/16.
 */
public interface ShortestPathStrategy 
{
    Collection<String> shortestPathTo(String destination) throws FacilityNotFoundInNetworkException;
    int distanceTo(String destination) throws FacilityNotFoundInNetworkException;
}

package org.gzeng.observer;

import org.gzeng.observer.dao.TripDao;
import org.gzeng.observer.transport.Trip;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("trip")
public class TripResource {
    private TripDao tripDao;

    protected TripDao getDao() {
        return tripDao;
    }

    public void setDao(TripDao tripDao){
        this.tripDao = tripDao;
    }

    public String insertTrip(Trip trip) {
        if(trip==null){
            throw new WebApplicationException("Trip cannot be null");
        }
        return tripDao.insertTrip(trip);
    }

    public Trip getTrip(String tripId) {
        if(tripId==null){
            throw new WebApplicationException("Trip Id cannot be null");
        }
        if(tripId.isEmpty()){
            throw new WebApplicationException("Trip Id cannot be empty.");
        }
        return tripDao.getTrip(tripId);
    }
}

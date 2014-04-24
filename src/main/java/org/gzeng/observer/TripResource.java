package org.gzeng.observer;

import org.gzeng.observer.dao.TripDao;
import org.gzeng.observer.transport.Trip;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        return tripDao.insertTrip(trip);
    }
}

package org.gzeng.observer.resources;

import org.gzeng.observer.WebAppEx;
import org.gzeng.observer.dao.TripDao;
import org.gzeng.observer.transport.Trip;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resources (exposed at "myresource" path)
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertTrip(Trip trip) {
        if(trip==null){
            throw WebAppEx.make(Response.Status.BAD_REQUEST, "RSX4010", "Cannot insert a null trip.");
        }
        String tripId = tripDao.insertTrip(trip);
        trip.setTripId(tripId);
        return Response.ok(trip).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrip(String tripId) {
        if(tripId==null){
            throw WebAppEx.make(Response.Status.BAD_REQUEST, "RSX4010", "Trip Id cannot be null");
        }
        if(tripId.isEmpty()){
            throw WebAppEx.make(Response.Status.BAD_REQUEST, "RSX4010", "Trip Id cannot be empty.");
        }
        Trip trip = tripDao.getTrip(tripId);
        return Response.ok(trip).build();
    }

    public Response deleteTrip(String tripId) {
        return Response.ok().build();
    }
}

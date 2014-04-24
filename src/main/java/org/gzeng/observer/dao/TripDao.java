package org.gzeng.observer.dao;

import org.gzeng.observer.transport.Trip;

/**
 * Created by gaoxiangzeng on 24/04/14.
 */
public interface TripDao {
    public String insertTrip(Trip trip);
    public Trip getTrip(String tripId);
    public void updateTrip(Trip trip);
    public void deleteTrip(Trip trip);
}

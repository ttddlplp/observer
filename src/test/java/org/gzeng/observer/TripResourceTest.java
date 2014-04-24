package org.gzeng.observer;

import junit.framework.Assert;
import org.gzeng.observer.dao.TripDao;
import org.gzeng.observer.transport.Trip;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.WebApplicationException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by gaoxiangzeng on 24/04/14.
 */
public class TripResourceTest {

    private TripResource tripResource;
    @Mock
    private TripDao mockTripDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        tripResource = new TripResource();
        tripResource.setDao(mockTripDao);
    }

    @Test
    public void getDao_shouldNotBeNull(){
        Assert.assertNotNull(tripResource.getDao());
    }

    @Test
    public void insertTrip_daoInsertShouldBeCalled(){
        Trip trip = new Trip();
        tripResource.insertTrip(trip);
        verify(mockTripDao,times(1)).insertTrip(any(Trip.class));
    }

    @Test
    public void insertTrip_shouldReturnTripId(){
        when(mockTripDao.insertTrip(any(Trip.class))).thenReturn("TestId");
        Trip trip = new Trip();
        String result = tripResource.insertTrip(trip);
        Assert.assertEquals("TestId",result);
    }

    @Test(expected = WebApplicationException.class)
    public void insertNull_shouldThrowException(){
        tripResource.insertTrip(null);
    }

    @Test
    public void getTrip_shouldReturnATrip(){
        Trip expect = new Trip();
        expect.setArrivalCityName("London");
        when(mockTripDao.getTrip(anyString())).thenReturn(expect);

        Trip result = tripResource.getTrip("TestId");
        Assert.assertEquals(expect,result);
    }

    @Test(expected = WebApplicationException.class)
    public void getTripWithEmptyString_shouldGetException(){
        Trip expect = new Trip();
        expect.setArrivalCityName("London");
        when(mockTripDao.getTrip(anyString())).thenReturn(expect);
        Trip result = tripResource.getTrip("");
    }

    @Test(expected = WebApplicationException.class)
    public void getTripWithNull_shouldGetException(){
        Trip expect = new Trip();
        expect.setArrivalCityName("London");
        when(mockTripDao.getTrip(anyString())).thenReturn(expect);
        Trip result = tripResource.getTrip(null);
    }
}

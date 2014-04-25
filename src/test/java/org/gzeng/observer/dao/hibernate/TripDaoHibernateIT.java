package org.gzeng.observer.dao.hibernate;


import junit.framework.Assert;
import org.gzeng.observer.transport.Trip;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class TripDaoHibernateIT {
    private SessionFactory sessionFactory;
    private TripDaoHibernate tripDao;

    @Before
    public void setUp() throws IOException {
        sessionFactory = getSessionFactory();
        tripDao = new TripDaoHibernate();
        tripDao.setSessionFactory(sessionFactory);
    }
    @Test
    public void checkExistenceWithEmptyDB_shouldReturnFalse(){
        Assert.assertFalse(tripDao.isTripExists("TestId"));
    }

    @Test
    public void insertTrip_shouldReturnTripId(){
        Trip trip = new Trip();
        trip.setArrivalCityName("London");
        String result = tripDao.insertTrip(trip);
        Assert.assertNotNull(result);
        Assert.assertTrue(!result.isEmpty());
    }

    private SessionFactory getSessionFactory() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/Hibernate.properties"));
        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(TripDaoHibernate.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }
}

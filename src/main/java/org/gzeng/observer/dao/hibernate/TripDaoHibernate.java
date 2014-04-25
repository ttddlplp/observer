package org.gzeng.observer.dao.hibernate;

import org.gzeng.observer.dao.TripDao;
import org.gzeng.observer.transport.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class TripDaoHibernate implements TripDao{
    private SessionFactory sessionFactory;

    @Override
    public boolean isTripExists(String tripId) {
        return false;
    }

    @Override
    public String insertTrip(Trip trip) {
        if(delivery.getDeliveryID() != null) {
            throw new IllegalArgumentException("Cannot insert an address with a non-null delivery id");
        }
        ModelMapper modelMapper = new ModelMapper();
        TripEntity tripEntity = modelMapper.map(trip,TripEntity.class);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(deliveryEntity);
        session.getTransaction().commit();
        session.close();
        return deliveryEntity.getDeliveryId();
    }

    @Override
    public Trip getTrip(String tripId) {
        return null;
    }

    @Override
    public void updateTrip(Trip trip) {

    }

    @Override
    public void deleteTrip(Trip trip) {

    }

    @Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

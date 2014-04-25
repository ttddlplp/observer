package org.gzeng.observer.dao.hibernate;

import org.gzeng.observer.transport.Trip;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by gaoxiangzeng on 25/04/14.
 */

@Entity
public class TripEntity extends Trip {
    @Override
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    public String getTripId() {
        return super.getTripId();
    }

    @Override
    @Column
    public String getDepartureAirportName() {
        return super.getDepartureAirportName();
    }

    @Override
    @Column
    public String getDepartureCityName() {
        return super.getDepartureCityName();
    }

    @Override
    @Column
    public String getDepartureCountryName() {
        return super.getDepartureCountryName();
    }

    @Override
    @Column
    public String getDepartureAirportCode() {
        return super.getDepartureAirportCode();
    }

    @Override
    @Column
    public String getArrivalAirportName() {
        return super.getArrivalAirportName();
    }

    @Override
    @Column
    public String getArrivalCityName() {
        return super.getArrivalCityName();
    }

    @Override
    @Column
    public String getArrivalCountryName() {
        return super.getArrivalCountryName();
    }

    @Override
    @Column
    public String getArrivalAirportCode() {
        return super.getArrivalAirportCode();
    }

    @Override
    @Column
    public String getOutboundDate() {
        return super.getOutboundDate();
    }

    @Override
    @Column
    public String getReturnDate() {
        return super.getReturnDate();
    }

    @Override
    @Column
    public Integer getNumberOfAdults() {
        return super.getNumberOfAdults();
    }

    @Override
    @Column
    public Integer getNumberOfChildren() {
        return super.getNumberOfChildren();
    }

    @Override
    @Column
    public Integer getNumberOfInfants() {
        return super.getNumberOfInfants();
    }

    @Override
    @Column
    public Boolean getOneWay() {
        return super.getOneWay();
    }

    @Override
    @Column
    public Boolean getNonStopFlag() {
        return super.getNonStopFlag();
    }

    @Override
    @Column
    public String getUser() {
        return super.getUser();
    }

    @Override
    @Column
    public Double getPrice() {
        return super.getPrice();
    }
}

package org.gzeng.observer.transport;

import java.util.HashMap;
import java.util.Map;

public class Trip {
    private String tripId;
    private String departureAirportName;
    private String departureCityName;
    private String departureCountryName;
    private String departureAirportCode;
    private String arrivalAirportName;
    private String arrivalCityName;
    private String arrivalCountryName;
    private String arrivalAirportCode;
    private String outboundDate;
    private String returnDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private Integer numberOfInfants;
    private Boolean oneWay;
    private Boolean nonStopFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    public String getDepartureCountryName() {
        return departureCountryName;
    }

    public void setDepartureCountryName(String departureCountryName) {
        this.departureCountryName = departureCountryName;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
    }

    public String getArrivalCountryName() {
        return arrivalCountryName;
    }

    public void setArrivalCountryName(String arrivalCountryName) {
        this.arrivalCountryName = arrivalCountryName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfInfants() {
        return numberOfInfants;
    }

    public void setNumberOfInfants(Integer numberOfInfants) {
        this.numberOfInfants = numberOfInfants;
    }

    public Boolean getOneWay() {
        return oneWay;
    }

    public void setOneWay(Boolean oneWay) {
        this.oneWay = oneWay;
    }

    public Boolean getNonStopFlag() {
        return nonStopFlag;
    }

    public void setNonStopFlag(Boolean nonStopFlag) {
        this.nonStopFlag = nonStopFlag;
    }

}

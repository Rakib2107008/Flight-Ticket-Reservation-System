package com.example.demo1;

public class customerList {
    private String customerName;

    private String cuGmail;
    private String cuPassport;
    private String  cuNid;
    private String cuClass;
    private int cuTicketNo;
    private String cuDeparture;
    private String cuDestination;
    private String cuDate;
    private String cuTime;
    public String cuAirport;
    private String cuFlightName;
    private String cuFlightNo;
    private String cuSeatNo;
    private double cuPrice;
    private int cureservationid;

    public customerList(String customerName, String cuGmail, String cuPassport, String cuNid, String cuClass, int cuTicketNo, String cuDeparture, String cuDestination, String cuDate, String cuTime, String cuAirport, String cuFlightName, String cuFlightNo, String cuSeatNo, double cuPrice, int cureservationid) {
        this.customerName = customerName;
        this.cuGmail = cuGmail;
        this.cuPassport = cuPassport;
        this.cuNid = cuNid;
        this.cuClass = cuClass;
        this.cuTicketNo = cuTicketNo;
        this.cuDeparture = cuDeparture;
        this.cuDestination = cuDestination;
        this.cuDate = cuDate;
        this.cuTime = cuTime;
        this.cuAirport = cuAirport;
        this.cuFlightName = cuFlightName;
        this.cuFlightNo = cuFlightNo;
        this.cuSeatNo = cuSeatNo;
        this.cuPrice = cuPrice;
        this.cureservationid = cureservationid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCuGmail() {
        return cuGmail;
    }

    public void setCuGmail(String cuGmail) {
        this.cuGmail = cuGmail;
    }

    public String getCuPassport() {
        return cuPassport;
    }

    public void setCuPassport(String cuPassport) {
        this.cuPassport = cuPassport;
    }

    public String getCuNid() {
        return cuNid;
    }

    public void setCuNid(String cuNid) {
        this.cuNid = cuNid;
    }

    public String getCuClass() {
        return cuClass;
    }

    public void setCuClass(String cuClass) {
        this.cuClass = cuClass;
    }

    public int getCuTicketNo() {
        return cuTicketNo;
    }

    public void setCuTicketNo(int cuTicketNo) {
        this.cuTicketNo = cuTicketNo;
    }

    public String getCuDeparture() {
        return cuDeparture;
    }

    public void setCuDeparture(String cuDeparture) {
        this.cuDeparture = cuDeparture;
    }

    public String getCuDestination() {
        return cuDestination;
    }

    public void setCuDestination(String cuDestination) {
        this.cuDestination = cuDestination;
    }

    public String getCuDate() {
        return cuDate;
    }

    public void setCuDate(String cuDate) {
        this.cuDate = cuDate;
    }

    public String getCuTime() {
        return cuTime;
    }

    public void setCuTime(String cuTime) {
        this.cuTime = cuTime;
    }

    public String getCuAirport() {
        return cuAirport;
    }

    public void setCuAirport(String cuAirport) {
        this.cuAirport = cuAirport;
    }

    public String getCuFlightName() {
        return cuFlightName;
    }

    public void setCuFlightName(String cuFlightName) {
        this.cuFlightName = cuFlightName;
    }

    public String getCuFlightNo() {
        return cuFlightNo;
    }

    public void setCuFlightNo(String cuFlightNo) {
        this.cuFlightNo = cuFlightNo;
    }

    public String getCuSeatNo() {
        return cuSeatNo;
    }

    public void setCuSeatNo(String cuSeatNo) {
        this.cuSeatNo = cuSeatNo;
    }

    public double getCuPrice() {
        return cuPrice;
    }

    public void setCuPrice(double cuPrice) {
        this.cuPrice = cuPrice;
    }

    public int getCureservationid() {
        return cureservationid;
    }

    public void setCureservationid(int cureservationid) {
        this.cureservationid = cureservationid;
    }
}


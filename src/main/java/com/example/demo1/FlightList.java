package com.example.demo1;

public class FlightList {
    private int id;
    private String destination;
    private String departure;
    private String flightNo;
    private String airline;
    private String date;
    private String time;
    private String airport;
    private double Economy;
    private double FirstClass;
    private double Bussiness;
    private String bookedTicket;
    private int availableTicket;
    public FlightList(int id, String destination, String departure, String flightNo, String airline, String date, String time, String airport,double Economy, double FirstClass, double Bussiness,int availableTicket,String bookedTicket) {
        this.id = id;
        this.destination = destination;
        this.departure = departure;
        this.flightNo = flightNo;
        this.airline = airline;
        this.date = date;
        this.time = time;
        this.airport = airport;
        this.Economy = Economy;
        this.FirstClass = FirstClass;
        this.Bussiness = Bussiness;
        this.availableTicket = availableTicket;
        this.bookedTicket = bookedTicket;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }
    public double getEconomy() {
        return Economy;
    }
    public double getFirstClass() {
        return FirstClass;
    }
    public double getBussiness() {
        return Bussiness;
    }

    public String getDeparture() {
        return departure;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getAirline() {
        return airline;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAirport() {
        return airport;
    }
    public String getBookedTicket() {
        return bookedTicket;
    }
    public int getAvailableTicket() {
       // System.out.println(availableTicket);
        return availableTicket;

    }
}

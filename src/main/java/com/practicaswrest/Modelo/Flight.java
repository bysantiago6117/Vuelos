package com.practicaswrest.Modelo;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idf;

    @Column
    private Date departureDate;

    @Column
    private String departureAirportCode;

    @Column
    private String departureAirportName;

    @Column
    private String departureCity;

    @Column
    private String departureLocale;

    @Column
    private Date arrivalDate;

    @Column
    private String arrivalAirportCode;

    @Column
    private String arrivalAirportName;

    @Column
    private String arrivalCity;

    @Column
    private String arrivalLocale;

    @Column
    private int ticketPrice;

    @Column
    private  String ticketCurrency;

    @Column
    private  int flightNumber;

    @Column
    private int seatCapacity;

    @OneToMany(mappedBy = "flights")
    private Set<Booking> bookingSet;

    public Flight() {
    }

    public Flight(int idf, Date departureDate, String departureAirportCode, String departureAirportName, String departureCity, String departureLocale, Date arrivalDate, String arrivalAirportCode, String arrivalAirportName, String arrivalCity, String arrivalLocale, int ticketPrice, String ticketCurrency, int flightNumber, int seatCapacity) {
        this.idf = idf;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.departureLocale = departureLocale;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.arrivalLocale = arrivalLocale;
        this.ticketPrice = ticketPrice;
        this.ticketCurrency = ticketCurrency;
        this.flightNumber = flightNumber;
        this.seatCapacity = seatCapacity;
    }


    public Flight(Date departureDate, String departureAirportCode, String departureAirportName, String departureCity, String departureLocale, Date arrivalDate, String arrivalAirportCode, String arrivalAirportName, String arrivalCity, String arrivalLocale, int ticketPrice, String ticketCurrency, int flightNumber, int seatCapacity) {
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.departureLocale = departureLocale;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.arrivalLocale = arrivalLocale;
        this.ticketPrice = ticketPrice;
        this.ticketCurrency = ticketCurrency;
        this.flightNumber = flightNumber;
        this.seatCapacity = seatCapacity;
    }


    public int getId() {
        return idf;
    }

    public void setId(int id) {
        this.idf = idf;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureLocale() {
        return departureLocale;
    }

    public void setDepartureLocale(String departureLocale) {
        this.departureLocale = departureLocale;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalLocale() {
        return arrivalLocale;
    }

    public void setArrivalLocale(String arrivalLocale) {
        this.arrivalLocale = arrivalLocale;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketCurrency() {
        return ticketCurrency;
    }

    public void setTicketCurrency(String ticketCurrency) {
        this.ticketCurrency = ticketCurrency;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}

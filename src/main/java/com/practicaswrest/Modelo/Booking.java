package com.practicaswrest.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private BookingStatus status;

    @Column
    private String paymentToken;

    @Column
    private boolean checkedIn;

    @Column
    private String createdAt;

    @Column
    private String bookingReference;

    @ManyToOne
    @JoinColumn(name = "usuarioID", referencedColumnName = "idUsuario")
    private User users;

    @ManyToOne
    @JoinColumn(name = "outboundFlight", referencedColumnName = "idf")
    private Flight flights;


    public Booking(int id, BookingStatus status, String paymentToken, boolean checkedIn, String createdAt, String bookingReference, User users, Flight flights) {
        this.id = id;
        this.status = status;
        this.paymentToken = paymentToken;
        this.checkedIn = checkedIn;
        this.createdAt = createdAt;
        this.bookingReference = bookingReference;
        this.users = users;
        this.flights = flights;
    }

    public Booking(BookingStatus status, String paymentToken, boolean checkedIn, String createdAt, String bookingReference, User users, Flight flights) {
        this.status = status;
        this.paymentToken = paymentToken;
        this.checkedIn = checkedIn;
        this.createdAt = createdAt;
        this.bookingReference = bookingReference;
        this.users = users;
        this.flights = flights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = users;
    }

    public Flight getFlight() {
        return flights;
    }

    public void setFlight(Flight flight) {
        this.flights = flight;
    }
}

package com.practicaswrest.service;

import com.practicaswrest.Modelo.Booking;
import com.practicaswrest.Modelo.BookingStatus;

import java.util.List;

public interface IBooking {

    Booking findbyid(int id);

    List<Booking> findbystatus(BookingStatus status);

    List<Booking> findbycustomer(int id);

    List<Booking> Listarvuelos();

    List<Booking> listarxStatusYcustomer(BookingStatus status, int id);

    Booking crear(Booking booking, int id_customer, int id_vuelo);

    boolean existeReserva(int id);

    boolean comprobarUsuario(int id);

    boolean comprobarvuel(int id);

    void eliminar(int id);

    boolean existereservaporid(int id);



    List<Booking> findbyfligth(int id_vuelo);




}

package com.practicaswrest.service;

import com.practicaswrest.Modelo.Booking;
import Enumeraciones.BookingStatus;

import java.util.List;
import java.util.Optional;

public interface IBooking {

    Optional<Booking> findbyid(int id);

    List<Booking> findbystatus(BookingStatus status);

    List<Booking> findbycustomer(int id);

    List<Booking> Listarvuelos();

    List<Booking> listarxStatusYcustomer(BookingStatus status, int id);

    Booking crear(Booking booking, int userid, int id_vuelo);

    boolean existeReserva(int id);

    boolean comprobarUsuario(int id);

    boolean comprobarvuel(int id);

    void eliminar(int id);

    boolean existereservaporid(int id);



    List<Booking> findbyfligth(int id_vuelo);




}

package com.practicaswrest.service;

import com.practicaswrest.Modelo.Flight;

import java.util.Date;
import java.util.List;

public interface IFlight {

    List<Flight> ListarPordepartureAirportCode(String departureAirportCode);

    List<Flight> listaPorarrivalAirportCode(String airportcode);

    List<Flight> listapordepartureDate(Date departureDate);


     Flight crear(Flight flight);

     Flight actualizar(int id, Flight flight);

     void eliminar(int id);


     List<Flight> listarXairportCode(String airportCode, Date fecha);

     Boolean existeVueloxid(int id);



}

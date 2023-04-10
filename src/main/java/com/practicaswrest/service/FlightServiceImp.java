package com.practicaswrest.service;

import com.practicaswrest.Modelo.Flight;
import com.practicaswrest.repo.FlightReposity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightServiceImp implements IFlight{


    @Autowired
    private FlightReposity flightReposity;

    @Override
    public List<Flight> ListarPordepartureAirportCode(String departureAirportCode) {
        List<Flight> vuelos = flightReposity.findAll();
        List<Flight> vuelosXdepart = new ArrayList<>();

        for (Flight vuelo : vuelos) {
            if (vuelo.getDepartureAirportCode().equals(departureAirportCode)) {
                vuelosXdepart.add(vuelo);
            }
        }
        return vuelosXdepart;
    }

    @Override
    public List<Flight> listaPorarrivalAirportCode(String airportcode) {

        List<Flight> vuelos = flightReposity.findAll();
        List<Flight> vuelosXairport = new ArrayList<>();

        for (Flight vuelo : vuelos) {
            if (vuelo.getArrivalAirportCode().equals(airportcode)) {
                vuelosXairport.add(vuelo);
            }
        }
        return vuelosXairport;
    }

    @Override
    public List<Flight> listapordepartureDate(Date departureDate) {
        List<Flight> vuelos = flightReposity.findAll();
        List<Flight> vuelosXdeparDate = new ArrayList<>();

        for (Flight vuelo : vuelos) {
            if (vuelo.getDepartureDate().equals(departureDate)) {
                vuelosXdeparDate.add(vuelo);
            }
        }
        return vuelosXdeparDate;
    }

    @Override
    public Flight crear(Flight flight) {

        List<Flight> registrados = flightReposity.findAll();
        boolean comprobar = true;

        for (Flight registrado : registrados) {
            if (flight.getId() == registrado.getId()) {
                comprobar = false;
                break;
            }
        }

        if(comprobar){
            return flightReposity.save(flight);
        }

        return null;
    }

    @Override
    public Flight actualizar(int id, Flight flight) {
        flight.setId(id);
        return flightReposity.save(flight);
    }

    @Override
    public void eliminar(int id) {
         flightReposity.deleteById(id);
    }

    @Override
    public List<Flight> listarXairportCode(String airportCode, Date fecha) {
        List<Flight> vuelosxfecha = listapordepartureDate(fecha);
        List<Flight> vuelosXairportcode = new ArrayList<>();

        for (Flight flight : vuelosxfecha) {
            if (flight.getDepartureAirportCode().equals(airportCode)) {
                vuelosXairportcode.add(flight);
            }
        }

         return vuelosXairportcode;
    }

    @Override
    public Boolean existeVueloxid(int id) {
        return flightReposity.existsById(id);
    }
}

package com.practicaswrest.service;

import com.practicaswrest.Modelo.Flight;
import com.practicaswrest.repo.FlightReposity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
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
    public List<Flight> listapordepartureDate(String departureDate) {
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
        return flightReposity.save(flight);
    }

    @Override
    public Flight actualizar(int id, Flight flight) {
        Optional<Flight> optionalFlight = flightReposity.findById(id);
        BeanUtils.copyProperties(flight,optionalFlight.get());

        return flightReposity.save(optionalFlight.get());
    }

    @Override
    public void eliminar(int id) {
         flightReposity.deleteById(id);
    }

    @Override
    public List<Flight> listarXairportCode(String airportCode, String fecha) {
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

    @Override
    public Optional<Flight> vueloxid(int id) {

        Optional<Flight> opt = flightReposity.findById(id);
        return opt;
    }
}

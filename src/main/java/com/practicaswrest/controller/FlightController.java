package com.practicaswrest.controller;

import Dto.FlightDto;
import com.practicaswrest.Modelo.Flight;
import com.practicaswrest.service.IFlight;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {


    @Autowired
    private IFlight iFlight;

    @PostMapping("/catalog/")
    public ResponseEntity<?> crear(@RequestBody Flight flight){
        Flight result = iFlight.crear(flight);
        if(result == null ) {
            return new ResponseEntity<>("Ya existe un vuelo registrado con este usuario", HttpStatus.BAD_REQUEST);
        }

        FlightDto flightDto = new FlightDto();
        BeanUtils.copyProperties(result,flightDto);
        return new ResponseEntity<>(flightDto, HttpStatus.OK);
    }

    @PutMapping("/catalog/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody Flight flight){
        if(id == 0){
            return new ResponseEntity<>(" el vuelo no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }
        if(!iFlight.existeVueloxid(id)){
            return new ResponseEntity<>(" el vuelo no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }

        Flight result = iFlight.actualizar(id,flight);
        FlightDto flightDto = new FlightDto();
        BeanUtils.copyProperties(result,flightDto);
        return new ResponseEntity<>(flightDto, HttpStatus.OK);

    }


    @DeleteMapping("/catalog/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        if(!iFlight.existeVueloxid(id)){
            return new ResponseEntity<>(" el vuelo no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }

        iFlight.eliminar(id);
        return new ResponseEntity<>("el vuelo se ha eliminado sastifactoriamente",HttpStatus.OK);
    }


}

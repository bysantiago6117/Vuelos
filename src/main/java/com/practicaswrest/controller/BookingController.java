package com.practicaswrest.controller;

import Dto.BookingDTO;
import com.practicaswrest.Modelo.Booking;
import com.practicaswrest.Modelo.BookingStatus;
import com.practicaswrest.service.IBooking;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {


    @Autowired
    private IBooking iBooking;


    @GetMapping("/booking/{id}")
    public ResponseEntity<?> buscarReservaporid(@PathVariable int id){

        Booking result = iBooking.findbyid(id);

        if(result == null || !iBooking.existereservaporid(id)){
            return new ResponseEntity<>("mensaje: No se encuentra la reserva realizada", HttpStatus.BAD_REQUEST);
        }


        BookingDTO bookingDTO = new BookingDTO();
        BeanUtils.copyProperties(result,bookingDTO);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }


    @GetMapping("/booking/flight/{idflight}")
    public ResponseEntity<?> listarReservasPorVuelo(@PathVariable int id){
        if(iBooking.findbyfligth(id).size() == 0){
            return new ResponseEntity<>("mensaje: no hay reservas para ese vuelo, en este momento", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iBooking.findbyfligth(id),HttpStatus.OK);
    }

    @PostMapping("booking/flight/{idflight}/user/{iduser}")
    public ResponseEntity<?> Crear(@RequestBody Booking booking, int iduser, int idflight){
        Booking result = iBooking.crear(booking,iduser,idflight);

        if(result == null && !iBooking.comprobarUsuario(iduser)){
            return new ResponseEntity<>("El usuario que intenta ingresar no se encuentra registrado", HttpStatus.BAD_REQUEST);
        }
        if (result == null && !iBooking.comprobarvuel(idflight)){
            return new ResponseEntity<>("El vuelo que intenta ingresar no se encuentra registrado", HttpStatus.BAD_REQUEST);
        }

        BookingDTO bookingDTO = new BookingDTO();
        BeanUtils.copyProperties(result,bookingDTO);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);

    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> Eliminar(@PathVariable int id){


        if(!iBooking.existereservaporid(id)){
            return new ResponseEntity<>(" la reserva no se encuentra registrado",HttpStatus.BAD_REQUEST);
        }

        iBooking.eliminar(id);
        return new ResponseEntity<>("el usuario se ha eliminado sastifactoriamente",HttpStatus.OK);

    }

    @GetMapping("/booking/")
    public ResponseEntity<?> obtener(@RequestParam (required = false) BookingStatus status, @RequestParam (required = false) Integer id){
        List<Booking> result;

        if(status == null && id == null){
            result = iBooking.Listarvuelos();
        }else{
            result = iBooking.listarxStatusYcustomer(status,id);
        }

        if (status == null && id != null) {
            result = iBooking.findbycustomer(id);
        } else{
            result = iBooking.findbystatus(status);
        }


        return new ResponseEntity<>(result,HttpStatus.OK);
    }




}


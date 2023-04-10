package com.practicaswrest.service;

import com.practicaswrest.Modelo.User;

import java.util.List;

public interface IUser {

     User crearUsuario(User user);

     void eliminarusuario(int id);

     User actualizarusuario(int id, User user);


      boolean Existeelusuarioporid(int id);

     User findbyid(int id);

     List<User> listarUsuarios();




}

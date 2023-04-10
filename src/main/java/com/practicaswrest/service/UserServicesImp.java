package com.practicaswrest.service;

import com.practicaswrest.Modelo.User;
import com.practicaswrest.repo.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImp implements IUser{


    @Autowired
    private UserReposity userReposity;

    @Autowired EncryptServiceImp encryptServiceImp;


    @Override
    public User crearUsuario(User user) {


        List<User> registrados = userReposity.findAll();
        boolean comprobar = true;

        for (User registrado : registrados) {
            if (user.getId() == registrado.getId()) {
                comprobar = false;
                break;
            }
        }

        if(comprobar){
            user.setPassword(encryptServiceImp.encryptpassword(user.getPassword()));
            return userReposity.save(user);
        }

        return null;



    }



    @Override
    public void eliminarusuario(int id) {
          userReposity.deleteById(id);
    }

    @Override
    public User actualizarusuario(int id,User user) {
        User old = userReposity.getById(id);
        old.setFullname(user.getFullname());

        old.setPassword(encryptServiceImp.encryptpassword(user.getPassword()));
        old.setCorreo(user.getCorreo());

        return userReposity.save(old);
    }

    @Override
    public boolean Existeelusuarioporid(int id) {
        return userReposity.existsById(id);
    }


    @Override
    public User findbyid(int id) {
        return userReposity.getById(id);
    }

    @Override
    public List<User> listarUsuarios() {
        return userReposity.findAll();
    }
}

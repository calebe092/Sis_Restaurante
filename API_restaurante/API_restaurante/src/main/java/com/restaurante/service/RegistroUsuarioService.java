package com.restaurante.service;


import com.restaurante.model.Cargo;
import com.restaurante.model.Usuario;
import com.restaurante.repository.CargoRepository;
import com.restaurante.repository.UsuarioRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroUsuarioService {

    @Autowired
    public UsuarioRepositoy usuarioRepositoy;


    @Transactional
    public Usuario salvar (Usuario usuario){
        return usuarioRepositoy.save(usuario);
    }

    @Transactional
    public static void Excluir(Long usuarioId){

    }


    }






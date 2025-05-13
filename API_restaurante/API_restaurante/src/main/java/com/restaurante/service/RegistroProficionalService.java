package com.restaurante.service;

import com.restaurante.model.Proficional;
import com.restaurante.model.Usuario;
import com.restaurante.repository.ProdutoRepository;
import com.restaurante.repository.ProficionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProficionalService {

    @Autowired
    public ProficionalRepository proficionalRepository;


    @Transactional
    public Proficional salvar (Proficional proficional){
        return proficionalRepository.save(proficional);
    }

    @Transactional
    public static void Excluir(Long proficionalId){

    }

}

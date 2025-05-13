package com.restaurante.service;


import com.restaurante.model.Cargo;
import com.restaurante.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroCargoService {

    @Autowired
    public CargoRepository cargoRepository;


    @Transactional
    public Cargo salvar (Cargo cargo){
        return  cargoRepository.save(cargo);
    }

    @Transactional
    public static void Excluir(Long CargoId){

    }




}

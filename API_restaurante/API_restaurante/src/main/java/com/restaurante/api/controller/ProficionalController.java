package com.restaurante.api.controller;


import com.restaurante.handler.NegocioExeption;
import com.restaurante.model.Cargo;
import com.restaurante.model.Proficional;
import com.restaurante.repository.ProficionalRepository;
import com.restaurante.service.RegistroCargoService;
import com.restaurante.service.RegistroProficionalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proficionais")
public class ProficionalController {

    @Autowired
    public ProficionalRepository proficionalRepository;

    @Autowired
    public RegistroProficionalService registroProficionalService;


    @GetMapping
    public List<Proficional> listarProficional (){
        return proficionalRepository.findAll();
    }

    @GetMapping("/{proficionalId}")
    public ResponseEntity<Proficional> buscarProficional (@PathVariable Long proficionalId){
        return proficionalRepository.findById(proficionalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus
    @PostMapping
    public ResponseEntity<Proficional> adicionarProficional(@Valid @RequestBody Proficional proficional){
        Proficional P = proficionalRepository.save(proficional);
        return ResponseEntity.ok(P);
    }


    @PutMapping("/{proficionalId}")
    public ResponseEntity<Proficional> atualizarcargo(@PathVariable Long proficionalId,
                                                @RequestBody Proficional proficional){

        if (!proficionalRepository.existsById(proficionalId)){
            return ResponseEntity.notFound().build();

        }

        proficional.setId(proficionalId);
        Proficional atualizarProficional = registroProficionalService.salvar(proficional);


        return ResponseEntity.ok(atualizarProficional);
    }


    @DeleteMapping("/{proficionalId}")
    public ResponseEntity<Void> remover (@PathVariable Long proficionalId) {

        if (!proficionalRepository.existsById(proficionalId)){
            return ResponseEntity.notFound().build();
        }

        RegistroCargoService.Excluir(proficionalId);
        return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<String> capturar(NegocioExeption e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }












}

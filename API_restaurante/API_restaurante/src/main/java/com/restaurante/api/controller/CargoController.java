package com.restaurante.api.controller;


import com.restaurante.handler.NegocioExeption;
import com.restaurante.model.Cargo;
import com.restaurante.repository.CargoRepository;
import com.restaurante.service.RegistroCargoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    public CargoRepository cargoRepository;

    @Autowired
    public RegistroCargoService registroCargoService;



    @GetMapping
    public List<Cargo> listarCargo (){
        return cargoRepository.findAll();
    }


    @GetMapping("/{cargoId}")
    public ResponseEntity<Cargo> buscarCargo(@PathVariable Long cargoId ){
        return cargoRepository.findById(cargoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    @ResponseStatus
    public ResponseEntity<Cargo> adicionarCargo(@Valid @RequestBody Cargo cargo ){
        Cargo C = cargoRepository.save(cargo);
        return ResponseEntity.ok(C);
    }


    @PutMapping("/{cargoId}")
    public ResponseEntity<Cargo> atualizarcargo(@PathVariable Long cargoId,
                                                 @RequestBody Cargo cargo){

        if (!cargoRepository.existsById(cargoId)){
            return ResponseEntity.notFound().build();

        }

        cargo.setId(cargoId);
        Cargo atualizarcargo = registroCargoService.salvar(cargo);

        return ResponseEntity.ok(atualizarcargo);

    }

    @DeleteMapping("/{cargoId}")
    public ResponseEntity<Void> remover (@PathVariable Long cargoId) {

        if (!cargoRepository.existsById(cargoId)){
            return ResponseEntity.notFound().build();
        }

        RegistroCargoService.Excluir(cargoId);
        return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<String> capturar(NegocioExeption e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}

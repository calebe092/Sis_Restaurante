package com.restaurante.api.controller;


import com.restaurante.handler.NegocioExeption;
import com.restaurante.model.Usuario;
import com.restaurante.repository.UsuarioRepositoy;
import com.restaurante.service.RegistroCargoService;
import com.restaurante.service.RegistroUsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepositoy usuarioRepositoy;

    @Autowired
    RegistroUsuarioService registroUsuarioService;


    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioRepositoy.findAll();

    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long usuarioId) {
        return usuarioRepositoy.findById(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> adicioanarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario U = usuarioRepositoy.save(usuario);
        return ResponseEntity.ok(U);
    }


    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long usuarioId,
                                                    @RequestBody Usuario usuario){

        if (!usuarioRepositoy.existsById(usuarioId)){
            return ResponseEntity.notFound().build();
        }

        usuario.setId(usuarioId);
        Usuario  atualizarUsuario = registroUsuarioService.salvar(usuario);

        return ResponseEntity.ok(atualizarUsuario);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> remover (@PathVariable Long usuarioId) {

        if (!usuarioRepositoy.existsById(usuarioId)){
            return ResponseEntity.notFound().build();
        }

        RegistroCargoService.Excluir(usuarioId);
        return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<String> capturar(NegocioExeption e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}


























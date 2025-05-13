package com.restaurante.api.controller;


import com.restaurante.handler.NegocioExeption;
import com.restaurante.model.TipoProduto;
import com.restaurante.repository.TipoProdutoRepository;
import com.restaurante.service.RegistroTIpoProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tipoProdutos")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    RegistroTIpoProdutoService registroTIpoProdutoService;


    @GetMapping
    public List<TipoProduto> tipoProdutoListar() {
        return tipoProdutoRepository.findAll();
    }

    @GetMapping("/{idTipoProduto}")
    public ResponseEntity<TipoProduto> buscarTipoProduto(@PathVariable Long idTipoProduto) {
        return tipoProdutoRepository.findById(idTipoProduto)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus
    public TipoProduto adicionarTipoProduto(@Valid @RequestBody TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    @PutMapping("/{idTipoProduto}")
    public ResponseEntity<TipoProduto> atualizarTipoProduto(@PathVariable Long idTipoProduto,
                                                            @RequestBody TipoProduto tipoProduto) {
        if (!tipoProdutoRepository.existsById(idTipoProduto)) {
            return ResponseEntity.notFound().build();

        }

        tipoProduto.setId(idTipoProduto);
        TipoProduto tipoProdutoAtulizado = registroTIpoProdutoService.salvar(tipoProduto);

        return ResponseEntity.ok(tipoProdutoAtulizado);

    }

    @DeleteMapping("/{idTipoProduto}")
    public ResponseEntity<Void> remover(@PathVariable Long idTipoProduto) {
        if (!tipoProdutoRepository.existsById(idTipoProduto)) {
            return ResponseEntity.notFound().build();

        }
        registroTIpoProdutoService.Excluir(idTipoProduto);
        return ResponseEntity.noContent().build();


    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<String> capturar(NegocioExeption e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

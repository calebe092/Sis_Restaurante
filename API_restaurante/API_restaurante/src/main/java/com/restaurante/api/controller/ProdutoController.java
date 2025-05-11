package com.restaurante.api.controller;


import com.restaurante.handler.NegocioExeption;
import com.restaurante.model.Produto;
import com.restaurante.repository.ProdutoRepository;
import com.restaurante.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    private final ProdutoService produtoService;

    @GetMapping
    public List<Produto> ProdutoListar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long produtoId) {
        return produtoRepository.findById(produtoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus
    @PostMapping
    public Produto adicionarProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{produtoId}")
public ResponseEntity<Produto> AtualizarProduto(@PathVariable Long produtoId,
                                                @RequestBody Produto produto){
        if(!produtoRepository.existsById(produtoId)){
            return ResponseEntity.notFound().build();
        }

        produto.setId(produtoId);
        Produto produtoAtualizado = produtoRepository.save(produto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> remover(@PathVariable Long produtoId) {
        if (!produtoRepository.existsById(produtoId)) {
            return ResponseEntity.notFound().build();

        }
        produtoService.Excluir(produtoId);
        return ResponseEntity.noContent().build();


    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<String> capturar(NegocioExeption e ){
        return ResponseEntity.badRequest().body(e.getMessage());
    }



 }


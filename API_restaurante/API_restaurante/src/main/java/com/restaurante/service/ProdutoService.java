package com.restaurante.service;

import com.restaurante.model.Produto;
import com.restaurante.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public Produto salvar (Produto produto){
        return produtoRepository.save(produto);
    }

    @Transactional
    public void Excluir(Long produtoId){

    }
}


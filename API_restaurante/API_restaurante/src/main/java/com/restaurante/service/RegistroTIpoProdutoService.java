package com.restaurante.service;

import com.restaurante.model.TipoProduto;
import com.restaurante.repository.TipoProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroTIpoProdutoService {

    @Autowired
    private final TipoProdutoRepository tipoProdutoRepository;


    @Transactional
    public TipoProduto salvar ( TipoProduto tipoProduto){
        return tipoProdutoRepository.save(tipoProduto);
    }

    @Transactional
    public void Excluir(Long idTipoProduto){

    }
}


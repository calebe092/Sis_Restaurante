package com.restaurante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode
@Entity
public class Produto {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(name = "id")
    @Getter
    @Setter
    public long id;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "nome", nullable = true, unique = true)
    public String nome;


    @Getter
    @Setter
    @Column(name = "valor", nullable = true)
    public BigDecimal valor;


    @Getter
    @Setter
    @Column(name = "descricao", nullable = false)
    public String descricao;


    @Getter
    @Setter
    @Column(name = "validade", nullable = true)
    public LocalDate validade;

    @Getter
    @Setter
    @Column(name = "quantidade", nullable = true)
    public int quantidade = 0;

    @Getter
    @Setter
    @Column(name = "estoque", nullable = true)
    public Boolean estoque = Boolean.FALSE;

    public Produto() {
    }

    public Produto(long id, String nome, BigDecimal valor, String descricao, LocalDate validade, int quantidade, Boolean estoque) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.validade = validade;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }
}

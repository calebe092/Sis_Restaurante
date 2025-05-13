package com.restaurante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Entity
public class TipoProduto {


    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Getter
    @Setter
    @Column(name = "id", nullable = true)
    public Long id;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "nome", nullable = true, unique = true)
    public String nome;

    @Column(name = "decricao", nullable = false)
    @Getter
    @Setter
    public String descricao;

    public TipoProduto() {
    }

    public TipoProduto(Long id, String nome, String decricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = decricao;
    }
}

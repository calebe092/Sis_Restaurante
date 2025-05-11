package com.restaurante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
public class Cargo {


    @Id
    @Getter
    @Setter
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = true)
    public Long id;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "nome", nullable = true,unique = true)
    public String nome;

    @Getter
    @Setter
    @Column(name = "descricao", nullable = true)
    public String descricao;



}

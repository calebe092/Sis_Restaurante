package com.restaurante.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode
@Entity
public class Proficional {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Getter
    @Setter
    @Column(name = "id")
    public  Long id;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "nome", nullable = true,unique = true )
    public String nome;

    @Getter
    @Setter
    @Column(name = "sexo", nullable = true)
    public char sexo ;


    @Getter
    @Setter
    @Column(name = "data_nascimento", nullable = false)
    public LocalDate data_nascimento;


    @Getter
    @Setter
    @NotBlank
    @Column(name = "cpf", nullable = false)
    public String cpf;
}

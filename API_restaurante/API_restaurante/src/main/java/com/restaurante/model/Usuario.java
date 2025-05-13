package com.restaurante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
public class Usuario {

    @GeneratedValue
    @EqualsAndHashCode.Include
    @Getter
    @Setter
    @Id
    @Column(name = "id", nullable = true)
    public Long id ;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "name", nullable = true,unique = true)
    public String nome;

    @Email
    @Getter
    @Setter
    @Column(name = "e_mail", nullable = true,unique = true)
    public String e_mail;


    @Getter
    @Setter
    @Column(name = "senha", nullable = false,unique = true)
    public String senha;


}

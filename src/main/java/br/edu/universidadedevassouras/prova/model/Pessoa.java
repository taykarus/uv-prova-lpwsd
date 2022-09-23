package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    private String tipoSanguineo;

    @Column(nullable = false)
    private String pai;

    @Column(nullable = false)
    private String mae;
}
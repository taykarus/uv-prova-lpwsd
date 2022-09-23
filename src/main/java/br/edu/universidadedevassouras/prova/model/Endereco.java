package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String tipoLogradouro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String pais;

    @OneToOne
    private Pessoa pessoa;
}

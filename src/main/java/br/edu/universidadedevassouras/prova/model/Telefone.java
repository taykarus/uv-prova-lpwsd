package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String fixo;

    @OneToOne
    private Pessoa pessoa;
}

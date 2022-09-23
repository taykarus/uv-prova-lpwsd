package br.edu.universidadedevassouras.prova.repository;

import br.edu.universidadedevassouras.prova.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

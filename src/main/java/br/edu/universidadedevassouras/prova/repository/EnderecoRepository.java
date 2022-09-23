package br.edu.universidadedevassouras.prova.repository;

import br.edu.universidadedevassouras.prova.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

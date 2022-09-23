package br.edu.universidadedevassouras.prova.repository;

import br.edu.universidadedevassouras.prova.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}

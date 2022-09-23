package br.edu.universidadedevassouras.prova.controller;

import br.edu.universidadedevassouras.prova.model.Pessoa;
import br.edu.universidadedevassouras.prova.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {
    @Autowired
    private PessoaRepository _pessoaRepository;

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return _pessoaRepository.findAll();
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id) {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if (pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa) {
        return _pessoaRepository.save(pessoa);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa) {
        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
        if (oldPessoa.isPresent()) {
            Pessoa pessoa = oldPessoa.get();
            if (newPessoa.getNome() != null) { pessoa.setNome(newPessoa.getNome()); }
            if (newPessoa.getEmail() != null) { pessoa.setEmail(newPessoa.getEmail()); }
            if (newPessoa.getDataNascimento() != null) { pessoa.setDataNascimento(newPessoa.getDataNascimento()); }
            if (newPessoa.getSexo() != null) { pessoa.setSexo(newPessoa.getSexo()); }
            if (newPessoa.getCpf() != null) { pessoa.setCpf(newPessoa.getCpf()); }
            if (newPessoa.getRg() != null) { pessoa.setRg(newPessoa.getRg()); }
            if (newPessoa.getTipoSanguineo() != null) { pessoa.setTipoSanguineo(newPessoa.getTipoSanguineo()); }
            if (newPessoa.getPai() != null) { pessoa.setPai(newPessoa.getPai()); }
            if (newPessoa.getMae() != null) { pessoa.setMae(newPessoa.getMae()); }
            _pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            _pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

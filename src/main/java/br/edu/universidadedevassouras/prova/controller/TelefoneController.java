package br.edu.universidadedevassouras.prova.controller;

import br.edu.universidadedevassouras.prova.model.Telefone;
import br.edu.universidadedevassouras.prova.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TelefoneController {
    @Autowired
    private TelefoneRepository _telefoneRepository;

    @RequestMapping(value = "/telefone", method = RequestMethod.GET)
    public List<Telefone> Get() {
        return _telefoneRepository.findAll();
    }

    @RequestMapping(value = "/telefone/{id}", method = RequestMethod.GET)
    public ResponseEntity<Telefone> GetById(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = _telefoneRepository.findById(id);
        if (telefone.isPresent())
            return new ResponseEntity<Telefone>(telefone.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/telefone", method = RequestMethod.POST)
    public Telefone Post(@Valid @RequestBody Telefone telefone) {
        return _telefoneRepository.save(telefone);
    }

    @RequestMapping(value = "/telefone/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Telefone> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Telefone newTelefone) {
        Optional<Telefone> oldTelefone = _telefoneRepository.findById(id);
        if (oldTelefone.isPresent()) {
            Telefone telefone = oldTelefone.get();
            if (newTelefone.getCelular() != null) { telefone.setCelular(newTelefone.getCelular()); }
            if (newTelefone.getFixo() != null) { telefone.setFixo(newTelefone.getFixo()); }
            _telefoneRepository.save(telefone);
            return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/telefone/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = _telefoneRepository.findById(id);
        if (telefone.isPresent()) {
            _telefoneRepository.delete(telefone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

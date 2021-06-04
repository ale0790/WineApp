package br.com.wine.WineApp.controller;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeConflictException;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeNotFoundException;
import br.com.wine.WineApp.exception.ZipCodeInitialLessZipCodeEndException;
import br.com.wine.WineApp.service.LojaFaixaCepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/loja")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LojaController implements LojaControllerDocs{

    private final LojaFaixaCepService lojaFaixaCepService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LojaFaixaCepDTO createLojaFaixaCep(@RequestBody @Valid LojaFaixaCepDTO lojaFaixaCepDTO) throws LojaFaixaZipCodeConflictException,ZipCodeInitialLessZipCodeEndException {
        return lojaFaixaCepService.createLojaFaixaCep(lojaFaixaCepDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LojaFaixaCepDTO updateLojaFaixaCep(@RequestBody @Valid LojaFaixaCepDTO lojaFaixaCepDTO) throws LojaFaixaZipCodeNotFoundException, ZipCodeInitialLessZipCodeEndException {
        return lojaFaixaCepService.updateLojaFaixaCep(lojaFaixaCepDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws LojaFaixaZipCodeNotFoundException {
        lojaFaixaCepService.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LojaFaixaCepDTO> findAll(){

        return lojaFaixaCepService.listAll();
    }


}

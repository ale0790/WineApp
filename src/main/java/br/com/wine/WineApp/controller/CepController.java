package br.com.wine.WineApp.controller;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.exception.StoreMatchingZipCodeNotFoundException;
import br.com.wine.WineApp.service.LojaFaixaCepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/cep")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CepController {

    private final LojaFaixaCepService lojaFaixaCepService;

    @GetMapping("/{zipCode}")
    public LojaFaixaCepDTO findByZipcode(String zipCode) throws StoreMatchingZipCodeNotFoundException {
        return lojaFaixaCepService.findByCep(zipCode);
    }

}

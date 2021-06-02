package br.com.wine.WineApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LojaFaixaZipCodeNotFoundException extends Exception {

    public LojaFaixaZipCodeNotFoundException(Long id) {
        super(String.format("Zip cod with id %s not found in the system.", id));
    }
}

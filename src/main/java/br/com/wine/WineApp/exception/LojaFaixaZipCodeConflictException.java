package br.com.wine.WineApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LojaFaixaZipCodeConflictException extends Exception {

    public LojaFaixaZipCodeConflictException(String codigoLoja, String zipCode) {
        super(String.format("The Store with code %s already meets the zip code: %s.", codigoLoja, zipCode));
    }
}

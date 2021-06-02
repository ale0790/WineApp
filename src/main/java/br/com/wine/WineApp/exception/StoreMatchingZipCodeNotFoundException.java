package br.com.wine.WineApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StoreMatchingZipCodeNotFoundException extends Exception{


    public StoreMatchingZipCodeNotFoundException(String cep) {
        super(String.format("No stores matching zip code %s were found in the system.", cep));
    }

}

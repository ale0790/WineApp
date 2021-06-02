package br.com.wine.WineApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZipCodeInitialLessZipCodeEndException extends Exception {

    public ZipCodeInitialLessZipCodeEndException(String zipCodeInitial, String zipCodeFinal) {
        super(String.format("The initial zip code %s smaller than the final zip code %s.", zipCodeInitial, zipCodeFinal));
    }
}

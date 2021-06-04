package br.com.wine.WineApp.controller;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeConflictException;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeNotFoundException;
import br.com.wine.WineApp.exception.ZipCodeInitialLessZipCodeEndException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@Api("Controle para faixa de cep das lojas")
public interface LojaControllerDocs {

    @ApiOperation(value = "Cadastro de faixa de cep para loja")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Faixa criada com sucesso"),
            @ApiResponse(code = 400, message ="Campos obrigatórios ausentes ou valor de intervalo de campo incorreto.")
    })
    public LojaFaixaCepDTO createLojaFaixaCep(@RequestBody @Valid LojaFaixaCepDTO lojaFaixaCepDTO) throws LojaFaixaZipCodeConflictException, ZipCodeInitialLessZipCodeEndException;

    @ApiOperation(value = "Deleta faixa de cep se for informado um ID valido")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Faixa de cep da loja exclúida com sucesso"),
            @ApiResponse(code = 404, message = "ID informado não encontrado no sistema")
    })
    public void deleteById(@PathVariable Long id) throws LojaFaixaZipCodeNotFoundException;

}

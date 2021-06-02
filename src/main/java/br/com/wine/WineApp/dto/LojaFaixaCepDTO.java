package br.com.wine.WineApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaFaixaCepDTO {

    private Long id;

    @NotNull
    private String codigoLoja;


    @NotNull
    private String faixaInicio;


    @NotNull
    private String faixaFim;



}

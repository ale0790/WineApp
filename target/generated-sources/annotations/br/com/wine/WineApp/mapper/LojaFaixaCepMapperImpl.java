package br.com.wine.WineApp.mapper;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.model.LojaFaixaCep;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-04T09:58:31-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class LojaFaixaCepMapperImpl implements LojaFaixaCepMapper {

    @Override
    public LojaFaixaCep toModel(LojaFaixaCepDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        LojaFaixaCep lojaFaixaCep = new LojaFaixaCep();

        lojaFaixaCep.setId( beerDTO.getId() );
        lojaFaixaCep.setCodigoLoja( beerDTO.getCodigoLoja() );
        lojaFaixaCep.setFaixaInicio( beerDTO.getFaixaInicio() );
        lojaFaixaCep.setFaixaFim( beerDTO.getFaixaFim() );

        return lojaFaixaCep;
    }

    @Override
    public LojaFaixaCepDTO toDTO(LojaFaixaCep beer) {
        if ( beer == null ) {
            return null;
        }

        LojaFaixaCepDTO lojaFaixaCepDTO = new LojaFaixaCepDTO();

        lojaFaixaCepDTO.setId( beer.getId() );
        lojaFaixaCepDTO.setCodigoLoja( beer.getCodigoLoja() );
        lojaFaixaCepDTO.setFaixaInicio( beer.getFaixaInicio() );
        lojaFaixaCepDTO.setFaixaFim( beer.getFaixaFim() );

        return lojaFaixaCepDTO;
    }
}

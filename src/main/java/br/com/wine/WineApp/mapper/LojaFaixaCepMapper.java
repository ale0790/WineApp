package br.com.wine.WineApp.mapper;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.model.LojaFaixaCep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LojaFaixaCepMapper {

    LojaFaixaCepMapper INSTANCE = Mappers.getMapper(LojaFaixaCepMapper.class);

    LojaFaixaCep toModel(LojaFaixaCepDTO beerDTO);

    LojaFaixaCepDTO toDTO(LojaFaixaCep beer);

}
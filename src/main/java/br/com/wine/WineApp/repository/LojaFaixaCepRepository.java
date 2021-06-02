package br.com.wine.WineApp.repository;


import br.com.wine.WineApp.model.LojaFaixaCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LojaFaixaCepRepository extends JpaRepository<LojaFaixaCep, Long> {


    @Query("SELECT u FROM LojaFaixaCep u WHERE u.faixaInicio <= :zipCode AND u.faixaFim >= :zipCode")
    Optional<LojaFaixaCep> findStoreByZipCode(@Param("zipCode") String zipCode);

}

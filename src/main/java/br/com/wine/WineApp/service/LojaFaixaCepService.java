package br.com.wine.WineApp.service;

import br.com.wine.WineApp.dto.LojaFaixaCepDTO;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeConflictException;
import br.com.wine.WineApp.exception.LojaFaixaZipCodeNotFoundException;
import br.com.wine.WineApp.exception.StoreMatchingZipCodeNotFoundException;
import br.com.wine.WineApp.exception.ZipCodeInitialLessZipCodeEndException;
import br.com.wine.WineApp.mapper.LojaFaixaCepMapper;
import br.com.wine.WineApp.model.LojaFaixaCep;
import br.com.wine.WineApp.repository.LojaFaixaCepRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LojaFaixaCepService {

    private final LojaFaixaCepRepository lojaFaixaCepRepository;
    private final LojaFaixaCepMapper lojaFaixaCepMapper = LojaFaixaCepMapper.INSTANCE;

    public LojaFaixaCepDTO findByCep(String zipCode) throws StoreMatchingZipCodeNotFoundException {
        LojaFaixaCep foundLojaFaixaCep = lojaFaixaCepRepository.findStoreByZipCode(zipCode)
                .orElseThrow(() -> new StoreMatchingZipCodeNotFoundException(zipCode));
        return lojaFaixaCepMapper.toDTO(foundLojaFaixaCep);
    }

    public LojaFaixaCepDTO updateLojaFaixaCep(LojaFaixaCepDTO lojaFaixaCepDTO) throws LojaFaixaZipCodeNotFoundException, ZipCodeInitialLessZipCodeEndException {
        verifyIfExists(lojaFaixaCepDTO.getId());
        checkIfStartRangeIsLessThanEndRange(lojaFaixaCepDTO.getFaixaInicio(), lojaFaixaCepDTO.getFaixaFim());
        LojaFaixaCep lojaFaixaCep = lojaFaixaCepMapper.toModel(lojaFaixaCepDTO);
        LojaFaixaCep updatedLojaFaixaCep = lojaFaixaCepRepository.save(lojaFaixaCep);
        return lojaFaixaCepMapper.toDTO(updatedLojaFaixaCep);
    }


    public LojaFaixaCepDTO createLojaFaixaCep(LojaFaixaCepDTO lojaFaixaCepDTO) throws LojaFaixaZipCodeConflictException, ZipCodeInitialLessZipCodeEndException {
        checkIfStartRangeIsLessThanEndRange(lojaFaixaCepDTO.getFaixaInicio(), lojaFaixaCepDTO.getFaixaFim());
        checkConflictTrackZipCode(lojaFaixaCepDTO.getFaixaInicio(), lojaFaixaCepDTO.getFaixaFim());
        LojaFaixaCep lojaFaixaCep = lojaFaixaCepMapper.toModel(lojaFaixaCepDTO);
        LojaFaixaCep savedLojaFaixaCep = lojaFaixaCepRepository.save(lojaFaixaCep);
        return lojaFaixaCepMapper.toDTO(savedLojaFaixaCep);
    }

    public List<LojaFaixaCepDTO> listAll() {
        return lojaFaixaCepRepository.findAll()
                .stream()
                .map(lojaFaixaCepMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws LojaFaixaZipCodeNotFoundException {
        verifyIfExists(id);
        lojaFaixaCepRepository.deleteById(id);
    }

    private void checkIfStartRangeIsLessThanEndRange(String zipCodeInitial, String zipCodeFinal) throws ZipCodeInitialLessZipCodeEndException {
        Integer zipCodeInit = Integer.parseInt(zipCodeInitial);
        Integer zipCodeEnd = Integer.parseInt(zipCodeFinal);
        if(zipCodeEnd < zipCodeInit){
            throw new ZipCodeInitialLessZipCodeEndException(zipCodeInitial, zipCodeFinal);
        }
    }

    private LojaFaixaCep verifyIfExists(Long id) throws LojaFaixaZipCodeNotFoundException {
        return lojaFaixaCepRepository.findById(id)
                .orElseThrow(() -> new LojaFaixaZipCodeNotFoundException(id));
    }

    private void checkConflictTrackZipCode(String faixaInicio, String faixaFim) throws LojaFaixaZipCodeConflictException {
        Optional<LojaFaixaCep> optStoreFoundInitZipCode = lojaFaixaCepRepository.findStoreByZipCode(faixaInicio);

        if (optStoreFoundInitZipCode.isPresent()) {
            throw new LojaFaixaZipCodeConflictException(optStoreFoundInitZipCode.get().getCodigoLoja(), faixaInicio);
        }

        Optional<LojaFaixaCep> optStoreFoundFinalZipCode = lojaFaixaCepRepository.findStoreByZipCode(faixaInicio);
        if (optStoreFoundInitZipCode.isPresent()) {
            throw new LojaFaixaZipCodeConflictException(optStoreFoundInitZipCode.get().getCodigoLoja(), faixaFim);
        }
    }
}

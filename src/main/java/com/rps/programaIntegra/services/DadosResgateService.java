package com.rps.programaIntegra.services;

import com.rps.programaIntegra.dto.DadosResgateDTO;
import com.rps.programaIntegra.entities.DadosResgate;
import com.rps.programaIntegra.repositories.DadosResgateRepository;
import com.rps.programaIntegra.services.exceptions.ResourcesNotFoudException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosResgateService {
    @Autowired
    private DadosResgateRepository repository;

    public DadosResgateDTO insert(DadosResgateDTO dto) {
        try {
            DadosResgate entity = new DadosResgate();
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new DadosResgateDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoudException("Recurso não encontrado");
        }

    }

    private void copyDtoToEntity(DadosResgateDTO dto, DadosResgate entity) {
        entity.setCfp_cnpj(dto.getCfp_cnpj());
        entity.setNome(dto.getNome());
        entity.setRepresentante(dto.getRepresentante());
        entity.setTipo(dto.getTipo());
        entity.setFinalidade(dto.getFinalidade());
        entity.setPesquisa(dto.getJudicial());
    }

}

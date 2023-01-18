package com.rps.programaIntegra.services;

import com.rps.programaIntegra.dto.PesquisaDTO;
import com.rps.programaIntegra.entities.Pesquisa;
import com.rps.programaIntegra.repositories.PesquisaRepository;
import com.rps.programaIntegra.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PesquisaService {

    @Autowired
    private PesquisaRepository repository;

    @Transactional(readOnly = true)
    public PesquisaDTO findById(Long id){
        Pesquisa pesquisa = repository.findById(id).get();
        return new PesquisaDTO();

    }

    @Transactional(readOnly = true)
    public PesquisaDTO findBycontaJudicial(Integer judicial){
        try {
            Pesquisa pesquisa = repository.findByjudicial(judicial);
            return new PesquisaDTO(pesquisa);
        }
        catch (EntityNotFoundException e){
            throw new DatabaseException("Recurso não encontrado");
        }
        catch (NoSuchElementException e) {
            throw new DatabaseException("Recurso não encontrado");
        }
        catch (NullPointerException e) {
            throw new DatabaseException("Recurso não encontrado");
        }
    }

    @Transactional(readOnly = true)
    public PesquisaDTO findBygsv(Integer gsv){
        try {
            Pesquisa pesquisa = repository.findBygsv(gsv);
            return new PesquisaDTO(pesquisa);
        }
        catch (EntityNotFoundException e){
            throw new DatabaseException("Recurso não encontrado");
        }
        catch (NoSuchElementException e) {
            throw new DatabaseException("Recurso não encontrado");
        }
        catch (NullPointerException e) {
            throw new DatabaseException("Recurso não encontrado");
        }
        catch (IncorrectResultSizeDataAccessException e) {
            throw new DatabaseException("Campo vazio");
        }



    }



}

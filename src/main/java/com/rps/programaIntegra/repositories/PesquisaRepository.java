package com.rps.programaIntegra.repositories;


import com.rps.programaIntegra.entities.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisaRepository  extends JpaRepository<Pesquisa, Long> {

    Pesquisa findByjudicial(Integer judicial);
}


package com.rps.programaIntegra.dto;

import com.rps.programaIntegra.entities.Finalidade;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FinalidadeDTO {

    private Long id;
    private String descricao;

    public FinalidadeDTO(Finalidade entity){
        id = entity.getId();
        descricao = entity.getDescricao();
    }
}

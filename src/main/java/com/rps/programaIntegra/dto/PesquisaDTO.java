package com.rps.programaIntegra.dto;

import com.rps.programaIntegra.entities.Pesquisa;
import com.rps.programaIntegra.entities.TipoPessoa;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PesquisaDTO {


    private Long id;


    private Integer gsv ;

    private Integer contaJudicial ;




    public PesquisaDTO(Pesquisa entity){
        id = entity.getId();
        gsv = entity.getGsv();
        contaJudicial = entity.getContaJudicial();

    }

}

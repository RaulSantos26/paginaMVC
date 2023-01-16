package com.rps.programaIntegra.dto;

import com.rps.programaIntegra.entities.DadosResgate;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosResgateDTO {

    private Long id;
    private BigInteger cfp_cnpj;
    private String nome;
    private String representante;
    private String tipo;
    private Long finalidade;
    private Integer judicial;


    public DadosResgateDTO(DadosResgate entity) {
        id = entity.getId();
        nome = entity.getNome();
        tipo = entity.getTipo();
        cfp_cnpj = entity.getCfp_cnpj();
        finalidade = entity.getFinalidade();
        representante = entity.getRepresentante();
        judicial = entity.getPesquisa();



    }
}

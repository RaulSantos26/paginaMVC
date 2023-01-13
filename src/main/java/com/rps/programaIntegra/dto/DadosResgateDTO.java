package com.rps.programaIntegra.dto;

import com.rps.programaIntegra.entities.DadosResgate;
import com.rps.programaIntegra.entities.TipoPessoa;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosResgateDTO {

    private Long id;
    private BigInteger cfpCnpj;
    private String nome;
    private TipoPessoa tipoPessoa;

    public DadosResgateDTO(DadosResgate entity) {
        id = entity.getId();
        nome = entity.getNome();
        tipoPessoa = entity.getTipoPessoa();
        cfpCnpj = getCfpCnpj();
    }
}

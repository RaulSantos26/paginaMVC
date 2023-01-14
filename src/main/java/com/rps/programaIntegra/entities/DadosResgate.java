package com.rps.programaIntegra.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class DadosResgate {

    private Long id;
    private BigInteger cfpCnpj;
    private String nome;
    private String representante;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private Finalidade finalidade;


}

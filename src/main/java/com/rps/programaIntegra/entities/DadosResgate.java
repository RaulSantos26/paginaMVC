package com.rps.programaIntegra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_dado_resgate")
public class DadosResgate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cpfcnpj")
    private BigInteger cfp_cnpj;
    private String nome;
    private String representante;


    @Column(name = "tipo")
    private String tipo;

    private Long finalidade;

    @Column(name = "judicial")
    private Integer pesquisa;


}

package com.rps.programaIntegra.entities;




public enum TipoPessoa {
    PF ("PF"),
    PJ ("PJ");


private final String name;

    TipoPessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.impacta.microservices.investimento.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoContaInvestimentoResponse {

    private Double saldoContaInvestimento;

    @JsonCreator
    public SaldoContaInvestimentoResponse(@JsonProperty("saldo_conta_investimento") Double saldo){
        this.saldoContaInvestimento = saldo;
    }

    public Double getSaldoContaInvestimento() {
        return saldoContaInvestimento;
    }

    public void setSaldoContaInvestimento(Double saldoContaInvestimento) {
        this.saldoContaInvestimento = saldoContaInvestimento;
    }
}

package com.impacta.microservices.investimento.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoDebitoResponse {

    private Double valorDebito;

    @JsonCreator
    public SaldoDebitoResponse(@JsonProperty("saldo_debito") Double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public Double getValorDebito() {return valorDebito;}
}

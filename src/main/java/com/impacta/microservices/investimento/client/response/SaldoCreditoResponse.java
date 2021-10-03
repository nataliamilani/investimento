package com.impacta.microservices.investimento.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoCreditoResponse {

    private Double valorCredito;

    @JsonCreator
    public SaldoCreditoResponse(@JsonProperty("saldo_credito") Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Double getValorCredito() {return valorCredito;}

}

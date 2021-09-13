package com.impacta.microservices.investimento.client.response;

public class SaldoDebito {

    private Double valorDebito;

    public SaldoDebito(Double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public Double getValorDebito() {return valorDebito;}
}

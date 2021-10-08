package com.impacta.microservices.investimento.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperacaoInvestimentoRequest {

    private Integer contaIdContaCorrente;
    private double valor;


    @JsonCreator
    public OperacaoInvestimentoRequest(@JsonProperty("conta_id_conta_corrente") Integer contaIdContaCorrente,
                                       @JsonProperty("valor") double valor) {
        this.contaIdContaCorrente = contaIdContaCorrente;
        this.valor = valor;
    }

    public Integer getContaIdContaCorrente() {return contaIdContaCorrente;}

    public void setContaIdContaCorrente(Integer contaIdContaCorrente) {
        this.contaIdContaCorrente = contaIdContaCorrente;
    }

    public double getValor() {return valor;}

    public void setValor(double valor) {
        this.valor = valor;
    }
}

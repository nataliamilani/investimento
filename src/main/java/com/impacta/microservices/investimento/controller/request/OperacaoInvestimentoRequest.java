package com.impacta.microservices.investimento.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperacaoInvestimentoRequest {

    private Integer contaIdContaCorrente;
    private double valorAplicar;


    @JsonCreator
    public OperacaoInvestimentoRequest(@JsonProperty("conta_id_conta_corrente") Integer contaIdContaCorrente,
                                       @JsonProperty("valor_aplicar") double valorAplicar) {
        this.contaIdContaCorrente = contaIdContaCorrente;
        this.valorAplicar = valorAplicar;
    }

    public Integer getContaIdContaCorrente() {return contaIdContaCorrente;}

    public void setContaIdContaCorrente(Integer contaIdContaCorrente) {
        this.contaIdContaCorrente = contaIdContaCorrente;
    }

    public double getValorAplicar() {return valorAplicar;}

    public void setValorAplicar(double valorAplicar) {
        this.valorAplicar = valorAplicar;
    }
}

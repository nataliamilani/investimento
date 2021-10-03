package com.impacta.microservices.investimento.client.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCreditoRequest {

    private Integer contaId;
    private Double valorCredito;
    private Integer clienteId;
    private String tipoConta;


    @JsonCreator
    public CriarCreditoRequest(@JsonProperty("conta_id") Integer contaId,
                              @JsonProperty("valor_credito") double valorCredito,
                              @JsonProperty("cliente_id") Integer clienteId,
                              @JsonProperty("tipo_conta") String tipoConta) {
        this.contaId = contaId;
        this.valorCredito = valorCredito;
        this.clienteId = clienteId;
        this.tipoConta = tipoConta;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}

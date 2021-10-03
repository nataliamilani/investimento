package com.impacta.microservices.investimento.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "investimento")
public class Investimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investimento")
    private Integer id;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "conta_id")
    private Integer contaId;

    @Column(name = "cliente_id")
    private Integer clienteId;

    public Investimento() {
    }

    @JsonCreator
    public Investimento(@JsonProperty("conta_id") Integer contaId,
                        @JsonProperty("cliente_id") Integer clienteId,
                        @JsonProperty("saldo") double saldo) {
        this.contaId = contaId;
        this.clienteId = clienteId;
        this.saldo = saldo;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getContaId() {return contaId;}

    public void setContaId(Integer contaId) {this.contaId = contaId;}

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public Integer getClienteId() {return clienteId;}

    public void setClienteId(Integer clienteId) {this.clienteId = clienteId;}

}

package com.impacta.microservices.investimento.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "investimento")
public class Investimento implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investimento")
    private Integer id;

    //@Transient
    //private String porta;

    @Column(nullable = false)
    private Double saldo;

    @Column(nullable = false)
    private Integer contaId;

    @Column(nullable = false)
    private Integer clienteId;

    public Investimento() {
    }

    @JsonCreator
    public Investimento(@JsonProperty("conta_id") Integer contaId,
                        @JsonProperty("cliente_id") Integer clienteId,
                        @JsonProperty("saldo") Double saldo) {
        this.contaId = contaId;
        this.clienteId = clienteId;
        this.saldo = saldo;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getContaId() {return contaId;}

    public void setContaId(Integer contaId) {this.contaId = contaId;}

    public Double getSaldo() {return saldo;}

    public void setSaldo(Double saldo) {this.saldo = saldo;}

   // public String getPorta() {return porta;}

   // public void setPorta(String porta) {this.porta = porta;}

    public Integer getClienteId() {return clienteId;}

    public void setClienteId(Integer clienteId) {this.clienteId = clienteId;}

   // public static long getSerialversionuid() {return serialVersionUID;}
}

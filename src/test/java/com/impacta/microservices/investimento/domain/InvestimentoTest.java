package com.impacta.microservices.investimento.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvestimentoTest {

    @Test
    public void CriarInvestimento() {
        final Integer contaId = 1;
        final double saldo = 0.0;
        final Integer clienteId = 1;

        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        assertEquals(contaId, investimento.getContaId());
        assertEquals(saldo, investimento.getSaldo());
        assertEquals(clienteId, investimento.getClienteId());
    }
}

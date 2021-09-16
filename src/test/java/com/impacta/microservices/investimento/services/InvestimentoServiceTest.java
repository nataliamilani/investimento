package com.impacta.microservices.investimento.services;

import com.impacta.microservices.investimento.client.CreditoClient;
import com.impacta.microservices.investimento.client.DebitoClient;
import com.impacta.microservices.investimento.client.response.SaldoCredito;
import com.impacta.microservices.investimento.client.response.SaldoDebito;
import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.repository.InvestimentoRepository;
import com.impacta.microservices.investimento.service.InvestimentoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = NONE)
public class InvestimentoServiceTest {

    @InjectMocks
    private InvestimentoService investimentoService;

    @Mock
    private InvestimentoRepository investimentoRepository;

    @Mock
    private CreditoClient creditoClient;

    @Mock
    private DebitoClient debitoClient;

    @Before
    public void setUp() {
        investimentoRepository.deleteAll();
    }

    @Test
    public void salvarInvestimentoCriado(){
        final Integer contaId = 1;
        final Double saldo = null;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        lenient().when(investimentoService.criarInvestimento(investimento)).thenReturn(investimento);

        assertEquals(contaId, investimento.getContaId());
        assertEquals(clienteId, investimento.getClienteId());
        assertEquals(saldo, investimento.getSaldo());
    }

    @Test
    public void buscarContaInvestimento(){
        final Integer contaId = 1;
        final Double saldo = 20.0;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        lenient().when(investimentoService.buscarConta(contaId)).thenReturn(investimento);

        assertEquals(contaId, investimento.getContaId());
        assertEquals(clienteId, investimento.getClienteId());
        assertEquals(saldo, investimento.getSaldo());
    }

    @Test
    public void atualizarSaldoContaInvestimento(){
        final Integer contaId = 1;
        final Double saldo = 10.0;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);
        final SaldoDebito saldoDebito = new SaldoDebito(20.00);
        final SaldoCredito saldoCredito = new SaldoCredito(30.00);

        when(creditoClient.getSaldoCreditoConta(contaId)).thenReturn(saldoCredito);
        when(debitoClient.getSaldoDebitoConta(contaId)).thenReturn(saldoDebito);
        when(investimentoRepository.findByContaId(contaId)).thenReturn(investimento);
        when(investimentoRepository.save(investimento)).thenReturn(investimento);

        final Investimento result = investimentoService.atualizarSaldoConta(contaId);

        assertEquals(contaId, result.getContaId());
        assertThat(10.00).isEqualTo(result.getSaldo());
    }
}

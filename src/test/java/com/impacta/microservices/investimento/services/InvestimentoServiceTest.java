package com.impacta.microservices.investimento.services;

import com.impacta.microservices.investimento.client.CreditoClient;
import com.impacta.microservices.investimento.client.DebitoClient;
import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.exceptions.ContaIdExistenteBadRequestException;
import com.impacta.microservices.investimento.exceptions.ContaIdNotFoundException;
import com.impacta.microservices.investimento.repository.InvestimentoRepository;
import com.impacta.microservices.investimento.service.InvestimentoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void salvarInvestimentoCriado(){
        final Integer contaId = 1;
        final double saldo = 0.0;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        when(investimentoRepository.save(investimento)).thenReturn(investimento);

        final Investimento result = investimentoService.criarInvestimento(investimento);

        assertEquals(contaId, result.getContaId());
        assertEquals(clienteId, result.getClienteId());
    }

//    @Test(expected = ContaIdExistenteBadRequestException.class)
//    public void RetornarContaIdExistenteBadRequestExceptionQuandoContaIdJaExistir() {
//        final Investimento investimento = new Investimento(1,1,0.0);
//        when(investimentoService.criarInvestimento(investimento)).thenThrow(ContaIdExistenteBadRequestException.class);
//    }

//    @Test
//    public void buscarContaInvestimento(){
//        final Integer contaId = 1;
//        final double saldo = 20.0;
//        final Integer clienteId = 1;
//        final Investimento investimento = new Investimento(contaId, clienteId, saldo);
//
//        final Investimento result = investimentoService.buscarConta(investimento.getContaId());
//
//        verify(investimentoRepository, times(1)).findByContaId(contaId);
//        assertEquals(contaId, result.getContaId());
//        assertEquals(clienteId, result.getClienteId());
//    }

    @Test(expected = ContaIdNotFoundException.class)
    public void RetornarContaIdNotFoundExceptionQuandoBuscarContaIdInexistente(){
        when(investimentoService.buscarConta(888)).thenThrow(ContaIdNotFoundException.class);
    }

//    @Test
//    public void atualizarSaldoContaInvestimento(){
//        final Integer contaId = 1;
//        final double saldo = 0.0;
//        final Integer clienteId = 1;
//        final Investimento investimento = new Investimento(contaId, clienteId, saldo);
//
//        final Investimento result = investimentoService.atualizarSaldoConta(contaId);
//
//        verify(investimentoRepository, times(1)).findByContaId(contaId);
//        verify(debitoClient, times(1)).getSaldoDebitoConta(contaId);
//        verify(creditoClient, times(1)).getSaldoCreditoConta(contaId);
//        verify(investimentoRepository, times(1)).save(investimento);
//
//        assertEquals(contaId, result.getContaId());
//        assertThat(10.00).isEqualTo(result.getSaldo());
//    }


    @Test(expected = ContaIdNotFoundException.class)
    public void RetornarContaIdNotFoundExceptionQuandoTentarAtualizarContaIdInexistente(){
        when(investimentoService.atualizarSaldoConta(888)).thenThrow(ContaIdNotFoundException.class);
    }

//    @Test
//    public void aplicarValorInvestimento(){
//        final Integer contaId = 1;
//        final double saldo = 0.0;
//        final Integer clienteId = 1;
//        final Integer contaIdContaCorrente = 2;
//        final double valorAplicar = 20.0;
//        final Investimento investimento = new Investimento(contaId, clienteId, saldo);
//
//        when(investimentoRepository.findByContaId(contaId).get()).thenReturn(investimento);
//
//        final Investimento result = investimentoService.aplicarInvestimento(investimento.getContaId(), contaIdContaCorrente, valorAplicar);
//
//        assertEquals(contaId, result.getContaId());
//        assertEquals(clienteId, result.getClienteId());
//    }

//    @Test
//    public void resgatarValorInvestimento(){
//        final Integer contaId = 1;
//        final double saldo = 0.0;
//        final Integer clienteId = 1;
//        final Integer contaIdContaCorrente = 2;
//        final double valorAplicar = 20.0;
//        final Investimento investimento = new Investimento(contaId, clienteId, saldo);
//
//        when(investimentoRepository.findByContaId(contaId).get()).thenReturn(investimento);
//
//        final Investimento result = investimentoService.resgatarInvestimento(investimento.getContaId(), contaIdContaCorrente, valorAplicar);
//
//        assertEquals(contaId, result.getContaId());
//        assertEquals(clienteId, result.getClienteId());
//    }
}

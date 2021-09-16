package com.impacta.microservices.investimento.controllers;

import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.service.InvestimentoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
public class InvestimentoControllerTest {

    @Autowired
    private TestRestTemplate template;

    @MockBean
    private InvestimentoService investimentoService;

    @Test
    public void aoCriarInvestimentoRetornarInvestimentoCriado(){
        final Integer contaId = 1;
        final Double saldo = null;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        when(investimentoService.criarInvestimento(investimento)).thenReturn(investimento);

        final ResponseEntity<Investimento> response = template
                .postForEntity("/conta/investimento", investimento, Investimento.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void aoBuscarPorContaIdExibirContaInvestimento(){
        final Integer contaId = 1;
        final Double saldo = 20.0;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        when(investimentoService.buscarConta(contaId)).thenReturn(investimento);

        final ResponseEntity<Investimento> response = template
                .getForEntity("/conta/investimento/" + contaId, Investimento.class );
        final Investimento result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(contaId, result.getContaId());
        assertEquals(saldo, result.getSaldo());
        assertEquals(clienteId, result.getClienteId());
    }

    @Test
    public void atualizarSaldoPorContaId(){
        final Integer contaId = 1;
        final Double saldo = 20.0;
        final Integer clienteId = 1;
        final Investimento investimento = new Investimento(contaId, clienteId, saldo);

        final HttpEntity<Investimento> entity = new HttpEntity<>(investimento);
        when(investimentoService.atualizarSaldoConta(contaId)).thenReturn(investimento);

        final ResponseEntity<Investimento> response = template
                .exchange("/conta/investimento/atualizarSaldo/" + contaId, HttpMethod.PUT, entity, Investimento.class);
        final Investimento result = response.getBody();

        assertEquals(contaId, result.getContaId());
        assertEquals(saldo, result.getSaldo());
        assertEquals(clienteId, result.getClienteId());
    }
}

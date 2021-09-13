package com.impacta.microservices.investimento.service;

import com.impacta.microservices.investimento.client.CreditoClient;
import com.impacta.microservices.investimento.client.DebitoClient;
import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.repository.InvestimentoRepository;
import org.springframework.stereotype.Component;

@Component
public class InvestimentoService {

    private InvestimentoRepository repository;
    private CreditoClient creditoClient;
    private DebitoClient debitoClient;

    public InvestimentoService(InvestimentoRepository repository,
                               CreditoClient creditoClient,
                               DebitoClient debitoClient) {
        this.repository = repository;
        this.creditoClient = creditoClient;
        this.debitoClient = debitoClient;
    }

    public Investimento criarInvestimento(Investimento investimento) {
        return repository.save(investimento);
    }

    public Investimento buscarConta(Integer contaId) {
        return repository.findByContaId(contaId);
    }

    public Investimento atualizarSaldoConta(Integer contaId) {
        var debito = debitoClient.getSaldoDebitoConta(contaId);
        var credito = creditoClient.getSaldoCreditoConta(contaId);

        double saldoTotalConta = credito.getValorCredito() - debito.getValorDebito();

        var investimento = repository.findByContaId(contaId);

        investimento.setSaldo(saldoTotalConta);

        return repository.save(investimento);
    }
}

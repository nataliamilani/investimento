package com.impacta.microservices.investimento.service;

import com.impacta.microservices.investimento.client.CreditoClient;
import com.impacta.microservices.investimento.client.DebitoClient;
import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.exceptions.ContaIdNotFoundException;
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
        atualizarSaldoConta(contaId);

        if (repository.findByContaId(contaId).isPresent()) {
            return repository.findByContaId(contaId).get();
        }
        return null;
    }

    public Investimento atualizarSaldoConta(Integer contaId) {
        var investimento = repository.findByContaId(contaId)
                .orElseThrow(() -> new ContaIdNotFoundException("Não encontrada conta id: " + contaId));

        var debito = debitoClient.getSaldoDebitoConta(contaId);
        var credito = creditoClient.getSaldoCreditoConta(contaId);

        double saldoTotalConta = credito.getValorCredito() - debito.getValorDebito();

        investimento.setSaldo(saldoTotalConta);

        return repository.save(investimento);
    }
}

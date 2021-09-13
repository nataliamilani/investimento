package com.impacta.microservices.investimento.client;

import com.impacta.microservices.investimento.client.response.SaldoCredito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "credito")
public interface CreditoClient {

    @GetMapping(value = "/debito/saldo/investimento/{contaId}")
    SaldoCredito getSaldoCreditoConta(@PathVariable Integer contaId);
}

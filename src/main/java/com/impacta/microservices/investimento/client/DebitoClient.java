package com.impacta.microservices.investimento.client;

import com.impacta.microservices.investimento.client.response.SaldoDebito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "debito")
public interface DebitoClient {

    @GetMapping(value = "/debito/saldo/investimento/{contaId}")
    SaldoDebito getSaldoDebitoConta(@PathVariable Integer contaId);
}

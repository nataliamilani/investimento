package com.impacta.microservices.investimento.client;

import com.impacta.microservices.investimento.client.response.SaldoCredito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "credito", url = "${clients.credito}")
public interface CreditoClient {

    @RequestMapping(value = "/saldo/contacorrente/{contaId}", method = RequestMethod.GET)
    SaldoCredito getSaldoCreditoConta(@PathVariable("contaId") Integer contaId);
}

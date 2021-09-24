package com.impacta.microservices.investimento.client;


import com.impacta.microservices.investimento.client.response.SaldoDebito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "debito", url = "${clients.debito}")
public interface DebitoClient {

    @RequestMapping(value = "/saldo/contacorrente/{contaId}", method = RequestMethod.GET)
    SaldoDebito getSaldoDebitoConta(@PathVariable("contaId") Integer contaId);
}
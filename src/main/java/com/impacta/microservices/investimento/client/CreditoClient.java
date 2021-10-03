package com.impacta.microservices.investimento.client;

import com.impacta.microservices.investimento.client.request.CriarCreditoRequest;
import com.impacta.microservices.investimento.client.response.SaldoCreditoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "credito", url = "${clients.credito}")
public interface CreditoClient {

    @RequestMapping(value = "/saldo/investimento/{contaId}", method = RequestMethod.GET)
    SaldoCreditoResponse getSaldoCreditoConta(@PathVariable("contaId") Integer contaId);

    @PostMapping()
    CriarCreditoRequest criarCredito(@RequestBody CriarCreditoRequest creditoRequest);
}

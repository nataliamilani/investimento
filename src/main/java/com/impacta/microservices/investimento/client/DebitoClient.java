package com.impacta.microservices.investimento.client;


import com.impacta.microservices.investimento.client.request.CriarDebitoRequest;
import com.impacta.microservices.investimento.client.response.SaldoDebitoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "debito", url = "${clients.debito}")
public interface DebitoClient {

    @RequestMapping(value = "/saldo/investimento/{contaId}", method = RequestMethod.GET)
    SaldoDebitoResponse getSaldoDebitoConta(@PathVariable("contaId") Integer contaId);

    @PostMapping()
    CriarDebitoRequest criarDebito(@RequestBody CriarDebitoRequest debitoRequest);
}

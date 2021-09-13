package com.impacta.microservices.investimento.controller;

import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.service.InvestimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@Tag(name= "Investimento endpoints")
@RestController
@RequestMapping("/conta/investimento")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Investimento criarContaInvestimento(@RequestBody Investimento investimentoRequest){
        return investimentoService.criarInvestimento(investimentoRequest);
    }

    @GetMapping("/{contaId}")
    public Investimento buscarContaId(@PathVariable Integer contaId) throws UnknownHostException {
       Investimento investimento = investimentoService.buscarConta(contaId);
        return investimento;
    }

    @PutMapping("/{contaId}")
    public Investimento alterarSaldoConta(@PathVariable Integer contaId) throws UnknownHostException {
        Investimento saldoAtualizado = investimentoService.atualizarSaldoConta(contaId);
        return saldoAtualizado;
    }
}

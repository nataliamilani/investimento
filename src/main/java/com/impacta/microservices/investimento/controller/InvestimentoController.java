package com.impacta.microservices.investimento.controller;

import com.impacta.microservices.investimento.domain.Investimento;
import com.impacta.microservices.investimento.service.InvestimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name= "Investimento endpoints")
@RestController
@RequestMapping("/conta/investimento")
public class InvestimentoController {

    @Autowired
    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @GetMapping("/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação online";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Investimento criarContaInvestimento(@RequestBody Investimento investimentoRequest){
        return investimentoService.criarInvestimento(investimentoRequest);
    }

    @GetMapping("/consulta/{contaId}")
    public Investimento consultarContaId(@PathVariable Integer contaId) {
        return investimentoService.buscarConta(contaId);
    }
}

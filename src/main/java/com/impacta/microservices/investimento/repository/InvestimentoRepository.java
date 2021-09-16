package com.impacta.microservices.investimento.repository;

import com.impacta.microservices.investimento.domain.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento,Integer> {

    Investimento findByContaId(Integer contaId);
}

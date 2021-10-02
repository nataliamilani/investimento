package com.impacta.microservices.investimento.repository;

import com.impacta.microservices.investimento.domain.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {

    Optional<Investimento> findByContaId(Integer contaId);
}

package br.com.bycoders.conversor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoders.conversor.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    
}

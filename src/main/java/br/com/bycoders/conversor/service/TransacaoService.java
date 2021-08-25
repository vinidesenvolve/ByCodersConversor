package br.com.bycoders.conversor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.conversor.dto.TransacaoDTO;
import br.com.bycoders.conversor.repository.TransacaoRepository;

@Service
public class TransacaoService {
    
    @Autowired
    TransacaoRepository transacaoRepo;

    public void parseTransacao(String arquivo) {
        //Parsing...
    }

    public void save(TransacaoDTO transacaoDTO) {
        //Saving...
    }

    public void getAll() {
        //Consulting...
    }
}

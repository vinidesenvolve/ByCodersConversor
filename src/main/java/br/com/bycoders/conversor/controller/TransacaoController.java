package br.com.bycoders.conversor.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bycoders.conversor.service.TransacaoService;

@Controller
@RequestMapping(path="/transacao")
public class TransacaoController {
    
    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody String arquivoPath) throws FileNotFoundException {
        return transacaoService.parseTransacao(arquivoPath);
    }

    @GetMapping("/all")
    public void getAll() {
        transacaoService.getAll();
    }
}

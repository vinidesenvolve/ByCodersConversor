package br.com.bycoders.conversor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.bycoders.conversor.dto.TransacaoDTO;
import br.com.bycoders.conversor.service.TransacaoService;

@RestController
@RequestMapping
public class TransacaoController {
    
    @Autowired
    TransacaoService transacaoService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam MultipartFile arquivo) {
        return transacaoService.loadArquivo(arquivo);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransacaoDTO>> getAll() {
        return transacaoService.getAll();
    }
}
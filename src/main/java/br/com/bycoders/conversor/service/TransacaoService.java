package br.com.bycoders.conversor.service;

import br.com.bycoders.conversor.model.Transacao;
import br.com.bycoders.conversor.repository.TransacaoRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

  @Autowired
  TransacaoRepository transacaoRepo;

  public ResponseEntity<String> parseTransacao(String arquivoPath)
    throws FileNotFoundException {

    List<String> transacoes = new ArrayList<>();
    File file = new File(arquivoPath);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      transacoes.add(scanner.nextLine());
    }

    scanner.close();

    return save(transacoes);
  }

  private ResponseEntity<String> save(List<String> transacoes) {
    transacoes
      .stream()
      .forEach(
        t -> {
          Transacao transacao = new Transacao();

          transacao.setTipo(t.substring(0, 1));
          transacao.setData(t.substring(1, 9));
          transacao.setValor(new BigDecimal(t.substring(9, 19)));
          transacao.setCpf(t.substring(19, 30));
          transacao.setCartao(t.substring(30, 42));
          transacao.setHora(t.substring(42, 48));
          transacao.setDono(t.substring(48, 62));
          transacao.setLoja(t.substring(62));

          transacaoRepo.save(transacao);
        }
      );

    return new ResponseEntity<>("Transações salvas!", HttpStatus.OK);
  }

  public ResponseEntity<List<Transacao>> getAll() {
    return new ResponseEntity<>(transacaoRepo.findAll(), HttpStatus.OK);
  }
  
}

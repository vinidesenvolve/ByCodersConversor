package br.com.bycoders.conversor.service;

import br.com.bycoders.conversor.dto.TransacaoDTO;
import br.com.bycoders.conversor.repository.TransacaoRepository;
import java.io.File;
import java.io.FileNotFoundException;
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
    //Parsing...
    List<String> lines = new ArrayList<>();

    File file = new File(arquivoPath);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      lines.add(scanner.nextLine());
    }

    scanner.close();

    lines
      .stream()
      .forEach(
        line -> {
          System.out.println("Tipo: " + line.substring(0, 1));
          System.out.println("Data: " + line.substring(1, 9));
          System.out.println("Valor: " + line.substring(9, 19));
          System.out.println("CPF: " + line.substring(19, 30));
          System.out.println("Cartão: " + line.substring(30, 42));
          System.out.println("Hora: " + line.substring(42, 48));
          System.out.println("Dono: " + line.substring(48, 62));
          System.out.println("Loja: " + line.substring(62));
          System.out.println("----------------------------------------");
        }
      );

    return new ResponseEntity<>("Arquivo recebido!", HttpStatus.CREATED);
  }

  public void save(TransacaoDTO transacaoDTO) {
    //Saving...
  }

  public void getAll() {
    //Consulting...
  }
}

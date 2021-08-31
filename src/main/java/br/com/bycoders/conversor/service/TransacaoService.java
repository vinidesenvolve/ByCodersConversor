package br.com.bycoders.conversor.service;

import br.com.bycoders.conversor.dto.TransacaoDTO;
import br.com.bycoders.conversor.model.Transacao;
import br.com.bycoders.conversor.repository.TransacaoRepository;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TransacaoService {

  @Autowired
  private TransacaoRepository transacaoRepo;

  public ResponseEntity<String> loadArquivo(MultipartFile arquivo) {
    List<String> transacoes = new ArrayList<>();

    if(arquivo.isEmpty()) {
      return new ResponseEntity<>("Houve um problema: o arquivo está vazio.", HttpStatus.BAD_REQUEST);
    }

    try {
      InputStream inputStream = arquivo.getInputStream();
      BufferedReader bReader = new BufferedReader(
        new InputStreamReader(inputStream)
      );

      transacoes = bReader.lines().collect(Collectors.toList());
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    return save(transacoes);
  }

  private ResponseEntity<String> save(List<String> transacoes) {
    transacoes
      .stream()
      .forEach(
        t -> {
          Transacao transacao = new Transacao();

          transacao.setTipo(t.substring(0, 1));
          transacao.setData(parseData(t.substring(1, 9)));
          transacao.setValor(new BigDecimal(t.substring(9, 19)));
          transacao.setCpf(t.substring(19, 30));
          transacao.setCartao(t.substring(30, 42));
          transacao.setHora(parseHorario(t.substring(42, 48)));
          transacao.setDono(t.substring(48, 62));
          transacao.setLoja(t.substring(62));

          transacaoRepo.save(transacao);
        }
      );

    return new ResponseEntity<>("Transações recebidas!", HttpStatus.OK);
  }

  public ResponseEntity<List<TransacaoDTO>> getAll() {
    List<Transacao> transacoes = transacaoRepo.findAll();

    if (transacoes.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    List<TransacaoDTO> transacoesDTO = transacoes
      .stream()
      .map(t -> new TransacaoDTO(t))
      .collect(Collectors.toList());

    return new ResponseEntity<>(transacoesDTO, HttpStatus.OK);
  }

  private LocalDate parseData(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
    return LocalDate.parse(data, formatter);
  }

  private LocalTime parseHorario(String horario) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
    return LocalTime.parse(horario, formatter);
  }
}

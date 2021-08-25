package br.com.bycoders.conversor.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Transacao {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private String hora;
    private String dono;
    private String loja;
}

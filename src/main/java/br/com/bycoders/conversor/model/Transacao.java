package br.com.bycoders.conversor.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Transacao {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Tipo não pode ser vazio.")
    private String tipo;

    @NotNull(message="Data não pode ser vazio.")
    private LocalDate data;

    @NotNull(message="Valor não pode ser vazio.")
    private BigDecimal valor;

    @NotEmpty(message="CPF não pode ser vazio.")
    private String cpf;

    @NotEmpty(message="Cartão não pode ser vazio.")
    private String cartao;

    @NotNull(message="Hora não pode ser vazio.")
    private LocalTime hora;

    @NotEmpty(message="Dono não pode ser vazio.")
    private String dono;

    @NotEmpty(message="Loja não pode ser vazio.")
    private String loja;
}

package br.com.bycoders.conversor.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.bycoders.conversor.model.Transacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransacaoDTO {
    
    private Long id;

    @NotEmpty(message="Tipo não pode ser vazio.")
    private String tipo;

    @NotEmpty(message="Data não pode ser vazio.")
    private LocalDate data;

    @NotNull(message="Valor não pode ser vazio.")
    private BigDecimal valor;

    @NotEmpty(message="CPF não pode ser vazio.")
    private String cpf;

    @NotEmpty(message="Cartão não pode ser vazio.")
    private String cartao;

    @NotEmpty(message="Hora não pode ser vazio.")
    private LocalTime hora;

    @NotEmpty(message="Dono não pode ser vazio.")
    private String dono;

    @NotEmpty(message="Loja não pode ser vazio.")
    private String loja;

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.tipo = transacao.getTipo();
        this.data = transacao.getData();
        this.valor = transacao.getValor();
        this.cpf = transacao.getCpf();
        this.cartao = transacao.getCartao();
        this.hora = transacao.getHora();
        this.dono = transacao.getDono();
        this.loja = transacao.getLoja();
    }
    
   
}

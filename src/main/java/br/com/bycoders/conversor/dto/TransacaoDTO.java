package br.com.bycoders.conversor.dto;

import java.math.BigDecimal;

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

    @NotEmpty
    private String tipo;

    @NotEmpty
    private String data;

    @NotNull
    private BigDecimal valor;

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String cartao;

    @NotEmpty
    private String hora;

    @NotEmpty
    private String dono;

    @NotEmpty
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

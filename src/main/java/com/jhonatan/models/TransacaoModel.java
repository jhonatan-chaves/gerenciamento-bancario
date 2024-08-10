package com.jhonatan.models;

import com.jhonatan.domain.TransactionalType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transacao")
public class TransacaoModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;

    private TransactionalType tipo;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "conta_bancaria_id")
    private ContaBancariaModel contaBancaria;



    public TransacaoModel(){}

    public TransacaoModel(Long idTransacao, TransactionalType tipo, BigDecimal valor, String descricao,
                          ContaBancariaModel contaBancariaModel) {
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.descricao = descricao;
        this.contaBancaria = contaBancariaModel;
    }


    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public TransactionalType getTipo() {
        return tipo;
    }

    public void setTipo(TransactionalType tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContaBancariaModel getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancariaModel contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoModel that = (TransacaoModel) o;
        return Objects.equals(idTransacao, that.idTransacao) && tipo == that.tipo && Objects.equals(valor, that.valor) && Objects.equals(dataHora, that.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransacao, tipo, valor, dataHora);
    }

    @Override
    public String toString() {
        return "TransacaoModel{" +
                "idTransacao=" + idTransacao +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

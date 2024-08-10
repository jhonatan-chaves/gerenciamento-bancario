package com.jhonatan.models;

import com.jhonatan.domain.StatusConta;
import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "conta_bancaria")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ContaBancariaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private String numeroConta;
    @Enumerated(EnumType.STRING)
    private StatusConta statusConta;
    private String titular;
    private LocalDateTime dataHoraAbertura;
    private BigDecimal saldo;
    @ManyToOne
    private ClienteModel cliente;
    @OneToMany(mappedBy = "contaBancaria", cascade = CascadeType.ALL)
    private Set<TransacaoModel> transacoes;



    public ContaBancariaModel(){}

    public ContaBancariaModel(Long idConta, String numeroConta, StatusConta statusConta, String titular,
                              BigDecimal saldo, ClienteModel cliente,LocalDateTime dataHoraAbertura, Set<TransacaoModel> transacoes) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.statusConta = statusConta;
        this.titular = titular;
        this.dataHoraAbertura = dataHoraAbertura;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = transacoes;
    }
/*
    public abstract void depositar(BigDecimal valor);
    public abstract void sacar(BigDecimal valor) throws SaldoInsuficioneteException;
    public abstract void transferir(BigDecimal valor, ContaBancariaModel contaBancariaModel)
            throws SaldoInsuficioneteException;

 */
public void atualizarSaldo(BigDecimal valor) {
    this.saldo = this.saldo.add(valor); //this.saldo += valor;
}
public abstract void adicionarTransacao(TransacaoModel transacao);

    public abstract BigDecimal consultarSaldo();

    public abstract void consultarExtrato();

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Set<TransacaoModel> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<TransacaoModel> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public String toString() {
        return "ContaBancariaModel{" +
                "idConta=" + idConta +
                ", numeroConta='" + numeroConta + '\'' +
                ", statusConta=" + statusConta +
                ", titular='" + titular + '\'' +
                ", dataHoraAbertura=" + dataHoraAbertura +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", transacoes=" + transacoes +
                '}';
    }

    /*
    public void depositar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Valor invalido para deposito.");
        }
       this.saldo = saldo.add(valor);
    }
    public void sacar(BigDecimal valor){
       if(valor.compareTo(BigDecimal.ZERO) <=0){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Valor invalido para saques.");
       }
       this.saldo = saldo.subtract(valor);
    }
    public void transferir(BigDecimal valor, ContaBancariaModel contaDestino){
        if(valor.compareTo(BigDecimal.ZERO) <= 0 && contaDestino == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Verifique o valor e conta e tente novamente.");
        }

        if(saldo.compareTo(BigDecimal.ZERO) < 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Valor insuficiente para a transferencia.");
        }
        saldo = saldo.subtract(valor);
        contaDestino.depositar(valor);



    }

 */
}

package com.jhonatan.models;

import com.jhonatan.domain.TransactionalType;
import com.jhonatan.domain.StatusConta;
import com.jhonatan.exceptions.SaldoInsuficioneteException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrenteModel extends ContaBancariaModel {

    private BigDecimal valorChequeEspecial;

    public ContaCorrenteModel(){}
    public ContaCorrenteModel(Long idConta, String numeroConta, StatusConta statusConta, String titular,
                              BigDecimal saldo, ClienteModel cliente, LocalDateTime dataHoraAbertura,
                              BigDecimal valorChequeEspecial, Set<TransacaoModel> transacoes) {
        super(idConta, numeroConta, statusConta, titular,saldo, cliente,dataHoraAbertura, transacoes);
        this.valorChequeEspecial = valorChequeEspecial;
    }

    @Override
    public void adicionarTransacao(TransacaoModel transacao) {
        if (transacao != null) {
            super.getTransacoes().add(transacao);
            transacao.setContaBancaria(this);
        } else {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }
    }
    @Override
    public BigDecimal consultarSaldo() {
        // Implementação específica para Conta Corrente
        return getSaldo();
    }

    @Override
    public void consultarExtrato() {
        // Implementação específica para Conta Corrente
    }

   /* @Transactional
    @Override
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido para depósito.");
        }
        BigDecimal novoSaldo = getSaldo().add(valor);
        setSaldo(novoSaldo);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(), TransactionalType.DEPOSITO, valor, "Depósito realizado");
        adicionarTransacao(transacao);

        // Exemplo de envio de notificação
        enviarNotificacao("Depósito de " + valor + " realizado com sucesso.");
    }

    @Transactional
    @Override
    public void sacar(BigDecimal valor) throws SaldoInsuficioneteException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido para saque.");
        }
        if (valor.compareTo(getSaldo().add(valorChequeEspecial)) > 0) {
            throw new SaldoInsuficioneteException("Saldo insuficiente para realizar o saque.");
        }
        BigDecimal novoSaldo = getSaldo().subtract(valor);
        setSaldo(novoSaldo);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(), TransactionalType.SAQUE, valor, "Saque realizado");
        adicionarTransacao(transacao);

        // Exemplo de envio de notificação
        enviarNotificacao("Saque de " + valor + " realizado com sucesso.");
    }

    @Transactional
    @Override
    public void transferir(BigDecimal valor, ContaBancariaModel contaDestino) throws SaldoInsuficioneteException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 || contaDestino == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verifique o valor e a conta de destino e tente novamente.");
        }
        if (valor.compareTo(getSaldo().add(valorChequeEspecial)) > 0) {
            throw new SaldoInsuficioneteException("Saldo insuficiente para transferência.");
        }
        BigDecimal novoSaldo = getSaldo().subtract(valor);
        setSaldo(novoSaldo);
        contaDestino.depositar(valor);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(), TransactionalType.TRANSFERENCIA, valor, "Transferência realizada com sucesso.");
        adicionarTransacao(transacao);

        // Exemplo de envio de notificação
        enviarNotificacao("Transferência de " + valor + " para a conta " + contaDestino.getNumeroConta() + " realizada com sucesso.");
    }

    */

    public BigDecimal getValorChequeEspecial() {
        return valorChequeEspecial;
    }

    public void setValorChequeEspecial(BigDecimal valorChequeEspecial) {
        this.valorChequeEspecial = valorChequeEspecial;
    }

    private void enviarNotificacao(String mensagem) {
        // Simulação de envio de notificação
        System.out.println("Notificação: " + mensagem);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                " numero_da_conta: " + getNumeroConta() +
                " titular: " + getTitular() +
                " saldo: " + getSaldo() +
                " status_conta: " + getStatusConta() +
                " valorChequeEspecial: " + valorChequeEspecial +
                '}';
    }
}

package com.jhonatan.models;

import com.jhonatan.domain.StatusConta;
import com.jhonatan.domain.TransactionalType;
import com.jhonatan.exceptions.SaldoInsuficioneteException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "conta_poupanca")
public class ContaPoupancaModel extends ContaBancariaModel{

    private BigDecimal taxaRendimento;

    public ContaPoupancaModel(){}

    public ContaPoupancaModel(Long idConta, String numeroConta, StatusConta statusConta, String titular,
                              BigDecimal saldo, ClienteModel cliente, LocalDateTime dataHoraAbertura,
                              BigDecimal taxaRendimento, Set<TransacaoModel> transacoes) {
        super(idConta, numeroConta, statusConta, titular,saldo, cliente,dataHoraAbertura, transacoes);
        this.taxaRendimento = taxaRendimento;
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
        // Implementação específica para Conta Poupança
        return getSaldo();
    }

    @Override
    public void consultarExtrato() {
        // Implementação específica para Conta Poupança
    }


  /*  @Override
    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Valor invalido para deposito.");
        }
        BigDecimal novoSaldo = getSaldo().add(valor);
        setSaldo(novoSaldo);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(), TransactionalType.DEPOSITO,
                valor, "Deposito realizado com sucesso na conta de: " + getTitular());
        adicionarTransacao(transacao);
        System.out.println(transacao);
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    @Override
    public void sacar(BigDecimal valor) throws SaldoInsuficioneteException {
        if(valor.compareTo(BigDecimal.ZERO) <=0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Valor invalido para saques.");
        }
        if (valor.compareTo(getSaldo()) > 0){
            throw new SaldoInsuficioneteException("Saldo insuficiente para realizar o saque.");
        }

        BigDecimal novoSaldo = getSaldo().subtract(valor);
        setSaldo(novoSaldo);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(),
                TransactionalType.SAQUE,valor,"Saque Realizado com sucesso na conta de: " + getTitular());
        adicionarTransacao(transacao);
        System.out.println(transacao);
        System.out.println("---------------------------------------------------------------------------------------------");

    }

    @Override
    public void transferir(BigDecimal valor, ContaBancariaModel contaDestino)
            throws SaldoInsuficioneteException {
        if(valor.compareTo(BigDecimal.ZERO) <= 0 && contaDestino == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Verifique o valor e conta e tente novamente.");
        }

        if(getSaldo().compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficioneteException("Saldo insuficiente para transferencia.");
        }
        BigDecimal novoSaldo = getSaldo().subtract(valor);
        setSaldo(novoSaldo);
        contaDestino.depositar(valor);
        TransacaoModel transacao = new TransacaoModel(new Random().nextLong(),TransactionalType.TRANSFERENCIA,
                valor,"Transferencia realizada com sucesso, da conta: " + getTitular() + " , para: " + contaDestino.getTitular());
        adicionarTransacao(transacao);
        System.out.println(transacao);
        System.out.println("----------------------------------------------------------------------------------------------");

    }

   */

    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                " numero_da_conta: "  + getNumeroConta() +
                " titular: " + getTitular() +
                " saldo: " + getSaldo() +
                " status_conta: " + getStatusConta() +
                " taxaRendimento: =" + taxaRendimento +
                '}';
    }
}

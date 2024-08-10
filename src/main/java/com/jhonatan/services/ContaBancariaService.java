package com.jhonatan.services;

import com.jhonatan.domain.StatusConta;
import com.jhonatan.domain.TransactionalType;
import com.jhonatan.models.ContaBancariaModel;
import com.jhonatan.models.TransacaoModel;
import com.jhonatan.repository.ContaBancariaRepository;
import com.jhonatan.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository contaBancariaRepository;
    private final TransacaoRepository transacaoRepository;

    public ContaBancariaService(ContaBancariaRepository contaBancariaRepository,
                                TransacaoRepository transacaoRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
        this.transacaoRepository = transacaoRepository;
    }


    @Transactional
    public void transferir(Long idContaOrigem, Long idContaDestino, BigDecimal valor) {
        ContaBancariaModel contaOrigem = contaBancariaRepository.findById(idContaOrigem).orElseThrow(() ->
                new RuntimeException("Conta não encontrada - origem."));
        ContaBancariaModel contaDestino = contaBancariaRepository.findById(idContaDestino).orElseThrow(() ->
                new RuntimeException("Conta não encontrada - destino."));

        if (contaOrigem.getStatusConta().equals(StatusConta.EM_ANALISE)) {
            throw new RuntimeException("Não foi possivel completar essa transação - conta em analise.");
        }

        if(contaOrigem.getStatusConta().equals(StatusConta.BLOQUEADA)
                || contaOrigem.getStatusConta().equals(StatusConta.DESATIVADA)){
            throw new RuntimeException("conta BLOQUEADA/DESATIVADA.");
        }

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        contaOrigem.atualizarSaldo(valor.negate());
        contaDestino.atualizarSaldo(valor);



        contaBancariaRepository.save(contaOrigem);
        contaBancariaRepository.save(contaDestino);

        TransacaoModel transacaoOrigem = new TransacaoModel();
        transacaoOrigem.setTipo(TransactionalType.TRANSFERENCIA);
        transacaoOrigem.setValor(valor.negate());
        transacaoOrigem.setDataHora(LocalDateTime.now());
        transacaoOrigem.setContaBancaria(contaOrigem);

        TransacaoModel transacaoDestino = new TransacaoModel();


        transacaoDestino.setTipo(TransactionalType.TRANSFERENCIA);
        transacaoDestino.setValor(valor);
        transacaoDestino.setDataHora(LocalDateTime.now());
        transacaoDestino.setContaBancaria(contaDestino);

        transacaoRepository.save(transacaoOrigem);
        transacaoRepository.save(transacaoDestino);
    }

    @Transactional
    public void depositar(Long idConta, BigDecimal valor){
        ContaBancariaModel conta = contaBancariaRepository.findById(idConta).orElseThrow(() ->
                new RuntimeException("conta não encontrada."));

        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("valor invalido para a transação - " + valor);
        }

        conta.atualizarSaldo(valor);
        conta.setStatusConta(StatusConta.ATIVA);
        contaBancariaRepository.save(conta);

        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setTipo(TransactionalType.DEPOSITO);
        transacaoModel.setValor(valor);
        transacaoModel.setDataHora(LocalDateTime.now());
        transacaoModel.setContaBancaria(conta);

        transacaoRepository.save(transacaoModel);

    }
}


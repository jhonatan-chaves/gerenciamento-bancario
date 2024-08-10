package com.jhonatan.services;

import com.jhonatan.domain.StatusConta;
import com.jhonatan.domain.TransactionalType;
import com.jhonatan.models.ClienteModel;
import com.jhonatan.models.ContaCorrenteModel;
import com.jhonatan.models.TransacaoModel;
import com.jhonatan.records.ContaCorrenteRecordDTO;
import com.jhonatan.repository.ClienteRepository;
import com.jhonatan.repository.ContaCorrenteRepository;
import com.jhonatan.repository.TransacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public ContaCorrenteService(ContaCorrenteRepository contaCorrenteRepository, ClienteRepository clienteRepository,
                                TransacaoRepository transacaoRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public ContaCorrenteModel criarConta(Long idCliente, ContaCorrenteRecordDTO contaCorrenteRecordDTO){
        ClienteModel clienteOp = clienteRepository.findById(idCliente).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente não encontrado."));

        if(contaCorrenteRepository.findByNumeroConta(contaCorrenteRecordDTO.numeroConta()).isPresent()){
            throw new RuntimeException("Conta já existente.");

        }

        ContaCorrenteModel contaCorrente = new ContaCorrenteModel();

        BeanUtils.copyProperties(contaCorrenteRecordDTO, contaCorrente);



        contaCorrente.setCliente(clienteOp);
        contaCorrente.setTitular(clienteOp.getNome());
        contaCorrente.setStatusConta(StatusConta.EM_ANALISE);
        contaCorrente.setSaldo(BigDecimal.ZERO);
        contaCorrente.setDataHoraAbertura(LocalDateTime.now());

        return contaCorrenteRepository.save(contaCorrente);
    }

    @Transactional
    public void depositar(Long contaId, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido para depósito.");
        }

        ContaCorrenteModel contaCorrente = contaCorrenteRepository.findById(contaId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada."));

        BigDecimal novoSaldo = contaCorrente.getSaldo().add(valor);
        contaCorrente.setSaldo(novoSaldo);

        // Verifica se o saldo é suficiente para ativar a conta
        if (contaCorrente.getStatusConta() == StatusConta.EM_ANALISE &&
                novoSaldo.compareTo(new BigDecimal("50")) >= 0) {
            contaCorrente.setStatusConta(StatusConta.ATIVA);
        }

        TransacaoModel transacao = new TransacaoModel();
       // transacao.setContaCorrenteModel(contaCorrente);
        transacao.setValor(valor);
        transacao.setTipo(TransactionalType.DEPOSITO);
        transacao.setDataHora(LocalDateTime.now());
        contaCorrente.adicionarTransacao(transacao);

        transacaoRepository.save(transacao);
        contaCorrenteRepository.save(contaCorrente);

        enviarNotificacao("Depósito de " + valor + " realizado com sucesso.");
    }



    private void enviarNotificacao(String mensagem) {
        // Simulação de envio de notificação
        System.out.println("Notificação: " + mensagem);
    }
}

package com.jhonatan.services;

import com.jhonatan.models.ClienteModel;
import com.jhonatan.records.ClienteRecordDTO;
import com.jhonatan.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteRecordDTO clienteRecordDTO){
        if(clienteRepository.findByCpf(clienteRecordDTO.cpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado.");
        }

        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(clienteRecordDTO.dataNascimento(), dataAtual);

        if (idade.getYears() < 18) {
            throw new RuntimeException("A pessoa é menor de idade.");
        }

        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDTO,clienteModel);
        return clienteRepository.save(clienteModel);
    }

    @Transactional
    public ClienteModel getCliente(Long idCliente){
        Optional<ClienteModel> clienteOp = clienteRepository.findById(idCliente);
        if(clienteOp.isPresent()){
            return clienteOp.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente not found with id: " + idCliente);
        }
    }

    @Transactional
    public ClienteModel updateCliente(Long idCliente, ClienteRecordDTO clienteRecordDTO){
       ClienteModel cliente = clienteRepository.findById(idCliente)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado."));
       BeanUtils.copyProperties(clienteRecordDTO,cliente);
       return clienteRepository.save(cliente);
    }

    @Transactional
    public String deleteCliente(Long idCliente){
       ClienteModel cliente = clienteRepository.findById(idCliente)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
       clienteRepository.delete(cliente);
       return "Cliente excluido com sucesso";
    }
}

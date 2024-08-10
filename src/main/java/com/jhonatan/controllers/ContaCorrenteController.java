package com.jhonatan.controllers;

import com.jhonatan.models.ContaCorrenteModel;
import com.jhonatan.records.ContaCorrenteRecordDTO;
import com.jhonatan.records.DepositoDTO;
import com.jhonatan.services.ContaCorrenteService;
import com.jhonatan.services.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;
    private final TransacaoService transacaoService;


    public ContaCorrenteController(ContaCorrenteService contaCorrenteService,TransacaoService transacaoService) {
        this.contaCorrenteService = contaCorrenteService;
        this.transacaoService = transacaoService;
    }

    @PostMapping("/{idCliente}")
    public ResponseEntity<ContaCorrenteModel> criarContaCorrente(@PathVariable(value = "idCliente") Long idCliente,
                                                                 @RequestBody ContaCorrenteRecordDTO contaCorrenteRecordDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contaCorrenteService.criarConta(idCliente, contaCorrenteRecordDTO));
    }

    @PostMapping("/depositar/{idConta}")
    public ResponseEntity<Void> depositar(@PathVariable(value = "idConta") Long idConta,
                                          @RequestBody DepositoDTO depositoDTO) {
        contaCorrenteService.depositar(idConta, depositoDTO.getValor());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

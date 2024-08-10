package com.jhonatan.controllers;

import com.jhonatan.services.ContaBancariaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conta-bancaria")
public class ContaBancariaController {

    private final ContaBancariaService contaBancariaService;

    public ContaBancariaController(ContaBancariaService contaBancariaService){
        this.contaBancariaService = contaBancariaService;
    }

    @PostMapping("/transferir")
    public void transferir(@RequestParam Long idContaOrigem,
                           @RequestParam Long idContaDestino,
                           @RequestParam String valor) {
        contaBancariaService.transferir(idContaOrigem, idContaDestino, new BigDecimal(valor));
    }

    @PostMapping("/depositar")
    public void depositar(@RequestParam Long idConta, @RequestParam String valor){
        contaBancariaService.depositar(idConta, new BigDecimal(valor));
    }
}

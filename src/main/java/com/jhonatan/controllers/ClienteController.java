package com.jhonatan.controllers;

import com.jhonatan.models.ClienteModel;
import com.jhonatan.records.ClienteRecordDTO;
import com.jhonatan.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/cliente")
public class ClienteController {


   private final ClienteService clienteService;

   public ClienteController(ClienteService clienteService){
       this.clienteService = clienteService;
   }

    @PostMapping("/")
    public ResponseEntity<ClienteModel> save(@RequestBody @Valid ClienteRecordDTO clienteRecordDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteRecordDTO));
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> getCliente(@PathVariable(value = "idCliente") Long idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getCliente(idCliente));
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable(value = "idCliente") Long idCliente,
                                                      @RequestBody ClienteRecordDTO clienteRecordDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.updateCliente(idCliente,clienteRecordDTO));
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> deleteCliente(@PathVariable(value = "idCliente") Long idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.deleteCliente(idCliente));
    }

}

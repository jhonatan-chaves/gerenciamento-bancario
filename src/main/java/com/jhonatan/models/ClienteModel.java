package com.jhonatan.models;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ClienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCliente;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    public ClienteModel (){}

    public ClienteModel(Long idCliente, String nome, LocalDate dataNascimento, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}

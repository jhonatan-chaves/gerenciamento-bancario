package com.jhonatan.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteRecordDTO(@NotBlank String nome, @NotNull LocalDate dataNascimento, @NotBlank String cpf) {
    public ClienteRecordDTO {
        nome = nome.strip();
    }
}

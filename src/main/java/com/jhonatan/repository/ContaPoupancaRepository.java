package com.jhonatan.repository;

import com.jhonatan.models.ContaBancariaModel;
import com.jhonatan.models.ContaPoupancaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaPoupancaRepository extends JpaRepository<ContaPoupancaModel, Long> {
    Optional<ContaBancariaModel> findByNumeroConta(String numeroConta);
}

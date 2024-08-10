package com.jhonatan.repository;

import com.jhonatan.models.ContaBancariaModel;
import com.jhonatan.models.ContaCorrenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrenteModel, Long> {

    Optional<ContaCorrenteModel> findByNumeroConta(String numeroConta);
}

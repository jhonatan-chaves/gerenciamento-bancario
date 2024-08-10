package com.jhonatan.repository;

import com.jhonatan.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {


    Optional<ClienteModel> findByCpf(String cpf);
}

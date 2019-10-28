package com.algaworks.algamoney.api.data.repository;

import com.algaworks.algamoney.api.data.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}

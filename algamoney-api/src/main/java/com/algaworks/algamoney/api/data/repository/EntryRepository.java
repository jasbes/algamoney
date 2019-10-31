package com.algaworks.algamoney.api.data.repository;

import com.algaworks.algamoney.api.data.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jsilva on 31/10/2019
 */
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {
}

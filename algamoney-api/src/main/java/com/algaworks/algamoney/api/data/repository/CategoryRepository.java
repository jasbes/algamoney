package com.algaworks.algamoney.api.data.repository;

import com.algaworks.algamoney.api.data.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

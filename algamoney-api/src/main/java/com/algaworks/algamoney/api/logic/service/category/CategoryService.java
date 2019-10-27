package com.algaworks.algamoney.api.logic.service.category;

import com.algaworks.algamoney.api.logic.bean.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> listAll();

    CategoryDTO add(CategoryDTO category);

    Optional<CategoryDTO> findById(Long id);
}

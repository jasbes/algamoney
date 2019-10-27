package com.algaworks.algamoney.api.logic.service.category;

import com.algaworks.algamoney.api.logic.bean.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listAll();

    CategoryDTO add(CategoryDTO category);

    CategoryDTO findById(Long id);
}

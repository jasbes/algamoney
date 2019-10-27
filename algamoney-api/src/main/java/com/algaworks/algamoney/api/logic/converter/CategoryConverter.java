package com.algaworks.algamoney.api.logic.converter;

import com.algaworks.algamoney.api.data.entity.CategoryEntity;
import com.algaworks.algamoney.api.logic.bean.CategoryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CategoryConverter implements Converter<CategoryEntity, CategoryDTO> {

    @Override
    public CategoryDTO convert(CategoryEntity categoryEntity) {
        return new CategoryDTO(categoryEntity.getId(), categoryEntity.getName());
    }

    public CategoryEntity convert(CategoryDTO categoryDTO) {
        return new CategoryEntity(categoryDTO.getId(), categoryDTO.getName());
    }
}

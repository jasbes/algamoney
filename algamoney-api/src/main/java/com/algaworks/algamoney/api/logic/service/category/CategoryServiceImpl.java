package com.algaworks.algamoney.api.logic.service.category;

import com.algaworks.algamoney.api.data.repository.CategoryRepository;
import com.algaworks.algamoney.api.logic.bean.CategoryDTO;
import com.algaworks.algamoney.api.logic.converter.CategoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryConverter categoryConverter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public List<CategoryDTO> listAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO add(@RequestBody CategoryDTO category) {
        return categoryConverter.convert(categoryRepository.save(categoryConverter.convert(category)));
    }
}

package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.logic.bean.CategoryDTO;
import com.algaworks.algamoney.api.logic.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryResource {

    private CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> search() {
        return categoryService.listAll();
    }
}

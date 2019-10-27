package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.logic.bean.CategoryDTO;
import com.algaworks.algamoney.api.logic.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
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
    public List<CategoryDTO> listAll() {
        return categoryService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CategoryDTO category, HttpServletResponse response) {
        CategoryDTO savedCategory =  categoryService.add(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{code}")
                .buildAndExpand(savedCategory.getId())
                .toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
}

package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.event.ResourceCreatedEvent;
import com.algaworks.algamoney.api.logic.bean.CategoryDTO;
import com.algaworks.algamoney.api.logic.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryResource {

    private CategoryService categoryService;

    private ApplicationEventPublisher publisher;

    @Autowired
    public CategoryResource(CategoryService categoryService, ApplicationEventPublisher publisher) {
        this.categoryService = categoryService;
        this.publisher = publisher;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_PESQUISAR_CATEGORIA')")
    public List<CategoryDTO> listAll() {
        return categoryService.listAll();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_CADASTRAR_CATEGORIA')")
    public ResponseEntity<CategoryDTO> add(@RequestBody @Valid CategoryDTO category, HttpServletResponse response) {
        CategoryDTO savedCategory =  categoryService.add(category);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_PESQUISAR_CATEGORIA')")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

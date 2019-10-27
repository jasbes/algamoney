package com.algaworks.algamoney.api.logic.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;
}

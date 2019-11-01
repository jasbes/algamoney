package com.algaworks.algamoney.api.logic.bean;

import com.algaworks.algamoney.api.data.entity.EntryType;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author jsilva on 31/10/2019
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EntryDTO {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private LocalDate dueDate;

    private LocalDate paymentDate;

    @NotNull
    private BigDecimal amount;

    private String comment;

    @NotNull
    private EntryType type;

    @NotNull
    private CategoryDTO category;

    @NotNull
    private ClientDTO client;
}

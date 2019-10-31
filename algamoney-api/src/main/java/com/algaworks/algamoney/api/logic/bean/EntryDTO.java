package com.algaworks.algamoney.api.logic.bean;

import com.algaworks.algamoney.api.data.entity.EntryType;
import lombok.*;

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

    private String description;

    private LocalDate dueDate;

    private LocalDate paymentDate;

    private BigDecimal amount;

    private String comment;

    private EntryType type;

    private CategoryDTO category;

    private ClientDTO client;
}

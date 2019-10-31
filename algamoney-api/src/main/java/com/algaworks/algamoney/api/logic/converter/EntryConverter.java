package com.algaworks.algamoney.api.logic.converter;

import com.algaworks.algamoney.api.data.entity.EntryEntity;
import com.algaworks.algamoney.api.logic.bean.EntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author jsilva on 31/10/2019
 */
@Component
public class EntryConverter implements Converter<EntryEntity, EntryDTO> {

    private CategoryConverter categoryConverter;

    private ClientConverter clientConverter;

    @Autowired
    public EntryConverter(CategoryConverter categoryConverter, ClientConverter clientConverter) {
        this.categoryConverter = categoryConverter;
        this.clientConverter = clientConverter;
    }

    @Override
    public EntryDTO convert(EntryEntity entryEntity) {
        return EntryDTO
                .builder()
                .id(entryEntity.getId())
                .description(entryEntity.getDescription())
                .dueDate(entryEntity.getDueDate())
                .paymentDate(entryEntity.getPaymentDate())
                .amount(entryEntity.getAmount())
                .comment(entryEntity.getComment())
                .type(entryEntity.getType())
                .category(categoryConverter.convert(entryEntity.getCategory()))
                .client(clientConverter.convert(entryEntity.getClient()))
                .build();
    }

    public EntryEntity convert(EntryDTO entryDTO) {
        return EntryEntity
                .builder()
                .id(entryDTO.getId())
                .description(entryDTO.getDescription())
                .dueDate(entryDTO.getDueDate())
                .paymentDate(entryDTO.getPaymentDate())
                .amount(entryDTO.getAmount())
                .comment(entryDTO.getComment())
                .type(entryDTO.getType())
                .category(categoryConverter.convert(entryDTO.getCategory()))
                .client(clientConverter.convert(entryDTO.getClient()))
                .build();
    }
}

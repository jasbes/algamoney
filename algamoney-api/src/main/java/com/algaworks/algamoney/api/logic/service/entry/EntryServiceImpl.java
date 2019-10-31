package com.algaworks.algamoney.api.logic.service.entry;

import com.algaworks.algamoney.api.data.repository.EntryRepository;
import com.algaworks.algamoney.api.logic.bean.EntryDTO;
import com.algaworks.algamoney.api.logic.converter.EntryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jsilva on 31/10/2019
 */
@Service
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;

    private EntryConverter entryConverter;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository, EntryConverter entryConverter) {
        this.entryRepository = entryRepository;
        this.entryConverter = entryConverter;
    }

    @Override
    public EntryDTO add(EntryDTO entryDTO) {
        return entryConverter.convert(entryRepository.save(entryConverter.convert(entryDTO)));
    }

    @Override
    public List<EntryDTO> listAll() {
        return entryRepository
                .findAll()
                .stream()
                .map(entryConverter::convert)
                .collect(Collectors.toList());
    }
}

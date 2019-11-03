package com.algaworks.algamoney.api.logic.service.entry;

import com.algaworks.algamoney.api.data.search.filter.EntryFilter;
import com.algaworks.algamoney.api.logic.bean.EntryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author jsilva on 31/10/2019
 */
public interface EntryService {

    EntryDTO add(EntryDTO entryDTO);

    Page<EntryDTO> search(EntryFilter filter, Pageable pageable);

    void remove(Long id);
}

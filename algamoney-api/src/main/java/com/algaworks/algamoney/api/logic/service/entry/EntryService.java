package com.algaworks.algamoney.api.logic.service.entry;

import com.algaworks.algamoney.api.logic.bean.EntryDTO;

import java.util.List;

/**
 * @author jsilva on 31/10/2019
 */
public interface EntryService {

    EntryDTO add(EntryDTO entryDTO);

    List<EntryDTO> listAll();
}

package com.algaworks.algamoney.api.logic.service.client;

import com.algaworks.algamoney.api.logic.bean.ClientDTO;

import java.util.Optional;

public interface ClientService {

    ClientDTO add(ClientDTO clientDTO);

    Optional<ClientDTO> findById(long id);

    void remove(Long id);

    ClientDTO update(ClientDTO clientDTO);

    void setActive(Long id, Boolean isActive);
}

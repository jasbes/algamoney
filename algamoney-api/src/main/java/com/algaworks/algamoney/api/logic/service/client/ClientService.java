package com.algaworks.algamoney.api.logic.service.client;

import com.algaworks.algamoney.api.logic.bean.ClientDTO;

import java.util.Optional;

public interface ClientService {

    ClientDTO add(ClientDTO clientDTO);

    Optional<ClientDTO> findById(long id);
}

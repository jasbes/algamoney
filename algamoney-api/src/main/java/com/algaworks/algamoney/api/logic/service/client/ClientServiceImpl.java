package com.algaworks.algamoney.api.logic.service.client;

import com.algaworks.algamoney.api.data.repository.ClientRepository;
import com.algaworks.algamoney.api.logic.bean.ClientDTO;
import com.algaworks.algamoney.api.logic.converter.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientConverter clientConverter;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    @Override
    public ClientDTO add(ClientDTO clientDTO) {
        return clientConverter.convert(clientRepository.save(clientConverter.convert(clientDTO)));
    }

    @Override
    public Optional<ClientDTO> findById(long id) {
        return clientRepository
                .findById(id)
                .map(clientConverter::convert);
    }
}

package com.algaworks.algamoney.api.logic.service.client;

import com.algaworks.algamoney.api.data.entity.ClientEntity;
import com.algaworks.algamoney.api.data.repository.ClientRepository;
import com.algaworks.algamoney.api.logic.bean.ClientDTO;
import com.algaworks.algamoney.api.logic.converter.ClientConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public ClientDTO update(ClientDTO clientDTO) {
        ClientEntity savedClient = getClient(clientDTO.getId());

        ClientEntity client = clientConverter.convert(clientDTO);
        BeanUtils.copyProperties(client, savedClient, "id");

        return clientConverter.convert(clientRepository.save(savedClient));
    }

    private ClientEntity getClient(Long id) {
        return clientRepository
                    .findById(id)
                    .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public void setActive(Long id, Boolean isActive) {
        ClientEntity client = getClient(id);
        client.setActive(isActive);
        clientRepository.save(client);
    }

    @Override
    public Optional<ClientDTO> findById(long id) {
        return clientRepository
                .findById(id)
                .map(clientConverter::convert);
    }

    @Override
    public void remove(Long id) {
        clientRepository.deleteById(id);
    }
}

package com.algaworks.algamoney.api.logic.converter;

import com.algaworks.algamoney.api.data.entity.Address;
import com.algaworks.algamoney.api.data.entity.ClientEntity;
import com.algaworks.algamoney.api.logic.bean.AddressDTO;
import com.algaworks.algamoney.api.logic.bean.ClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ClientConverter implements Converter<ClientEntity, ClientDTO> {

    @Override
    public ClientDTO convert(ClientEntity clientEntity) {
        AddressDTO addressDTO = null;
        if(clientEntity.getAddress() != null) {
            addressDTO = AddressDTO
                            .builder()
                            .street(clientEntity.getAddress().getStreet())
                            .number(clientEntity.getAddress().getNumber())
                            .complement(clientEntity.getAddress().getComplement())
                            .cp(clientEntity.getAddress().getCp())
                            .city(clientEntity.getAddress().getCity())
                            .state(clientEntity.getAddress().getState())
                            .build();
        }

        return ClientDTO
                .builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .active(clientEntity.getActive())
                .address(addressDTO)
                .build();
    }

    public ClientEntity convert(ClientDTO clientDTO) {
        Address address = null;

        if(clientDTO.getAddress() != null) {
            address = Address
                        .builder()
                        .street(clientDTO.getAddress().getStreet())
                        .number(clientDTO.getAddress().getNumber())
                        .complement(clientDTO.getAddress().getComplement())
                        .cp(clientDTO.getAddress().getCp())
                        .city(clientDTO.getAddress().getCity())
                        .state(clientDTO.getAddress().getState())
                        .build();
        }

        return ClientEntity
                .builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .active(clientDTO.getActive())
                .address(address)
                .build();
    }
}

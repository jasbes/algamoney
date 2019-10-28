package com.algaworks.algamoney.api.logic.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    private Long id;

    private String name;

    private AddressDTO address;

    private Boolean active;
}

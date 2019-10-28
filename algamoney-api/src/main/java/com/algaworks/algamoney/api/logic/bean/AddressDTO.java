package com.algaworks.algamoney.api.logic.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {

    private String street;

    private String number;

    private String complement;

    private String cp;

    private String city;

    private String state;
}

package com.algaworks.algamoney.api.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = {"id"})
public class ClientEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "active")
    private Boolean active;
}

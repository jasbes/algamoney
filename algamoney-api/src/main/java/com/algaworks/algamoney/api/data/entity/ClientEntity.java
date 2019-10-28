package com.algaworks.algamoney.api.data.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString
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
    @Type(type="yes_no")
    private Boolean active;
}

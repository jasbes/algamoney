package com.algaworks.algamoney.api.data.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jsilva on 07/11/2019
 */
@Entity
@Table(name = "permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class PermissionEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;
}

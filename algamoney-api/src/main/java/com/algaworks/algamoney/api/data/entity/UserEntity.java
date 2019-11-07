package com.algaworks.algamoney.api.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author jsilva on 07/11/2019
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_permission", joinColumns = @JoinColumn(name = "users_id")
            , inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<PermissionEntity> permissions;
}

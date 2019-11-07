package com.algaworks.algamoney.api.security;

import com.algaworks.algamoney.api.data.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author jsilva on 07/11/2019
 */
@Getter
public class ApiUser extends User {

    private UserEntity user;

    public ApiUser(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }
}

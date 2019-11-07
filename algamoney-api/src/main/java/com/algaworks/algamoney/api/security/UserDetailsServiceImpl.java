package com.algaworks.algamoney.api.security;

import com.algaworks.algamoney.api.data.entity.PermissionEntity;
import com.algaworks.algamoney.api.data.entity.UserEntity;
import com.algaworks.algamoney.api.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author jsilva on 07/11/2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User and/or email invalid."));
        return new ApiUser(userEntity, getPermissions(userEntity));
    }

    private Collection<? extends GrantedAuthority> getPermissions(UserEntity userEntity) {
        return userEntity
                .getPermissions()
                .stream()
                .map(PermissionEntity::getDescription)
                .map(String::toUpperCase)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}

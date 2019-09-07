package org.trident.security.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsDTO implements UserDetails {

    private AccountDTO accountDTO;

    public UserDetailsDTO(final AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.accountDTO.getRoles()
                .stream()
                .map(roleDTO -> (GrantedAuthority) () -> String.join(",", "ROLE_"+ roleDTO.getRoleName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.accountDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return this.accountDTO.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountDTO.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.accountDTO.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.accountDTO.getLocked();
    }

    @Override
    public boolean isEnabled() {
        return this.accountDTO.getActive();
    }
}

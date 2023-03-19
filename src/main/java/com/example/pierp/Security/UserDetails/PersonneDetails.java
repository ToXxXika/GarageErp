package com.example.pierp.Security.UserDetails;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.Transient;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class PersonneDetails implements UserDetails {
private String cin;
private String prenom;
private String nom;
private String numtel;
private String role;
private String password;
private boolean enabled;
private List<GrantedAuthority> authorities;


public PersonneDetails(String cin, String password,String role,List<GrantedAuthority> authorities) {
        this.cin = cin;
        this.password = password;
        this.role = role;
        this.authorities=authorities;
        this.enabled = true;
    }
    @Transactional
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Transactional
    @Override
    public String getPassword() {
        return password;
    }

    @Transactional
    @Override
    public String getUsername() {
        return cin;
    }

    @Transactional
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Transactional

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transactional

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transactional
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

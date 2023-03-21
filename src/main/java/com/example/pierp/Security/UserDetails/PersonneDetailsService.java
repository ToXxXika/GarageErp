package com.example.pierp.Security.UserDetails;

import com.example.pierp.Models.Personne;
import com.example.pierp.Services.Implementation.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneDetailsService implements UserDetailsService {

    @Autowired
    private PersonneServiceImpl personneService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne u = personneService.loadUserByUsername(username);
        if(u == null){
            throw new UsernameNotFoundException("User not found");
        }
        getAuthorities(u.getRole());
        return new PersonneDetails(u.getCin(),u.getPassword(),u.getRole(),getAuthorities(u.getRole()));
    }
    private List<GrantedAuthority> getAuthorities(String role){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}

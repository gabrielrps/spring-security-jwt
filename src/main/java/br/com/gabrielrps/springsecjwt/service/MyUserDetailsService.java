package br.com.gabrielrps.springsecjwt.service;

import br.com.gabrielrps.springsecjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        br.com.gabrielrps.springsecjwt.model.User u = userRepository.findByUsername(s);

        Set<SimpleGrantedAuthority> permissions = u.getPerfil().getAuthority().stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toSet());

        return User.builder()
                .username(u.getUsername())
                .password(u.getPassword())
                .accountExpired(u.isAccountNonExpired())
                .accountLocked(u.isAccountNonLocked())
                .credentialsExpired(u.isCredentialsNonExpired())
                .authorities(permissions)
                .build();
    }
}

package br.com.gabrielrps.springsecjwt.service;

import br.com.gabrielrps.springsecjwt.model.Perfil;
import br.com.gabrielrps.springsecjwt.model.User;
import br.com.gabrielrps.springsecjwt.payload.RegisterRequest;
import br.com.gabrielrps.springsecjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);
        user.setAccountNonLocked(false);
        user.setAccountNonExpired(false);
        user.setCredentialsNonExpired(false);
        user.setPerfil(perfilService.findByName("ADMIN"));

        userRepository.save(user);
    }
}

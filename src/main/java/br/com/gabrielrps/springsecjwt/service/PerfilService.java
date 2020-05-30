package br.com.gabrielrps.springsecjwt.service;

import br.com.gabrielrps.springsecjwt.model.Perfil;
import br.com.gabrielrps.springsecjwt.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil findByName(String name){
        return perfilRepository.findByName(name);
    }

}

package br.com.gabrielrps.springsecjwt.repository;

import br.com.gabrielrps.springsecjwt.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Perfil findByName(String name);
}

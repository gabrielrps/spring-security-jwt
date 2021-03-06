package br.com.gabrielrps.springsecjwt.repository;

import br.com.gabrielrps.springsecjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String s);

}

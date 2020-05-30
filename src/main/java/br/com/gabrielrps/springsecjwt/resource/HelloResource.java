package br.com.gabrielrps.springsecjwt.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloResource {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

}

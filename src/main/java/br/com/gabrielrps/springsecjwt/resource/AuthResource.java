package br.com.gabrielrps.springsecjwt.resource;


import br.com.gabrielrps.springsecjwt.jwt.JwtUtils;
import br.com.gabrielrps.springsecjwt.payload.AuthenticationRequest;
import br.com.gabrielrps.springsecjwt.payload.AuthenticationResponse;
import br.com.gabrielrps.springsecjwt.payload.RegisterRequest;
import br.com.gabrielrps.springsecjwt.service.MyUserDetailsService;
import br.com.gabrielrps.springsecjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authenticate);

            User principal = (User) authenticate.getPrincipal();

            final AuthenticationResponse authenticationResponse = jwtUtils.generateToken(principal);

            return ResponseEntity.status(HttpStatus.OK).body(authenticationResponse);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("Incorrent username or password", e);
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        userService.signup(registerRequest);

        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }




}

package br.com.gabrielrps.springsecjwt.payload;

import java.time.Instant;
import java.util.Date;

public class AuthenticationResponse {

    private String jwt;
    private String refreshJwt;
    private Date expiresAtToken;
    private Date expiresAtRefreshToken;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, String refreshJwt) {
        this.refreshJwt = refreshJwt;
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRefreshJwt() {
        return refreshJwt;
    }

    public void setRefreshJwt(String refreshJwt) {
        this.refreshJwt = refreshJwt;
    }

    public Date getExpiresAtToken() {
        return expiresAtToken;
    }

    public void setExpiresAtToken(Date expiresAt) {
        this.expiresAtToken = expiresAt;
    }

    public Date getExpiresAtRefreshToken() {
        return expiresAtRefreshToken;
    }

    public void setExpiresAtRefreshToken(Date expiresAtRefreshToken) {
        this.expiresAtRefreshToken = expiresAtRefreshToken;
    }
}

package tn.sesame.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationManager {
    Authentication authenticate(Authentication var1) throws AuthenticationException;
}
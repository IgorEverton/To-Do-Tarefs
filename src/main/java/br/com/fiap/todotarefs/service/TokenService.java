package br.com.fiap.todotarefs.service;


import br.com.fiap.todotarefs.models.Usuario;
import br.com.fiap.todotarefs.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    String secret;
    public String gerarToken(Usuario usuario) throws JWTCreationException {
        var algoritmo = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("TO-DO-TAREFS")
                .withSubject(usuario.getUsername())
                .sign(algoritmo);
    }

    public String validarToken(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("TO-DO-TAREFS")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

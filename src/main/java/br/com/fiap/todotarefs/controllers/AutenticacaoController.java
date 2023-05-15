package br.com.fiap.todotarefs.controllers;


import br.com.fiap.todotarefs.DTO.AutenticacaoDTO;
import br.com.fiap.todotarefs.models.Usuario;
import br.com.fiap.todotarefs.repository.UsuarioRepository;
import br.com.fiap.todotarefs.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/autenticacao")
public class AutenticacaoController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    public AutenticacaoController() {
    }

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email()
                ,dados.senha());
        var authentication =   authenticationManager.authenticate(token);
        String tokenRetorno =tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(tokenRetorno);
    }
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

    }

}

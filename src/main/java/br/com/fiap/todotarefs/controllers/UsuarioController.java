package br.com.fiap.todotarefs.controllers;


import java.util.ArrayList;
import java.util.List;

import br.com.fiap.todotarefs.DTO.usuario.AtualizaUsuarioDTO;
import br.com.fiap.todotarefs.DTO.usuario.CadastroUsuaroiDTO;
import br.com.fiap.todotarefs.DTO.usuario.RetornarUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.todotarefs.exception.RestNotFoundException;
import br.com.fiap.todotarefs.models.Usuario;
import br.com.fiap.todotarefs.repository.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/api/usuarios")
@RestController
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping
    @Transactional
    public ResponseEntity<RetornarUsuarioDTO>  cadastrarUsuario(@RequestBody CadastroUsuaroiDTO dados, UriComponentsBuilder builder){
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(dados, Usuario.class);
        usuario.setSenha(encoder.encode(dados.senha()));
        usuarioRepository.save(usuario);
        var uri = builder.path("/api/usuario/{nome}").buildAndExpand(usuario.getNome()).toUri();
        return ResponseEntity.created(uri).body(new RetornarUsuarioDTO(usuario));

    }

    @GetMapping("/{id}")
    public ResponseEntity<RetornarUsuarioDTO> listaUsuaroPorId(@PathVariable Long id){
        var usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario não encontrado"));
       return ResponseEntity.ok(new RetornarUsuarioDTO(usuario));
    }

    @PutMapping
    public  ResponseEntity<RetornarUsuarioDTO> atualizarUsuario(@RequestBody AtualizaUsuarioDTO dados){
        var usuarioRetorno = listaUsuaroPorId(dados.id());
         ModelMapper mapper=new ModelMapper();
         var usuario=mapper.map(usuarioRetorno,Usuario.class);
        if(dados.nome()!=null){
            usuario.setNome(dados.nome());
        } else if (dados.email()!=null) {
            usuario.setEmail(dados.email());
        } else if (dados.dataNscimento()!=null) {
            usuario.setDataNscimento(dados.dataNscimento());
        }else if (dados.senha()!=null){
            var semha = encoder.encode(dados.senha());
            usuario.setSenha(semha);
        }else if(dados.telefone()!=null){
            usuario.setSenha(dados.telefone());
        }

        return ResponseEntity.ok(new RetornarUsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id){
        var usuarioRetorno = listaUsuaroPorId(id);
        ModelMapper mapper=new ModelMapper();
        var usuario=mapper.map(usuarioRetorno,Usuario.class);
        usuario.setAtivo(false);

        return ResponseEntity.noContent().build();
    }



}

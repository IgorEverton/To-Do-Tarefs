package br.com.fiap.todotarefs.models;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import br.com.fiap.todotarefs.controllers.UsuarioController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tdt_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nm_usuario;
    private LocalDate dt_nascimento;
    private String ds_email;
    private String nr_telefone;
    private boolean st_conta;
    

    public EntityModel<Usuario> toModel(){
        return EntityModel.of(
        this,
        linkTo(methodOn(UsuarioController.class).show(id)).withSelfRel(),
        linkTo(methodOn(UsuarioController.class).destroy(id)).withRel("delete"),
        linkTo(methodOn(UsuarioController.class).index(Pageable.unpaged())).withRel("all"));

}
}
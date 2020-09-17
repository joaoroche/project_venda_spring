package io.github.joaoroche.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "{campo.preco.obrigatorio}")
    @Column(name = "preco_unitario")
    private BigDecimal preco;

}
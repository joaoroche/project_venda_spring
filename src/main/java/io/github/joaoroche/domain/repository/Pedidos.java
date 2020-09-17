package io.github.joaoroche.domain.repository;

import io.github.joaoroche.domain.entity.Cliente;
import io.github.joaoroche.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left  join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(@PathVariable("id") Integer id);
}

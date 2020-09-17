package io.github.joaoroche.domain.repository;

import io.github.joaoroche.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}

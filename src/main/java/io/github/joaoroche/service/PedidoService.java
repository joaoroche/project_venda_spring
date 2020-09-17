package io.github.joaoroche.service;

import io.github.joaoroche.domain.entity.Pedido;
import io.github.joaoroche.domain.enums.StatusPedido;
import io.github.joaoroche.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}

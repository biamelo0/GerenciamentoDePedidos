package com.projetoGerenciamentoDePedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoDePedidos.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

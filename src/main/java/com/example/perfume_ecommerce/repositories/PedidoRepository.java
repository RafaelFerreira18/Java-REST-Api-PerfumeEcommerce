package com.example.perfume_ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.perfume_ecommerce.models.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
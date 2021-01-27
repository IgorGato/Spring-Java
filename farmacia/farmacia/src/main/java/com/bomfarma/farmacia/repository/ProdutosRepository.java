package com.bomfarma.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bomfarma.farmacia.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List<Produtos> findAllbByNomeIgnoreCase(String nome);
}

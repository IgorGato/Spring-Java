package com.STARZ.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.STARZ.games.model.Categoria;

@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAllByDescricaoIgnoreCase(String descricao);
}

package com.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.forumhub.model.Topico;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCurso(String curso);
}

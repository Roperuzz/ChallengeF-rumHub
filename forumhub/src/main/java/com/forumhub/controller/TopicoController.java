package com.forumhub.controller;

import com.forumhub.dto.TopicoDTO;
import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@RequestBody @Valid TopicoDTO dto) {
        Topico topico = dto.toEntity();
        return ResponseEntity.ok(repository.save(topico));
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoDTO dto) {
        return repository.findById(id).map(topico -> {
            topico.setTitulo(dto.getTitulo());
            topico.setMensagem(dto.getMensagem());
            return ResponseEntity.ok(repository.save(topico));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



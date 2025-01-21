package com.forumhub.dto;

import com.forumhub.model.Topico;
import jakarta.validation.constraints.NotBlank;

public class TopicoDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;

    public Topico toEntity() {
        Topico topico = new Topico();
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        topico.setAutor(this.autor);
        topico.setCurso(this.curso);
        return topico;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public @NotBlank String getMensagem() {
        return mensagem;
    }

    public @NotBlank String getAutor() {
        return autor;
    }

    public @NotBlank String getCurso() {
        return curso;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(@NotBlank String mensagem) {
        this.mensagem = mensagem;
    }

    public void setAutor(@NotBlank String autor) {
        this.autor = autor;
    }

    public void setCurso(@NotBlank String curso) {
        this.curso = curso;
    }
}


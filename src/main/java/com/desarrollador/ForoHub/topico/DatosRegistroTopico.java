package com.desarrollador.ForoHub.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank @JsonAlias("fecha de creacion") String fecha_de_creacion,
        @NotBlank String status,
        @NotBlank String autor,
        @NotBlank String curso) {

    public DatosRegistroTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}

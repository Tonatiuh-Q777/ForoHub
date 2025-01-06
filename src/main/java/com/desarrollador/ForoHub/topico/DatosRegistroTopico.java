package com.desarrollador.ForoHub.topico;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosRegistroTopico(String titulo,
                                  String mensaje,
                                  @JsonAlias("fecha de creacion") String fecha_de_creacion,
                                  String status,
                                  String autor,
                                  String curso) {
}

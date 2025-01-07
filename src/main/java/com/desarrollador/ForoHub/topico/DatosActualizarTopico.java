package com.desarrollador.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String status) {
}

package com.desarrollador.ForoHub.topico;

public record DatosListadoTopico(
         String titulo,
         String fecha_de_creacion,
         String status) {

    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(),  topico.getFecha_de_creacion(),
                topico.getStatus());
    }
}

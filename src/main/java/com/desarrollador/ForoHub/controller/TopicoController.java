package com.desarrollador.ForoHub.controller;

import com.desarrollador.ForoHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void resgistrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 5,sort = "titulo", direction = Sort.Direction.ASC) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRegistroTopico> detallesTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRegistroTopico(topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion(),
                topico.getStatus(), topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}


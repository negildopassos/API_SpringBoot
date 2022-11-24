package com.negildo.listatarefas.contollers;


import com.negildo.listatarefas.dtos.ListaDto;
import com.negildo.listatarefas.models.ListaModel;
import com.negildo.listatarefas.services.ListaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/lista")
public class ListaController {

    final ListaService listaService;

    public ListaController(ListaService listaService){
        this.listaService = listaService;
    }


    @PostMapping
    public ResponseEntity<Object> salvarTareva(@RequestBody @Valid ListaDto listaDto){
        var listaModel = new ListaModel();
        BeanUtils.copyProperties(listaDto, listaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaService.save(listaModel));
    }

    @GetMapping
    public ResponseEntity<Object> retornarTarefa(){
        return ResponseEntity.status(HttpStatus.OK).body(listaService.findall());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> retornandoUmaTarefa(@PathVariable(value = "id") Long id){
        Optional<ListaModel> listaModelOptional = listaService.findById(id);
        if (!listaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaTarefa(@PathVariable(value = "id") Long id){
        Optional<ListaModel> listaModelOptional = listaService.findById(id);
        if (!listaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        listaService.delete(listaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTarefa(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid ListaDto listaDto){
        Optional<ListaModel> listaModelOptional = listaService.findById(id);
        if (!listaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        var listaModel = new ListaModel();
        BeanUtils.copyProperties(listaDto, listaModel);
        listaModel.setId(listaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(listaService.save(listaModel));
    }



}

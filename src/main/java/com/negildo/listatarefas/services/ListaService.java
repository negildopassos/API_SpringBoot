package com.negildo.listatarefas.services;


import com.negildo.listatarefas.models.ListaModel;
import com.negildo.listatarefas.repositories.ListaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ListaService {
    final ListaRepository listaRepository;

    public ListaService(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }
    @Transactional
    public ListaModel save(ListaModel listaModel) {
        return listaRepository.save(listaModel);
    }


    public List<ListaModel> findall() {
        return listaRepository.findAll();
    }

    public Optional<ListaModel> findById(Long id) {

        return listaRepository.findById(id);

    }
    @Transactional
    public void delete(ListaModel listaModel) {
        listaRepository.delete(listaModel);
    }

}





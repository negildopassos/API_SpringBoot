package com.negildo.listatarefas.repositories;

import com.negildo.listatarefas.models.ListaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ListaRepository extends JpaRepository<ListaModel, Long> {
}

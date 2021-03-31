package com.linktracker.linktracker.repositories;

import com.linktracker.linktracker.entities.Link;

import java.util.HashMap;

public interface LinkRepository
{
    Integer agregarLink(Link link);
    HashMap<Integer, Link> obtenerMapaLinks();
    Integer eliminarLink(Integer id);
    Link obtenerLink(Integer id);
    void actualizarLink(Integer id, Link link);
}

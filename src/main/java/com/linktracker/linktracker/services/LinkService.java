package com.linktracker.linktracker.services;

import com.linktracker.linktracker.entities.Link;

public interface LinkService
{
    Integer nuevoLink(Link link, String password);
    Link obtenerLink(Integer id, String password);
    Integer eliminarLink(Integer id);
}

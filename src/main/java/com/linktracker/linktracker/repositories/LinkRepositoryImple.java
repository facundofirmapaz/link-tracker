package com.linktracker.linktracker.repositories;

import com.linktracker.linktracker.entities.Link;
import com.linktracker.linktracker.exceptionsHandlers.LinkNoEncontrado;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImple implements LinkRepository
{
    private static HashMap<Integer, Link> links = new HashMap<>();
    private static Integer contador = 0;

    @Override
    public Integer agregarLink(Link link)
    {
        contador++;
        links.put(contador, link);
        return contador;
    }

    @Override
    public HashMap<Integer, Link> obtenerMapaLinks()
    {
        return links;
    }

    @SneakyThrows
    @Override
    public Integer eliminarLink(Integer id)
    {
        var l = links.remove(id);

        if(l == null)
            throw new LinkNoEncontrado("No se encontro el link id: " + id);

        return id;
    }

    @SneakyThrows
    @Override
    public Link obtenerLink(Integer id)
    {
        Link l = links.get(id);

        if (l == null)
            throw new LinkNoEncontrado("No se encontro el link id: " + id);

        return l;
    }

    @Override
    public void actualizarLink(Integer id, Link link)
    {
        links.replace(id, link);
    }
}

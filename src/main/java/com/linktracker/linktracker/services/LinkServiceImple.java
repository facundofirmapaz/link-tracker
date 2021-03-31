package com.linktracker.linktracker.services;

import com.linktracker.linktracker.entities.Link;
import com.linktracker.linktracker.exceptionsHandlers.LinkInvalido;
import com.linktracker.linktracker.exceptionsHandlers.PasswordIncorrecto;
import com.linktracker.linktracker.repositories.LinkRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImple implements LinkService
{
    private final LinkRepository linkRepository;

    public LinkServiceImple(LinkRepository linkRepository)
    {
        this.linkRepository = linkRepository;
    }

    @SneakyThrows
    @Override
    public Integer nuevoLink(Link link, String password)
    {
        if(!link.urlValida())
            throw new LinkInvalido("Url mal conformada: " +link.getUrl());

        link.setPassword(password);

        return linkRepository.agregarLink(link);
    }

    @SneakyThrows
    @Override
    public Link obtenerLink(Integer id, String password)
    {
        var link = linkRepository.obtenerLink(id);

        if (!link.getPassword().equals(password))
            throw new PasswordIncorrecto("Password incorrecto");

        link.incrementarAcceso();

        linkRepository.actualizarLink(id, link);

        return linkRepository.obtenerLink(id);
    }

    @Override
    public Integer eliminarLink(Integer id)
    {
        return linkRepository.eliminarLink(id);
    }
}

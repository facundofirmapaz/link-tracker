package com.linktracker.linktracker.services;

import com.linktracker.linktracker.entities.Link;
import com.linktracker.linktracker.repositories.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class MetricaServiceImple implements MetricaService
{
    private final LinkRepository linkRepository;

    public MetricaServiceImple(LinkRepository linkRepository)
    {
        this.linkRepository = linkRepository;
    }

    @Override
    public Integer getMetricasAcceso(Integer id)
    {
        var link = linkRepository.obtenerLink(id);

        return link.getCantidadAccesos();
    }
}

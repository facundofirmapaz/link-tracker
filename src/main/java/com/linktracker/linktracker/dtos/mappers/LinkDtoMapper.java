package com.linktracker.linktracker.dtos.mappers;

import com.linktracker.linktracker.dtos.LinkDto;
import com.linktracker.linktracker.entities.Link;

public class LinkDtoMapper
{
    public static Link mapToLink(LinkDto l)
    {
        return new Link(l.getNombre(), l.getUrl());
    }

    public static LinkDto mapToDto(Link l)
    {
        return new LinkDto(l.getNombre(), l.getUrl());
    }
}

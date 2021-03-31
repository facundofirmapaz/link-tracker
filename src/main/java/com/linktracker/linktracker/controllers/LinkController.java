package com.linktracker.linktracker.controllers;

import com.linktracker.linktracker.dtos.LinkCreadoDto;
import com.linktracker.linktracker.dtos.LinkDto;
import com.linktracker.linktracker.dtos.LinkEliminadoDto;
import com.linktracker.linktracker.dtos.mappers.LinkDtoMapper;
import com.linktracker.linktracker.services.LinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/link")
public class LinkController extends BaseController
{
    private final LinkService linkService;

    public LinkController(LinkService linkService)
    {
        this.linkService = linkService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody LinkDto link, @RequestHeader String password)
    {
        Integer nuevoId = linkService.nuevoLink(LinkDtoMapper.mapToLink(link), password);
        var resp = new LinkCreadoDto(nuevoId);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/redirect/{id}")
    public ResponseEntity<?> redirect(@PathVariable Integer id, @RequestHeader String password)
    {
        var link = linkService.obtenerLink(id, password);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(link.getUrl()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping("/invalidar/{id}")
    public ResponseEntity<?> invalidar(@PathVariable Integer id)
    {
        Integer eliminado = linkService.eliminarLink(id);

        var resp = new LinkEliminadoDto(eliminado);

        return ResponseEntity.ok(resp);
    }
}

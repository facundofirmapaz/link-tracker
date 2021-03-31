package com.linktracker.linktracker.controllers;

import com.linktracker.linktracker.dtos.AccesosDto;
import com.linktracker.linktracker.services.MetricaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrica")
public class MetricaController extends BaseController
{
    private final MetricaService metricaService;

    public MetricaController(MetricaService metricaService)
    {
        this.metricaService = metricaService;
    }

    @GetMapping("/accesos/{id}")
    public ResponseEntity<?> accesos(@PathVariable Integer id)
    {
        var accesos = metricaService.getMetricasAcceso(id);

        var resp = new AccesosDto(id, accesos);

        return ResponseEntity.ok(resp);
    }
}

package com.linktracker.linktracker.entities;

import lombok.Data;
import java.net.URL;

@Data
public class Link
{
    private String nombre;
    private String url;
    private Integer cantidadAccesos;
    private String password;

    public Link(String nombre, String url, String password)
    {
        this.nombre = nombre;
        this.url = url;
        this.password = password;
        cantidadAccesos = 0;
    }

    public Link(String nombre, String url)
    {
        this.nombre = nombre;
        this.url = url;
        cantidadAccesos = 0;
    }

    public void incrementarAcceso()
    {
        cantidadAccesos++;
    }

    public boolean urlValida()
    {
        try
        {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}

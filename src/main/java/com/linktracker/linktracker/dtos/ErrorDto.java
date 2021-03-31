package com.linktracker.linktracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDto
{
    private String name;
    private String description;
}

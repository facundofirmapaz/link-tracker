package com.linktracker.linktracker.controllers;

import com.linktracker.linktracker.dtos.ErrorDto;
import com.linktracker.linktracker.exceptionsHandlers.LinkInvalido;
import com.linktracker.linktracker.exceptionsHandlers.LinkNoEncontrado;
import com.linktracker.linktracker.exceptionsHandlers.PasswordIncorrecto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController
{
    @ExceptionHandler(LinkInvalido.class)
    public ResponseEntity<?> handleException(LinkInvalido e)
    {
        ErrorDto errorDto = new ErrorDto("Link invalido", e.getMessage());

        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(LinkNoEncontrado.class)
    public ResponseEntity<ErrorDto> handleException(LinkNoEncontrado e)
    {
        ErrorDto errorDto = new ErrorDto("Link invalido", e.getMessage());

        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordIncorrecto.class)
    public ResponseEntity<ErrorDto> handleException(PasswordIncorrecto e)
    {
        ErrorDto errorDto = new ErrorDto("Error al direccionar", e.getMessage());

        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.UNAUTHORIZED);
    }

}

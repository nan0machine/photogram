package com.example.photogram.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NullEntityReferenceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView nullEntityReferenceExceptionHandler(HttpServletRequest request, NullEntityReferenceException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("code", HttpStatus.BAD_REQUEST.value() + " / " + HttpStatus.BAD_REQUEST.getReasonPhrase());
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ModelAndView entityNotFoundExceptionHandler(HttpServletRequest request, EntityNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("code", HttpStatus.NOT_FOUND + " / " + HttpStatus.NOT_FOUND.getReasonPhrase());
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
    // request param. for future logging
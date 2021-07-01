package ar.com.qwaserandres.controllers;

import ar.com.qwaserandres.model.Teachers;
import ar.com.qwaserandres.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/agregarprofesores")
    public String agregar(Teachers profesor) {
        return "gestionarProfesores";
    }

    @PostMapping("/guardarprofesores")
    public String guardar(@Valid Teachers profesor, Errors errores) {
        if(errores.hasErrors()) {
            return "gestionarProfesores";
        }
        teachersService.guardar(profesor);
        return "redirect:/";
    }

    @GetMapping("/editarprofesores/{idProfesores}")
    public String editar(Teachers profesor, Model model){
        profesor = teachersService.encontrarProfesores(profesor);
        model.addAttribute("profesores", profesor);
        return "gestionarProfesores";
    }

    @GetMapping("/eliminarprofesores")
    public String eliminar(Teachers profesor){
        teachersService.eliminar(profesor);
        return "redirect:/";
    }

}

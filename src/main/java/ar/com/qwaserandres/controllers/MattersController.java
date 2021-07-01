package ar.com.qwaserandres.controllers;

import ar.com.qwaserandres.model.Matters;
import ar.com.qwaserandres.service.MattersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class MattersController {

    @Autowired
    private MattersService mattersService;

    @GetMapping("/agregar")
    public String agregar(Matters materia) {
        return "gestionarMaterias";
    }

    @GetMapping("/inscripcion")
    public String inscripcion(Matters materia) {
        return "inscripcion";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Matters materia, Errors errores) {
        if(errores.hasErrors()) {
            return "gestionarMaterias";
        }
        mattersService.guardar(materia);
        return "redirect:/";
    }

    @GetMapping("/editar/{idMaterias}")
    public String editar(Matters materia, Model model){
        materia = mattersService.encontrarMaterias(materia);
        model.addAttribute("materias", materia);
        return "gestionarMaterias";
    }

    @GetMapping("/eliminar")
    public String eliminar(Matters materia){
        mattersService.eliminar(materia);
        return "redirect:/";
    }

}

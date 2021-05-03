
package ar.com.qwaserandres.web;

import ar.com.qwaserandres.domain.Materias;
import ar.com.qwaserandres.domain.Profesores;
import ar.com.qwaserandres.servicio.MateriasService;
import ar.com.qwaserandres.servicio.ProfesoresService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private MateriasService materiasService;
    
    @Autowired
    private ProfesoresService profesoresService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var materias = materiasService.listarMaterias(); 
        var profesores = profesoresService.listarProfesores();
        log.info("Ejecutando el Controlador_Inicio");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("materias", materias);
        model.addAttribute("profesores", profesores);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Materias materia) {
        return "gestionarMaterias";
    }
    //PROBANDO
    @GetMapping("/inscripcion")
    public String inscripcion(Materias materia) {
        return "inscripcion";
    }
    
    @GetMapping("/agregarprofesores")
    public String agregar(Profesores profesor) {
        return "gestionarProfesores";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Materias materia, Errors errores) {
        if(errores.hasErrors()) {
            return "gestionarMaterias";
        }
        materiasService.guardar(materia);
        return "redirect:/";
    }
    
    @PostMapping("/guardarprofesores")
    public String guardar(@Valid Profesores profesor, Errors errores) {
        if(errores.hasErrors()) {
            return "gestionarProfesores";
        }
        profesoresService.guardar(profesor);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idMaterias}")
    public String editar(Materias materia, Model model){
        materia = materiasService.encontrarMaterias(materia);
        model.addAttribute("materias", materia);
        return "gestionarMaterias";
    }
    
     @GetMapping("/editarprofesores/{idProfesores}")
    public String editar(Profesores profesor, Model model){
        profesor = profesoresService.encontrarProfesores(profesor);
        model.addAttribute("profesores", profesor);
        return "gestionarProfesores";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Materias materia){
        materiasService.eliminar(materia);
        return "redirect:/";
    }
    
    @GetMapping("/eliminarprofesores")
    public String eliminar(Profesores profesor){
        profesoresService.eliminar(profesor);
        return "redirect:/";
    }
    
    
}

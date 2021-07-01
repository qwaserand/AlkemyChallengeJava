package ar.com.qwaserandres.controllers;

import ar.com.qwaserandres.service.MattersService;
import ar.com.qwaserandres.service.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {

    @Autowired
    private MattersService mattersService;

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var materias = mattersService.listarMaterias();
        var profesores = teachersService.listarProfesores();
        log.info("Ejecutando el Controlador_Inicio");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("materias", materias);
        model.addAttribute("profesores", profesores);
        return "index";
    }

}

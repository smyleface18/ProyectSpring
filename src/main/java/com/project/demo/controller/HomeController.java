package com.project.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/", "/home" }) // utilizar varias rutas para el metodo
    public String home() {
        return "redirect:/list"; // redirige a al controlador list por lo tanto refresca la pagina y cambia la
                                 // ruta url y se pueden
                                 // perder los parametros etc
    }

    @GetMapping({ "//", "/forward" }) // cambia la ruta y no se pierden los path
    public String forward() {
        return "forward:/statusModel";
    }

}

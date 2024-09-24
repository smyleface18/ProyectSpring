package com.project.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.demo.models.User;

@Controller
public class UserController {

    @GetMapping("/statusModel")
    // se puede utilizar " @ResponseBody" para indicar que la respuesta sera en
    // json;
    public String status(Model model) {
        // El objeto Model es usado para almacenar datos que se mostrarán o manipularán
        // en vistas (views) u otros componentes de la aplicación este model solo se
        // utiliza para vistas (view user). tambien se puede
        // utilizar el objeto Map<tipo de dato, Objecto> name del objeto
        model.addAttribute("title", "Hola Spring boot :D");
        model.addAttribute("name", "Caleb");
        model.addAttribute("lastname", "Acosta");

        User user = new User("Pedro", "zapata");
        User user2 = new User("adriana", "Rodriguez", "adr300@gmail.com");
        User user3 = new User("Juan", "ll");
        User user4 = new User("Fernando", "Rodriguez", "fern35@gmail.com");
        model.addAttribute("user", user); // agregamos un objecto al model
        model.addAttribute("user2", user2);
        model.addAttribute("user3", user3);
        model.addAttribute("user4", user4);
        return "hi"; // solo el nombre del archivo
    }

    @GetMapping("/list")
    public String list(ModelMap model) { // ModelMap se basa en un HashMap de java

        model.addAttribute("title", "lista de users");
        return "list";
    }

    @ModelAttribute("users") // convierte a users en global es para utilizar datos que tengan muchos metodos
                             // en comun
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("Pedro", "zapata");
        User user2 = new User("adriana", "Rodriguez", "adr300@gmail.com");
        User user3 = new User("Juan", "ll");
        User user4 = new User("Fernando", "Rodriguez", "fern35@gmail.com");

        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }
}

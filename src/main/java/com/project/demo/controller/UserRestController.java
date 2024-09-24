package com.project.demo.controller;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.models.User;
import com.project.demo.models.dto.UserDto;

@RestController // La diferencia con controller es que retorna la respuesta de los metodos como
                // un json (esto lo hace conectando se a una api llamada jackson es un
                // procesador JSON de alto rendimiento para Java)

@RequestMapping("/api") // Permite poner una ruta base o de primer nivel ejemplo para acceder al
                        // endpoint status seria "/api/RestStatus"
public class UserRestController {

    @GetMapping("/RestStatus") // @GetMapping. En concreto, es una anotación compuesta que actúa como un atajo
                               // para @RequestMapping(method = RequestMethod.GET) existen tambien PutMapping,
                               // PostMapping etc.
    public Map<String, Object> status() {
        Map<String, Object> body = new HashMap<>(); // es una tabla hash basado en una implementación de la interfaz Map
                                                    // de Java, el cual será una colección de Key-value (clave-valor).;
        body.put("title", "Hola Spring boot :D");
        body.put("name", "Caleb");
        body.put("lastname", "Acosta"); // el json se ordena de por el nombre de las variables
        return body;
    }

    @GetMapping("/statusUser")
    public Map<String, Object> statusUser() {
        Map<String, Object> body = new HashMap<>(); // es una tabla hash basado en una implementación de la interfaz Map
                                                    // de Java, el cual será una colección de Key-value (clave-valor).;
        User user = new User("Caleb", "Acosta"); // utilizando objetos de java
        body.put("title", "Hola Spring boot :D");
        body.put("user", user);
        return body;
    }

    @GetMapping("/statusDto")
    public UserDto statusDto() {
        UserDto userDto = new UserDto(); // El patrón DTO tiene como finalidad de crear un objeto plano (POJO) con una
                                         // serie de atributos que puedan ser enviados o recuperados del servidor en una
                                         // sola invocación, de tal forma que un DTO puede contener información de
                                         // múltiples fuentes o tablas y concentrarlas en una única clase simple.
        User user = new User("Juan", "Perez");
        userDto.setUser(user);
        userDto.setTitle("new User");
        return userDto;
    }

    @GetMapping("/listUsers")
    public List<User> list() {
        User user = new User("Fernando", "Bermudez");
        User user2 = new User("Jaima", "Pardo");
        User user3 = new User("Frances", "ll");
        List<User> list = Arrays.asList(user, user2, user3);

        // List<User> list = new ArrayList<User>();
        // list.add(user);
        // list.add(user2);
        // list.add(user3);
        return list;
    }

}

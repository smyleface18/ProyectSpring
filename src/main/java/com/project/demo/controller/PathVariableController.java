package com.project.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.models.User;
import com.project.demo.models.dto.ParamDto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/path")
public class PathVariableController {

    @Value("${config.name}") // la anotacion values nos permite inyectar valores en este caso traer los
                             // valores de configuraciones del archivo properties
    private String name;

    // @Value("${config.code}")
    // private Integer code;

    @Value("${config.listOfValues}")
    private String listOfValues;

    @Value("#{'${config.listOfValues}'.split(',')}") // inyectamos el config.listOfValues y invocamos el metodo split
    private String[] listSplit;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Autowired // es una manera de inyectar automaticamente
    private Environment environment; // enviroment es un componenete de spring boot con el que se puede manejar las
                                     // propiedades del archivo properties

    @GetMapping("/baz/{message}") // url = /path/baz/sad pathVaraible es mas estander que RequestParam
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("baz/{message}/{id}") // con varios pathVaraible
    public Map<String, Object> baz(@PathVariable String message, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("number", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) { // este @RequestBody me especifica que voy a recibir el objecto como un
                                                 // json pero luego spring boot lo mapea a un objeto de java con
                                                 // jackson

        user.setName(user.getName().replace("a", "A"));
        return user;
    }

    @GetMapping("/for/{param}")
    public Map<String, Object> bucle(@PathVariable Integer param) {
        Integer[] vect = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Map<String, Object> map = new LinkedHashMap<>(); // LinkedHashMap no me ordena la lista
        for (int i = param; i < vect.length; i++) {
            map.put("index " + String.valueOf(i) + "  =", vect[i]);
        }
        return map;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.code}") Integer code) { // las configuraciones de properties
                                                                               // tambien se pueden inyectar por metodos
        Map<String, Object> json = new LinkedHashMap<>();
        json.put("name", name);
        json.put("code", code);
        json.put("list", listOfValues.split(","));
        json.put("listSplit", listSplit);
        json.put("valuesMap", valuesMap);
        json.put("name project", environment.getProperty("spring.application.name")); // utilizando el objeto
                                                                                      // environment
        return json;
    }

}

package com.project.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.demo.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Params")
public class ResquestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "no hay mensaje") String message) {
        // se utiliza para extraer datos de los parámetros de consulta, el required
        // especifica si es obligario o no en la URL de solicitud y defaultValue es por
        // si no la colsulta nos envia ningun dato entonces el ese sera el valor del
        // parametro
        ParamDto paramDto = new ParamDto(message);

        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam() String param, @RequestParam Integer code) { // @ResquestParam es un componente
                                                                                    // de spring el cual solo puede
                                                                                    // recibir datos
                                                                                    // primitivos los objetos se envian
                                                                                    // como json
        ParamDto params = new ParamDto(param, code);

        return params;
    }

    @GetMapping("/barModel")
    public Map<String, Object> bar(@RequestParam Integer code) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);

        return map;
    }

    @GetMapping("/barMix")
    public ParamDto bar(HttpServletRequest request) { // objeto nativo de java para extraer los parametros
        ParamDto paramDto = new ParamDto(request.getParameter("msg")); // el getParameter siempre me va a retornar un
                                                                       // string
        try {
            paramDto.setCode(Integer.parseInt(request.getParameter("code"))); // manejo de excepciones por si el code es
                                                                              // un cojunto de letras o una letra@
        } catch (NumberFormatException e) {
            paramDto.setCode(0);
        }

        return paramDto;
    }
}

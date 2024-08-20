package com.example.holamundospringdata.web;

import com.example.holamundospringdata.Dao.IPersonaDao;
import com.example.holamundospringdata.Domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class ControllerInicio {

/*Para inyectar cualquier dependencia para que sea manejada por nuestro contenedor debemos de
* agregar la anotacion @Autowired que lo que hace es inyectar la interface de IPersonaDato directamente
* para que pueda ser manejada por nuestor controlador*/

    @Autowired // -> Sirve para inyectar en nuestro controlador en este caso.
    private IPersonaDao personaDao;

    @GetMapping("/")

    public String inicio(Model model){

        var listaPersonas = personaDao.findAll();
        log.info("Ejecutando la clase ControllerInicio");
        /*Listado de objetos de tipo personas "ListaPersonas" y variable a compartir -- listaPersonas --*/
      model.addAttribute("listaPersonas", listaPersonas);


        return "index";
    }
}

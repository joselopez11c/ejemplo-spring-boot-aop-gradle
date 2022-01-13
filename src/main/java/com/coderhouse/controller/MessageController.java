package com.coderhouse.controller;

import com.coderhouse.handle.ApiRestException;
import com.coderhouse.model.Mensaje;
import com.coderhouse.model.examples.ExampleClassForMethodAnnotation;
import com.coderhouse.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coder-house")
public class MessageController {

    Logger logger = LogManager.getLogger(MessageController.class);
    @Autowired
    ExampleClassForMethodAnnotation forMethodAnnotation;
    @Autowired
    MessageService messageService;

    @GetMapping("/mensajes/example")
    public String getMensajesString() throws ApiRestException {

        logger.info("GET Request recibido string");

        forMethodAnnotation.method1();

        return "Ejemplo de respuesta";
    }

    @GetMapping("/mensajes/all")
    public List<Mensaje> getMensajesAll() {
        logger.info("GET Request recibido string");
        return dataMensajes();
    }

    @GetMapping("/mensajes")
    public List<Mensaje> getMensajesByDescription(@RequestParam String description) {
        logger.info("GET obtener mensajes que sean iguales a la descripción");
        var msjFiltered = dataMensajes().stream()
                .filter(mensajes -> mensajes.getDescription().equalsIgnoreCase(description));
        return msjFiltered.collect(Collectors.toList());
    }

    @GetMapping("/mensajes/{id}")
    public Mensaje getMensajeById(@PathVariable Long id) throws ApiRestException {
        logger.info("GET obtener mensaje por el id");

        if (id == 0) {
            logger.info("GET obtener mensaje por el id");
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }

        var msjFiltered = dataMensajes().stream()
                .filter(mensajes -> Objects.equals(mensajes.getId(), id));
        return msjFiltered.findFirst().orElse(new Mensaje(0L, "No existe el mensaje"));
    }

    @PostMapping("/mensajes")
    public Mensaje createMensaje(@RequestBody Mensaje mensaje) {
        logger.info("POST Request recibido");
        return mensaje;
    }

    @PutMapping("/mensajes/{id}")
    public Mensaje updateMensaje(@PathVariable Long id, @RequestBody Mensaje mensaje) throws ApiRestException {
        logger.info("PUT Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
        return mensaje;
    }

    @DeleteMapping("/mensajes/{id}")
    public void deleteMensaje(@PathVariable Long id) throws ApiRestException {
        logger.info("DELETE Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
    }

    private List<Mensaje> dataMensajes() {
        return List.of(
                new Mensaje(1L, "Mensaje-ABCD"),
                new Mensaje(2L, "Mensaje-ABCD"),
                new Mensaje(3L, "Mensaje-ABCD"),
                new Mensaje(4L, "Mensaje-ABCE"),
                new Mensaje(5L, "Mensaje-ABCF")
        );
    }
}

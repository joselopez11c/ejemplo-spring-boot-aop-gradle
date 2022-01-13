package com.coderhouse.model.examples;

import com.coderhouse.annotations.CustomClassAnnotation;
import com.coderhouse.annotations.CustomMethodAnnotation;
import org.springframework.stereotype.Component;

@Component
public class ExampleClassForMethodAnnotation {
    private String id;
    private String nombre;

    public ExampleClassForMethodAnnotation() {}

    public ExampleClassForMethodAnnotation(String id) {
        this.id = id;
    }

    @CustomMethodAnnotation
    public void method1() {}

    public void method2() {}

    public void method3() {}


    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


}
